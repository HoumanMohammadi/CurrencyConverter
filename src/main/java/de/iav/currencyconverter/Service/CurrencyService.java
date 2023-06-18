package de.iav.currencyconverter.Service;

import de.iav.currencyconverter.model.CurrencyConverterResponse;
import de.iav.currencyconverter.model.RatesByDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class CurrencyService {

    private final WebClient webClient;

    public CurrencyService(
            @Value("${currency.url}")
            String webclientUrl) {
        webClient = WebClient.create(webclientUrl);
    }


    public List<RatesByDate> getAllRates() {
        CurrencyConverterResponse responseEntity = webClient.get()
                .uri("/latest")
                .retrieve()
                .toEntity(CurrencyConverterResponse.class)
                .block()
                .getBody();

        Objects.requireNonNull(responseEntity);
        return responseEntity.ratesByDates();
    }
}