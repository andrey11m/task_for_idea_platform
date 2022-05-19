package org.example.service;

import org.example.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    public void printAverageInflightTime(List<Ticket> tickets) {
        Duration totalDuration = Duration.ZERO;
        int ticketsAmount = 0;
        for (Ticket ticket : tickets) {
            totalDuration = totalDuration.plus(getInflightDuration(ticket));
            ticketsAmount++;
        }
        Duration averageDuration = totalDuration.dividedBy(ticketsAmount);
        System.out.println("Average inflight time: " + averageDuration);
    }

    public void printPercentile(List<Ticket> tickets, int percentile) {
        List<Duration> inflightDurations = tickets.stream().map(this::getInflightDuration).sorted().collect(Collectors.toList());
        int position = (inflightDurations.size() + 1) * (percentile);
        int part = position % 100;
        int index = (position - part) / 100;
        Duration result = inflightDurations.get(index)
                .minus(inflightDurations.get(index - 1))
                .multipliedBy(part).dividedBy(100)
                .plus(inflightDurations.get(index - 1));
        System.out.println(percentile + "th exclusive percentiles is " + result);
    }

    private Duration getInflightDuration(Ticket ticket) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        LocalDateTime departure = LocalDateTime.parse(ticket.getDepartureDate() + " " + ticket.getDepartureTime(), formatter);
        LocalDateTime arrival = LocalDateTime.parse(ticket.getArrivalDate() + " " + ticket.getArrivalTime(), formatter);
        return Duration.between(departure, arrival);
    }
}
