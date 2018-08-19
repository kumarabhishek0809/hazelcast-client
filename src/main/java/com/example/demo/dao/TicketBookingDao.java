package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
