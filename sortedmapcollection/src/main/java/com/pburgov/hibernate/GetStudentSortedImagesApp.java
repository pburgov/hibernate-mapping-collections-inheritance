package com.pburgov.hibernate;

import com.pburgov.hibernate.entity.Student;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentSortedImagesApp {

    public static void main( String[] args ) {

        SessionFactory factory = new Configuration()
                                     .configure("hibernate.cfg.xml")
                                     .addAnnotatedClass(Student.class)
                                     .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class,1);

            System.out.println("Estudiante: " + student.toString());

            System.out.println("Imágenes: " + student.getImages());

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
