package com.poki.app.pokemon.exception;

import com.poki.app.pokemon.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(PokemonNotFoundException.class)
  public ResponseEntity<ErrorResponse> handlePokemonNotFoundException(
      PokemonNotFoundException exception) {

    ErrorResponse response =
        ErrorResponse.builder().message(exception.getMessage()).success(false).build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}
