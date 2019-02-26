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

			User user = new User("Bob", "Dou", "dou@mail.com.by", "passwordstub", "saltstub", new Timestamp(System.currentTimeMillis()));

			session.save(user);
			
			System.out.println("id=" + user.getUserId());
			
			session.getTransaction().commit();

			System.out.println("Done!");
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/*session.beginTransaction();

			User user = (User) session.createQuery("from User where first_name='Bob'").list().get(0);

			System.out.println("\nGetting user with id: " + user.getUserId());

			session.delete(user);

			session.getTransaction().commit();

			System.out.println("Done!");*/
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/*session.beginTransaction();

			User user = (User) session.createQuery("from User where first_name='Bob'").list().get(0);

			System.out.println("\nGetting user with id: " + user.getUserId());

			session.createQuery("delete from User where id=" + user.getUserId()).executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");*/
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			/*session.beginTransaction();

			User user = session.get(User.class, 9);

			System.out.println(user.getFirstName());

			session.getTransaction().commit();

			System.out.println("Done!");*/
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			
		} finally {
			factory.close();
		}
	}

}
