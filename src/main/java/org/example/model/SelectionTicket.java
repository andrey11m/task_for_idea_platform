package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class SelectionTicket {
    private List<Ticket> tickets;
}
