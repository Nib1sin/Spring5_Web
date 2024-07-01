package com.efsoft.spring_mvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.efsoft.spring_mvc.model.Alien;

@Component
public class AlienRepository {
	
	//Llamo al sessionFactory definido en el xml. id="sessionFactory"
	@Autowired
	private SessionFactory sessionFactory;

	public List<Alien> getAliens(){
		Session session = sessionFactory.getCurrentSession();
		List<Alien> aliens = session.createQuery("from Alien", Alien.class).list();
		return aliens;
	}
	
}
