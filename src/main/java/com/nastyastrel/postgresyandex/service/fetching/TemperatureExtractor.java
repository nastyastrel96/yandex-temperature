package com.nastyastrel.postgresyandex.service.fetching;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TemperatureExtractor {
    private final Pattern TAG_REGEX = Pattern.compile("Текущая температура</span><span class=\"temp__value temp__value_with-unit\">(.+?)</span>");

    public String getTagValues(final String yandexWeatherValue) {
        final Matcher matcher = TAG_REGEX.matcher(yandexWeatherValue);
        String temperature = "";
        while (matcher.find()) {
            temperature = matcher.group(1);
        }
        return temperature;
    }
}
