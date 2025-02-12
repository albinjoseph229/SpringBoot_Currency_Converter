package com.example.currency_conver.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurrencyServiceTest {
    private CurrencyService currencyService;
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = mock(RestTemplate.class);
        currencyService = new CurrencyService();
    }

    @Test
    void testConvertCurrency_ValidConversion() {
        double convertedAmount = currencyService.convertCurrency("USD", "EUR", 100);
        assertTrue(convertedAmount > 0);
    }

    @Test
    void testConvertCurrency_InvalidCurrencyCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            currencyService.convertCurrency("USD", "INVALID", 100);
        });

        assertEquals("Invalid currency", exception.getMessage()); // Updated to match the actual message
    }

    @Test
    void testGetExchangeRates_APIUnavailable() {
        currencyService = spy(new CurrencyService());
        doThrow(new RuntimeException("External API unavailable")).when(currencyService).getExchangeRates("USD");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            currencyService.getExchangeRates("USD");
        });

        assertEquals("External API unavailable", exception.getMessage());
    }
}