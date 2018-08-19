package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TicketBookingDao;
import com.example.demo.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	@Cacheable(value="ticketsCache",key="#ticketId")
	/*
	 * Puts the return value with key specified.
	 */
	public Optional<Ticket> getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
	}
	
	@CacheEvict(value="ticketsCache",key="#ticketId")
	/*
	 * Remove Entry from the Cache.
	 */
	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}
	
	@CachePut(value="ticketsCache",key="#ticketId")
	/*
	 * always executes the method body and updates caches, where as cachable if available in cache will return value from there.
	 */
	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Optional<Ticket> ticketFromDb = ticketBookingDao.findById(ticketId);
		ticketFromDb.get().setEmail(newEmail);
		Ticket upadedTicket = ticketBookingDao.save(ticketFromDb.get());
		return upadedTicket;
	}
}
