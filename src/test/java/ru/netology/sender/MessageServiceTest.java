package ru.netology.sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    LocalizationService localizationService = mock(LocalizationServiceImpl.class);

    GeoService geoService = mock(GeoService.class);

    @Test
    public void testSent_Message_LocaleIsRus() {
        reset(localizationService, geoService);
        Map headers = mock(Map.class);
        when(headers.get(anyString())).thenReturn("ip.address.of.the.russia");

        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.RUSSIA);

        when(geoService.byIp(anyString())).thenReturn(location);

        when(localizationService.locale(location.getCountry())).thenCallRealMethod();

        String sentMessage = new MessageSenderImpl(geoService, localizationService).send(headers);
        assertEquals("Добро пожаловать", sentMessage);
    }

    @Test
    public void testSent_Message_LocaleIsEn() {
        reset(localizationService, geoService);
        Map headers = mock(Map.class);
        when(headers.get(anyString())).thenReturn("ip.address.of.the.usa");

        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.USA);

        when(geoService.byIp(anyString())).thenReturn(location);

        when(localizationService.locale(location.getCountry())).thenCallRealMethod();

        String sentMessage = new MessageSenderImpl(geoService, localizationService).send(headers);
        assertEquals("Welcome", sentMessage);
    }

}
