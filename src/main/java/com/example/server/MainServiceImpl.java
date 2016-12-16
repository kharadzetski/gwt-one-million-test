package com.example.server;

import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.client.MainService;
public class MainServiceImpl extends AutowiringRemoteServiceServlet implements
		MainService {

	private static final long serialVersionUID = 0L;

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void generateRandomPersons(long quantity) {
		Session s = sf.openSession();
		s.getNamedQuery("callGenerateUsers").setParameter("quantity", quantity).executeUpdate();
		s.close();
	}
	
	@PreDestroy
	public void preDestroy() {
		Session s = sf.openSession();
		s.createSQLQuery("CHECKPOINT").executeUpdate();
		s.close();
	}

}
