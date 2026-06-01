package com.poki.app.pokemon.client;

import com.poki.app.pokemon.dto.response.PokemonApiResponse;
import com.poki.app.pokemon.exception.PokemonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PokeApiClient {

    private static final String BASE_URL =
            "https://pokeapi.co/api/v2/pokemon/";

    private final RestTemplate restTemplate;

    public PokemonApiResponse fetchPokemon(String name) {

        try {
            String url = BASE_URL + name.toLowerCase();

            return restTemplate.getForObject(
                    url,
                    PokemonApiResponse.class
            );

        } catch (HttpClientErrorException.NotFound ex) {

            throw new PokemonNotFoundException(
                    "Pokemon not found: " + name
            );

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to fetch pokemon details",
                    ex
            );
        }
    }
}