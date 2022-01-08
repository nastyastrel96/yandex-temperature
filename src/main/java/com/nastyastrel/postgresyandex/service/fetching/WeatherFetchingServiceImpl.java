package com.nastyastrel.postgresyandex.service.fetching;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class WeatherFetchingServiceImpl implements WeatherFetchingService {
    private final URL URL_YANDEX_WEATHER = new URL("https://yandex.ru/pogoda/saint-petersburg?lat=59.938951&lon=30.315635");
    private final TemperatureExtractor temperatureExtractor;

    public WeatherFetchingServiceImpl(TemperatureExtractor temperatureExtractor) throws MalformedURLException {
        this.temperatureExtractor = temperatureExtractor;
    }

    @Override
    public String getTemperatureFromYandex() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(URL_YANDEX_WEATHER.openStream()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            return temperatureExtractor.getTagValues(stringBuilder.toString());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
