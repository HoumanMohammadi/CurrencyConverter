package Service;

import model.CurrencyConverterResponse;
import model.Rate;
import model.RatesByDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import repository.RatesRepository;

import java.util.Date;
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
        CurrencyConverterResponse responseEntity = Objects.requireNonNull(webClient.get()
                        .uri("/latest")
                        .retrieve()
                        .toEntity(CurrencyConverterResponse.class)
                        .block())
                .getBody();

        Objects.requireNonNull(responseEntity);
        return responseEntity.results();
    }
}