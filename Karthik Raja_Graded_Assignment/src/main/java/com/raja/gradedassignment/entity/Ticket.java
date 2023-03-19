package com.raja.gradedassignment.entity;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import lombok.Data;

@Entity
@Table(name="ticket")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	String tTitle,tShort,tContent;
	
//	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//	private LocalDate tCreated;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate tCreated;
	
	@PrePersist
	public void create()
	{
		LocalDate date = LocalDate.now();
		System.out.println(date);
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
		String text = date.toString(dtfOut);
		LocalDate parsedDate = LocalDate.parse(text,dtfOut);
//		System.out.println(text);
		this.tCreated= parsedDate;		
	}

//	2023-03-17T23:40:14.211+05:30
//	2023-03-17T23:46:37.282+05:30	
//	2023-03-17T23:47:04.932+05:30

}
