package de.iav.currencyconverter.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public record RatesByDate(double amount,
                          String base,
                          String date,
                          //@JsonProperty("rates")
                          Rate rates) {
}
