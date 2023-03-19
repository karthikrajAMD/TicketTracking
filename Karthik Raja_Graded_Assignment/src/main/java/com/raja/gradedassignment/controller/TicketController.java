package com.raja.gradedassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raja.gradedassignment.entity.Ticket;
import com.raja.gradedassignment.service.TicketSVC;

@Controller
@RequestMapping("/")
public class TicketController {

	@Autowired
	TicketSVC ticketsvc;

	@RequestMapping("/getAll")
	public String findall(Model model) {

		List<Ticket> t = ticketsvc.findAll();
		model.addAttribute("AllTicket", t);
		return "TicketList";
	}

	@RequestMapping("/search")
	public String search(String keyword, Model model) {
		System.out.println(keyword);
		if (keyword != null) {
			List<Ticket> t = ticketsvc.getByKeyword(keyword.toLowerCase());
			model.addAttribute("AllTicket", t);
		} else {
			List<Ticket> t = ticketsvc.findAll();
			model.addAttribute("AllTicket", t);
		}
		return "TicketList";
	}

	@RequestMapping("/delete")
	public String deleteTicket(@RequestParam(value = "ticketId") int bid) {
		ticketsvc.deleteById(bid);
		return "redirect:/getAll";
	}

	@RequestMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket myTicket, Model model) {
		System.out.println(myTicket);
		ticketsvc.save(myTicket);
		return "redirect:/getAll";
	}

	@RequestMapping("/CreateTicket")
	public String addTicket(Model model) {
		Ticket t = new Ticket();
		String edit = "Create Ticket";
		model.addAttribute("pageName", edit);
		model.addAttribute("ticket", t);
		return "TicketForm";
	}

	@RequestMapping("/UpdateTicket")
	public String updateTicket(@RequestParam(value = "tId") int ticketid, Model model) {
		Ticket ticket = ticketsvc.findById(ticketid);
		System.out.println(ticket);
		String edit = "Edit Ticket";
		model.addAttribute("pageName", edit);
		model.addAttribute("ticket", ticket);

		return "TicketForm";
	}
	@RequestMapping("/view")
	public String viewTicket(@RequestParam(value = "tId") int ticketid, Model model) {
		Ticket ticket = ticketsvc.findById(ticketid);
		System.out.println(ticket);
		String edit = ticket.getTTitle();
		model.addAttribute("message", edit);
		model.addAttribute("ticket", ticket);

		return "TicketView";
	}

}
