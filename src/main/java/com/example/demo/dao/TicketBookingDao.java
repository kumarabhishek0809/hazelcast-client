package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Ticket;

public interface TicketBookingDao extends JpaRepository<Ticket, Integer>{

}
