package com.raja.gradedassignment.service;
import java.util.List;
import com.raja.gradedassignment.entity.Ticket;

public interface TicketServiceInterface {

	public List<Ticket> findAll();
	public Ticket findById(int id);
	public void save(Ticket ticket);
	public void deleteById(int id);
}
