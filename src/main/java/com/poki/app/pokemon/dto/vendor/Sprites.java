package com.poki.app.pokemon.dto.vendor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sprites {

  @JsonProperty("front_default")
  private String frontDefault;
}
