package com.poki.app.pokemon.controller;

import com.poki.app.pokemon.dto.response.PokemonResponseDto;
import com.poki.app.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
public class PokemonController {

  private final PokemonService pokemonService;

  @GetMapping("/{name}")
  public ResponseEntity<PokemonResponseDto> getPokemon(@PathVariable String name) {
    PokemonResponseDto pokemonResponseDto = pokemonService.getPokemon(name);

    return ResponseEntity.ok(pokemonResponseDto);
  }
}
