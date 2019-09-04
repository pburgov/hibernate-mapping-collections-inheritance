package com.pburgov.hibernate.tableperclass;

import com.pburgov.hibernate.tableperclass.entity.Instructor;
import com.pburgov.hibernate.tableperclass.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTablePerClassApp {

    public static void main( String[] args ) {

        saveUsers();
    }

    private static void saveUsers() {
        SessionFactory factory = new Configuration()
                                     .configure("hibernate.cfg.xml")
                                     .addAnnotatedClass(Instructor.class)
                                     .addAnnotatedClass(Student.class)
                                     .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("Pedro", "García", "pgarcia@gmail.com", "Hibernate");
            Instructor instructor = new Instructor("Juan", "Pérez", "jperez@gmail.com", 2000.0);

            session.beginTransaction();

            System.out.println("Guardando el estudiante y el instructor:");
            session.save(student);
            session.save(instructor);

            session.getTransaction().commit();
            System.out.println("Transacción Finalizada!!");

        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
