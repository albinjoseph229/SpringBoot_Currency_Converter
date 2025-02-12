package com.example.currency_conver.controller;

import com.example.currency_conver.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Currency Conversion", description = "APIs for currency conversion and exchange rates")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Get Exchange Rates", description = "Retrieves real-time exchange rates for a given base currency.",
            responses = {
                @ApiResponse(responseCode = "200", description = "Successful retrieval"),
                @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @GetMapping("/rates")
    public Map<String, Double> getRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyService.getExchangeRates(base);
    }

    @Operation(summary = "Convert Currency", description = "Converts an amount from one currency to another.",
            responses = {
                @ApiResponse(responseCode = "200", description = "Successful conversion",
                             content = @Content(mediaType = "application/json",
                             schema = @Schema(implementation = Double.class))),
                @ApiResponse(responseCode = "400", description = "Invalid input"),
                @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @PostMapping("/convert")
    public double convertCurrency(@RequestBody CurrencyRequest request) {
        return currencyService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());
    }

    public static class CurrencyRequest {
        private String from;
        private String to;
        private double amount;

        public String getFrom() { return from; }
        public String getTo() { return to; }
        public double getAmount() { return amount; }
    }
}