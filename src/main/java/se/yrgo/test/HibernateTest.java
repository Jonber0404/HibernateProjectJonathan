package se.yrgo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Tutor newTutor = new Tutor("TUTOR1", "Jan Jansson", 10000);
        Student student1 = new Student("Sven Antenn");
        Student student2 = new Student("Cool Mario");
        Student student3 = new Student("Foppatoffel");
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);

        Tutor myTutor = (Tutor) session.get(Tutor.class, 50);
        List<Student> students = myTutor.getTeachingGroup();
        for (Student student : students) {
            System.out.println(student);
        }

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
