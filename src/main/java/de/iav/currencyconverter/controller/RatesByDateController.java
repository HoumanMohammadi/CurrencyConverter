package de.iav.currencyconverter.controller;

import de.iav.currencyconverter.Service.CurrencyService;
import de.iav.currencyconverter.model.RatesByDate;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/converter")
@RequiredArgsConstructor

public class RatesByDateController {

    private final CurrencyService currencyService;

    //@GetMapping
    @PostConstruct
    List<RatesByDate> getRatesByDate(){
        return currencyService.getRatesByData();
    }

    public CurrencyService getCurrencyService() {
        return currencyService;
    }
}
