package com.pburgov.hibernate.embedded;

import com.pburgov.hibernate.embedded.entity.Address;
import com.pburgov.hibernate.embedded.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentComponentApp {

    public static void main( String[] args ) {
        saveStudent();
    }

    private static void saveStudent() {
        SessionFactory factory = new Configuration()
                                     .configure("hibernate.cfg.xml")
                                     .addAnnotatedClass(Student.class)
                                     .addAnnotatedClass(Address.class)
                                     .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("Pedro", "García", "pgarcia@gmail.com");

            Address address = new Address("Toxeira 2", "Cangas", "36940");
            student.setHomeAddress(address);

            Address billAddress = new Address("Espiñeiro 5", "Poio", "36163");
            student.setBillingAddress(billAddress);

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
