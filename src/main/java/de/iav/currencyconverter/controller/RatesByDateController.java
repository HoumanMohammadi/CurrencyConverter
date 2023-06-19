package de.iav.currencyconverter.controller;

import de.iav.currencyconverter.Service.CurrencyService;
import de.iav.currencyconverter.model.RatesByDate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
@RequiredArgsConstructor

public class RatesByDateController {

    private final CurrencyService currencyService;

    @GetMapping
    RatesByDate getRatesByDate(){
        return currencyService.getRatesByData();
    }
}
