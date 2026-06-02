package com.poki.app.pokemon.dto.response;

import com.poki.app.pokemon.dto.vendor.StateWrapper;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonResponseDto {

  private Integer id;
  private String name;

  private Integer height;

  private Integer weight;

  private String image;

  private Integer baseExperience;

  private List<StateWrapper> stats;

  private List<String> types;

  private List<String> abilities;

}
