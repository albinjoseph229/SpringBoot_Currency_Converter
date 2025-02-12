package com.example.currency_conver.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {
    private final Map<String, Double> exchangeRates;

    public CurrencyService() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("INR", 82.5);
        exchangeRates.put("EUR", 0.91);
    }

    public Map<String, Double> getExchangeRates(String base) {
        return exchangeRates;
    }

    public double convertCurrency(String from, String to, double amount) {
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency");
        }
        double rate = exchangeRates.get(to) / exchangeRates.get(from);
        return amount * rate;
    }
}