package repository;

import model.RatesByDate;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository

public class RatesRepository {
    private final Map<Date, RatesByDate> ratesRepository;


    public RatesRepository(Map<Date, RatesByDate> ratesRepository) {
        this.ratesRepository = ratesRepository;
    }

    public void addRates(RatesByDate ratesByDate){
        this.ratesRepository.put(ratesByDate.date(), ratesByDate);
    }

    public RatesByDate getRatesByDate (Date date){
        if (this.ratesRepository.containsKey(date)){
            return this.ratesRepository.get(date);
        }else throw new NoSuchElementException("Information on this date not available! ");
    }

    public List<RatesByDate> list(){
        return new ArrayList<RatesByDate>(this.ratesRepository.values());
    }


}
