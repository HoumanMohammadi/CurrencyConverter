package de.iav.currencyconverter.Service;

import de.iav.currencyconverter.model.Rate;
import de.iav.currencyconverter.model.RatesByDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class CurrencyService {

    private final WebClient webClient=WebClient.create("https://api.frankfurter.app/");

    public RatesByDate getRatesByData(){
        ResponseEntity<RatesByDate> responseEntity= webClient.get()
                .uri("latest")
                .retrieve()
                .toEntity(RatesByDate.class)
                .block();

        RatesByDate ratesByDate=Objects.requireNonNull(responseEntity).getBody();

        assert ratesByDate != null;
        return new RatesByDate(ratesByDate.amount()+15
        , ratesByDate.base(), ratesByDate.date(), ratesByDate.rates());

    }
}