package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.model.SelectionTicket;
import org.example.model.Ticket;

import java.io.File;
import java.util.List;

public class TicketsParser {
    private static final String PATH = "src/main/resources/json/tickets.json";

    @SneakyThrows
    public List<Ticket> parseJson() {
        ObjectMapper mapper = new ObjectMapper();
        SelectionTicket selectionTicket = mapper.readValue(new File(PATH), SelectionTicket.class);
        return selectionTicket.getTickets();
    }
}
