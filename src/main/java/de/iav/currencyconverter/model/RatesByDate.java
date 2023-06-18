package model;

import java.util.Date;

public record RatesByDate(double amount,
                          String base,
                          Date date,
                          Rate rates) {
}
