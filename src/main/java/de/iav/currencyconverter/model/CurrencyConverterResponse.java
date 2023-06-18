package model;

import java.util.List;

public record CurrencyConverterResponse {
    Object info,
    List<RatesByDate> ratesByDates;
}
