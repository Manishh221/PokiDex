package com.poki.app.pokemon.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import com.poki.app.pokemon.dto.response.PokemonResponseDto;
import com.poki.app.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
@Slf4j
public class PokemonController {

    private final CacheManager cacheManager;
    private final PokemonService pokemonService;

    @GetMapping("/{name}")
    public ResponseEntity<PokemonResponseDto> getPokemon(@PathVariable String name) {
        log.info("Received request for pokemon {}", name);
        PokemonResponseDto pokemonResponseDto = pokemonService.getPokemon(name);
        return ResponseEntity.ok(pokemonResponseDto);
    }

    @GetMapping("/cache/stats")
    public Map<String, Object> cacheStats() {

        CaffeineCache cache =
                (CaffeineCache) cacheManager.getCache("pokemon");

        Cache<Object, Object> nativeCache =
                cache.getNativeCache();

        CacheStats stats = nativeCache.stats();

        Map<String, Object> response = new HashMap<>();

        response.put("hitCount", stats.hitCount());
        response.put("missCount", stats.missCount());

        return response;
    }
}
