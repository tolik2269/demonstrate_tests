package ru.netology.sender;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

LocalizationService localizationService= new LocalizationServiceImpl();


    @Test
    public void testReturned_Text_Russia(){
        String locale = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", locale);
    }



    @Test
    public void testReturned_Text_Default(){
        String locale = localizationService.locale(Country.USA);
        assertEquals("Welcome", locale);
    }
}
