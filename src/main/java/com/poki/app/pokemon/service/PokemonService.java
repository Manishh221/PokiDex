package com.poki.app.pokemon.service;

import com.poki.app.pokemon.dto.response.PokemonResponseDto;

public interface PokemonService {

  PokemonResponseDto getPokemon(String name);
}
