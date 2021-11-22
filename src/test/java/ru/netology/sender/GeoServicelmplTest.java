package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServicelmplTest {

    GeoService geoService = new GeoServiceImpl();

    @Test
    public void testLocation_IpRelates_ToRussia() {
        Location location = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    public void testLocation_IpRelates_ToUSA() {
        Location location = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        assertEquals(Country.USA, location.getCountry());
    }

}
