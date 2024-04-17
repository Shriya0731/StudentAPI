package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,String> {

	List<Event> findByCno(int cno);
	Event findByCnoAndEventname(int cno,String eventname);
	

   //@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
}