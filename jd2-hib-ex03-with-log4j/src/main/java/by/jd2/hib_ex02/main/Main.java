package by.jd2.hib_ex02.main;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex02.bean.User;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			User user = new User("Bob", "Dou", "dou1@mail.com.by", "passwordstub", "saltstub", new Timestamp(System.currentTimeMillis()));

			session.save(user);
			
			System.out.println("id=" + user.getUserId());
			
			session.getTransaction().commit();

			System.out.println("Done!");
		
		} finally {
			factory.close();
		}
	}

}
