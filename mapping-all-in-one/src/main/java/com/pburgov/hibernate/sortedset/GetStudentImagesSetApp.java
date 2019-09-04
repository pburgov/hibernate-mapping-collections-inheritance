package com.pburgov.hibernate.sortedset;

import com.pburgov.hibernate.sortedset.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentImagesSetApp {

    public static void main( String[] args ) {

        SessionFactory factory = new Configuration()
                                     .configure("hibernate.cfg.xml")
                                     .addAnnotatedClass(Student.class)
                                     .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, 2);

            System.out.println("Estudiante:" + student.toString());

            System.out.println("Imágenes: " + student.getImages());

            session.getTransaction().commit();

        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }

}
