package com.poki.app.pokemon.dto.vendor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateWrapper {

  @JsonProperty("base_stat")
  private Integer baseStat;

  private StatInfo stat;
}
