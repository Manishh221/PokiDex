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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiClient pokeApiClient;

    @Override
    public PokemonResponseDto getPokemon(String name) {

        PokemonApiResponse pokemon =
                pokeApiClient.fetchPokemon(name);

        return mapToResponse(pokemon);
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
                .build();
    }
}