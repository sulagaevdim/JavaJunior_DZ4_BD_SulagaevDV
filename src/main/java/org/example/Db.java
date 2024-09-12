package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.sql.SQLOutput;
import java.util.List;

public class Db {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String password = "root";

    public static void addCourse(String name, int duration) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory = new MetadataSources( registry
        ).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Course course = new Course(name, duration);
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();

    }
    public static void printCourses(Session session) {
        List<Course> list = session.createQuery("FROM Course ", Course.class).getResultList();
            list.forEach(System.out::println);
    }
    public static void editCourse(Session session, int id, String newName, int newDuration) {
        try {
            String hql = "from Course where id = :id";
            Query<Course> query = session.createQuery( hql, Course.class);
            query.setParameter("id", id);
            Course course = query.getSingleResult();
            System.out.println(course);
            course.setDuration(newDuration);
            course.setName(newName);
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("ИЗМЕНЕНИЕ КУРСА: Не найдена строка с введенным ID!");
        }

    }
    public static void delCourses(Session session) {
        Transaction t = session.beginTransaction();
        List<Course> books = session.createQuery("FROM Course ",
                Course.class).getResultList();
        books.forEach(b -> {
            session.delete(b);
        });
        t.commit();
    }
}
