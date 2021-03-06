package com.pburgov.hibernate.map;

import com.pburgov.hibernate.map.entity.Student;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentMapApp {

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
            Map <String, String> images = student.getImages();
            images.put("foto1.jpg", "Foto 1");
            images.put("foto2.jpg", "Foto 2");
            images.put("foto3.jpg", "Foto 3");
            images.put("foto4.jpg", "Foto 4");

            session.beginTransaction();

            System.out.println("Guardando el objeto");
            session.save(student);
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
