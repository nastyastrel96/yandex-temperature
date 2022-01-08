package com.nastyastrel.postgresyandex.rest;

import com.nastyastrel.postgresyandex.model.Weather;
import com.nastyastrel.postgresyandex.service.handling.WeatherHandlingService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {
    private final WeatherHandlingService weatherService;

    public WeatherController(WeatherHandlingService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Weather findCurrentTemperature() {
        return weatherService.findCurrentTemperature();
    }
}
