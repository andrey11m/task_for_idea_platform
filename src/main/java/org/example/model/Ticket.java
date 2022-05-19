package org.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import static org.example.util.TagString.*;

@Data
public class Ticket {

    private String origin;

    @JsonAlias({TAG_ORIGIN_NAME})
    private String originName;

    private String destination;

    @JsonAlias({TAG_DESTINATION_NAME})
    private String destinationName;

    @JsonAlias({TAG_DEPARTURE_DATE})
    private String departureDate;

    @JsonAlias({TAG_DEPARTURE_TIME})
    private String departureTime;

    @JsonAlias({TAG_ARRIVAL_DATE})
    private String arrivalDate;

    @JsonAlias({TAG_ARRIVAL_TIME})
    private String arrivalTime;

    private String carrier;

    private int stops;

    private int price;
}
