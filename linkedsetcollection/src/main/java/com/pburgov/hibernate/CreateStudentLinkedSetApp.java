package com.pburgov.hibernate;

import com.pburgov.hibernate.entity.Student;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentLinkedSetApp {

    public static void main( String[] args ) {
        saveStudent();
    }

    private static void saveStudent() {
        SessionFactory factory = new Configuration()
                                     .configure("hibernate.cfg.xml")
                                     .addAnnotatedClass(Student.class)
                                     .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("Pedro", "García", "pgarcia@gmail.com");
            Set <String> images = student.getImages();
            images.add("foto1.jpg");
            images.add("foto2.jpg");
            images.add("foto3.jpg");
            images.add("foto4.jpg");

            session.beginTransaction();

            System.out.println("Guardando el objeto");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Transacción finalizada!!");

        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
