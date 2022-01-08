package com.nastyastrel.postgresyandex.repository;

import com.nastyastrel.postgresyandex.model.Weather;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WeatherRepository extends CrudRepository<Weather, LocalDate> {
    Optional<Weather> findWeatherByDateEquals(LocalDate date);
}
