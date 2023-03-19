package com.raja.gradedassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raja.gradedassignment.entity.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Integer> {

	 @Query(value = "select * from Ticket t where t.t_title like %:keyword% or t.t_short like %:keyword%", nativeQuery = true)
	List<Ticket> getByKeyword(String keyword);

}
