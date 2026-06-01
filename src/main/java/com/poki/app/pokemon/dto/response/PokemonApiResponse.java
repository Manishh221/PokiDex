package com.poki.app.pokemon.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poki.app.pokemon.dto.vendor.AbilityWrapper;
import com.poki.app.pokemon.dto.vendor.Sprites;
import com.poki.app.pokemon.dto.vendor.StateWrapper;
import com.poki.app.pokemon.dto.vendor.TypeWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor@
        AllArgsConstructor
public class PokemonApiResponse {

    private ErrorResponse errorResponse;

    private Integer id;

    private String name;

    private Integer height;

    private Integer weight;

    @JsonProperty("base_experience")
    private Integer baseExperience;

    private Sprites sprites;

    private List<TypeWrapper> types;

    private List<AbilityWrapper> abilities;

    private List<StateWrapper> stats;
}