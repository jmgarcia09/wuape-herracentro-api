package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.Ticket;
import com.wuape.herracentro.repository.IncidenceRepository;
import com.wuape.herracentro.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 19/03/2018.
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final IncidenceRepository incidenceRepository;
    private final TicketRepository ticketRepository;

    public TicketController(IncidenceRepository incidenceRepository, TicketRepository ticketRepository) {
        this.incidenceRepository = incidenceRepository;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        //First, save the incidence to add then to the ticket.
        incidenceRepository.save(ticket.getIncidence());
        return ResponseEntity.ok(ticketRepository.save(ticket));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Ticket> updateTicket(@PathVariable(name = "id") Long id, @RequestBody Ticket ticket) {
        Ticket currentTicket = ticketRepository.findOne(id);

        Assert.notNull(currentTicket, "Ticket with id [" + id + "] cannot be found.");
        if (currentTicket.getId() == 0 || currentTicket.getId() != id) {
            ticket.setId(id);
        }
        ticket = ticketRepository.save(ticket);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Ticket> findTicketById(@PathVariable(name = "id") Long id) {
        Ticket ticket = ticketRepository.findOne(id);

        Assert.notNull(ticket, "Client Store with id [" + id + "] cannot be found.");
        return ResponseEntity.ok(ticket);
    }

    @GetMapping()
    private Iterable<Ticket> listAllTickets() {
        return ticketRepository.findAll();
    }


}
