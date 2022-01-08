package com.nastyastrel.postgresyandex.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "weather_history")
public class Weather {
    @Id
    @Column(name = "weather_date")
    private LocalDate date;

    @Column(name = "weather_value")
    private String temperature;

    public Weather() {
    }

    public Weather(LocalDate date, String temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(date, weather.date) && Objects.equals(temperature, weather.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, temperature);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date=" + date +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
