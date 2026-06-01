package com.poki.app.pokemon.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {

    return new WebMvcConfigurer() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {

        registry
            .addMapping("/**")
            .allowedOrigins("http://127.0.0.1:5500")
            .allowedMethods("GET")
            .allowCredentials(true);
      }
    };
  }


  @Bean
  public CacheManager cacheManager() {

    CaffeineCacheManager cacheManager =
            new CaffeineCacheManager("pokemon");

    cacheManager.setCaffeine(
            Caffeine.newBuilder()
                    .maximumSize(100)
                    .expireAfterWrite(
                            Duration.ofMinutes(10)
                    )
                    .recordStats()
    );

    return cacheManager;
  }
}
