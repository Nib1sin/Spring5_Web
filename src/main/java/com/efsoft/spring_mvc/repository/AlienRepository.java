package com.efsoft.spring_mvc.repository;

import java.util.List;

import javax.transaction.Transactional;

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

	
	@Transactional
	public void addAlien(Alien a){
		Session session = sessionFactory.getCurrentSession();
		session.save(a);
	}
	
	@Transactional
	public List<Alien> getAliens(){
		Session session = sessionFactory.getCurrentSession();
		List<Alien> aliens = session.createQuery("from Alien", Alien.class).list();
		return aliens;
	}
	
	@Transactional
	public Alien getAlien(int aid){
		Session session = sessionFactory.getCurrentSession();
		Alien alien = session.get(Alien.class, aid);
		return alien;
	}
	
}
