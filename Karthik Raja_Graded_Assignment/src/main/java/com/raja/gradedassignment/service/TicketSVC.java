package com.raja.gradedassignment.service;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raja.gradedassignment.dao.TicketDAO;
import com.raja.gradedassignment.entity.Ticket;

@Service
public class TicketSVC implements TicketServiceInterface{

	@Autowired
	TicketDAO ticketdao;
	
	@Override
	public List<Ticket> findAll() {
		
		
		return ticketdao.findAll();
	}

	@Override
	public Ticket findById(int id) {
		
		Ticket ticket=ticketdao.findById(id).get();
		return ticket;
	}

	@Override
	public void save(Ticket ticket) {

		ticketdao.save(ticket);
	}

	@Override
	public void deleteById(int id) {
		
		ticketdao.deleteById(id);
	}

	public List<Ticket> getByKeyword(String keyword) {
		List<Ticket> t = ticketdao.getByKeyword(keyword);
		return t;
	}

}
