package de.iav.currencyconverter;

import de.iav.currencyconverter.Service.CurrencyService;
import de.iav.currencyconverter.repository.RatesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConverterApplication {


    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterApplication.class, args);

    }



}
