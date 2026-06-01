package com.poki.app.pokemon.service.serviceImpl;

import com.poki.app.pokemon.client.PokeApiClient;
import com.poki.app.pokemon.dto.response.PokemonResponseDto;
import com.poki.app.pokemon.dto.vendor.AbilityInfo;
import com.poki.app.pokemon.dto.vendor.AbilityWrapper;
import com.poki.app.pokemon.dto.response.PokemonApiResponse;
import com.poki.app.pokemon.dto.vendor.TypeInfo;
import com.poki.app.pokemon.dto.vendor.TypeWrapper;
import com.poki.app.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiClient pokeApiClient;

    @Override
    @Cacheable(value = "pokemon", key = "#name.toLowerCase()")
    public PokemonResponseDto getPokemon(String name) {

        log.info("Fetching pokemon from external API: {}", name);

        PokemonApiResponse response = pokeApiClient.fetchPokemon(name);

        log.info("Successfully fetched pokemon: {}", name);

        return mapToResponse(response);
    }

    private PokemonResponseDto mapToResponse(
            PokemonApiResponse pokemon) {

        List<String> types =
                pokemon.getTypes()
                        .stream()
                        .map(TypeWrapper::getType)
                        .map(TypeInfo::getName)
                        .toList();

        List<String> abilities =
                pokemon.getAbilities()
                        .stream()
                        .map(AbilityWrapper::getAbility)
                        .map(AbilityInfo::getName)
                        .toList();

        return PokemonResponseDto.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .image(
                        pokemon.getSprites() != null
                                ? pokemon.getSprites().getFrontDefault()
                                : null
                )
                .height(pokemon.getHeight())
                .weight(pokemon.getWeight())
                .baseExperience(
                        pokemon.getBaseExperience()
                )
                .types(types)
                .abilities(abilities)
                .stats(pokemon.getStats())
                .source("External_API")
                .build();
    }
}