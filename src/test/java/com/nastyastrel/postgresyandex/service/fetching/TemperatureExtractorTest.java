package com.nastyastrel.postgresyandex.service.fetching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TemperatureExtractorTest {
    private TemperatureExtractor underTest;

    @BeforeEach
    void setUp() {
        underTest = new TemperatureExtractor();
    }

    @Test
    void itShouldGetNecessaryTagValueFromHtml() {
        //given
        String yandexHtml = "href=\"/pogoda/details?lat=59.938951&amp;lon=30.315635&amp;via=mf#7\" data-bem='{\"link\":{},\"day-anchor\":{\"anchor\":7}}'><div class=\"temp fact__temp fact__temp_size_s\" role=\"text\"><span class=\"temp__pre-a11y a11y-hidden\">Текущая температура</span><span class=\"temp__value temp__value_with-unit\">−10</span></div><img class=\"icon icon_color_light icon_size_48 icon_thumb_skc-n fact__icon\" aria-hidden=\"true\" src=\"//yastatic.net/weather/i/icons/funky/light/skc_n.svg\"/";

        //then
        assertEquals("−10", underTest.getTagValues(yandexHtml), "Return necessary temperature value");
    }
}