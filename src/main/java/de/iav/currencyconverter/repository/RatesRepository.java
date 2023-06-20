package de.iav.currencyconverter.repository;

import de.iav.currencyconverter.model.RatesByDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository

public class RatesRepository {
    private final Map<String, RatesByDate> ratesRepository;


    public RatesRepository(Map<String, RatesByDate> ratesRepository) {
        this.ratesRepository = ratesRepository;
    }

    public void addRates(RatesByDate ratesByDate){
        this.ratesRepository.put(ratesByDate.date(), ratesByDate);
    }

    public RatesByDate getRatesByDate (String date){
        if (this.ratesRepository.containsKey(date)){
            return this.ratesRepository.get(date);
        }else throw new NoSuchElementException("Information on this date not available! ");
    }

    public List<RatesByDate> list(){
        return new ArrayList<RatesByDate>(this.ratesRepository.values());
    }


}
