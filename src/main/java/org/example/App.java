package org.example;

import org.example.model.Ticket;
import org.example.service.TicketService;
import org.example.util.TicketsParser;

import java.util.List;

public class App {
    public static void main(String[] args) {
        TicketsParser parser = new TicketsParser();
        TicketService ticketService = new TicketService();
        List<Ticket> tickets = parser.parseJson();
        ticketService.printAverageInflightTime(tickets);
        ticketService.printPercentile(tickets, 90);
    }
}
