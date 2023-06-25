package de.iav.currencyconverter.Service;

import de.iav.currencyconverter.model.RatesByDate;
import de.iav.currencyconverter.repository.RatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CurrencyService {

    private final RatesRepository ratesRepository;

    private final WebClient webClient=WebClient.create("https://api.frankfurter.app/");
    @Autowired
    public CurrencyService(RatesRepository ratesRepository) {
        this.ratesRepository = ratesRepository;
    }

    public List<RatesByDate> getRatesByData(){
        ResponseEntity<RatesByDate> responseEntity= webClient.get()
                .uri("2022-06-01")
                .retrieve()
                .toEntity(RatesByDate.class)
                .block();

        RatesByDate ratesByDate=Objects.requireNonNull(responseEntity).getBody();

        assert ratesByDate != null;
        ratesRepository.addRates(ratesByDate);
        System.out.println(ratesRepository.list());
        return ratesRepository.list();

    }

    public List<RatesByDate> getRatesByDateRange() {
        List<RatesByDate> ratesList = new ArrayList<>();

        //LocalDate startDate = LocalDate.parse(startDateStr);
        //LocalDate endDate = LocalDate.parse(endDateStr);
        String startDateStr = "2023-06-01";
        String endDateStr = "2023-06-10";

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            String currentDateStr = currentDate.toString();

            ResponseEntity<RatesByDate> responseEntity = webClient.get()
                    .uri(currentDateStr)
                    .retrieve()
                    .toEntity(RatesByDate.class)
                    .block();

            RatesByDate ratesByDate = Objects.requireNonNull(responseEntity).getBody();
            assert ratesByDate != null;
            ratesRepository.addRates(ratesByDate);
            ratesList.add(ratesByDate);

            // Move to the next date
            currentDate = currentDate.plusDays(1);
        }

        System.out.println(ratesRepository.list());
        return ratesRepository.list();
    }


}