package com.nastyastrel.postgresyandex.service.handling;

import com.nastyastrel.postgresyandex.model.Weather;

public interface WeatherHandlingService {
    Weather findCurrentTemperature();
}
