package com.pburgov.hibernate.enums;

import com.pburgov.hibernate.enums.entity.Status;
import com.pburgov.hibernate.enums.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentEnumApp {

    public static void main( String[] args ) {

        SessionFactory factory = new Configuration()
                                     .configure("hibernate.cfg.xml")
                                     .addAnnotatedClass(Student.class)
                                     .addAnnotatedClass(Status.class)
                                     .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Student student1 = new Student("Pedro", "García", "pgarcia@gmail.com", Status.ACTIVE);
            Student student2 = new Student("Juan", "Pérez", "jperez@gmail.com", Status.INACTIVE);

            session.beginTransaction();

            System.out.println("Guardando los estudiantes");
            session.save(student1);
            session.save(student2);
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
