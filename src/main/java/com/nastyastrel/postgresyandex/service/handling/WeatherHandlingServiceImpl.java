package com.nastyastrel.postgresyandex.service.handling;

import com.nastyastrel.postgresyandex.model.Weather;
import com.nastyastrel.postgresyandex.repository.WeatherRepository;
import com.nastyastrel.postgresyandex.service.fetching.WeatherFetchingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class WeatherHandlingServiceImpl implements WeatherHandlingService {
    private final WeatherFetchingService weatherFetchingService;
    private final WeatherRepository weatherRepository;

    public WeatherHandlingServiceImpl(WeatherFetchingService weatherFetchingService, WeatherRepository weatherRepository) {
        this.weatherFetchingService = weatherFetchingService;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Weather findCurrentTemperature() {
        return findByDate(LocalDate.now()).orElseGet(this::saveTemperatureFromYandex);
    }

    private Optional<Weather> findByDate(LocalDate date) {
        return weatherRepository.findWeatherByDateEquals(date);
    }

    private Weather saveTemperatureFromYandex() {
        weatherRepository.save(new Weather(LocalDate.now(), weatherFetchingService.getTemperatureFromYandex()));
        return weatherRepository.findWeatherByDateEquals(LocalDate.now()).orElseThrow(RuntimeException::new);
    }
}
