package com.pburgov.hibernate.embedded.entity;

import java.util.StringJoiner;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "student" )
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private int id;

    @Column( name = "first_name" )
    private String firstName;

    @Column( name = "last_name" )
    private String lastName;

    @Column( name = "email" )
    private String email;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides( value = {
        @AttributeOverride( name = "street",
            column = @Column( name = "BILLING_STREET" ) ),
        @AttributeOverride( name = "city",
            column = @Column( name = "BILLING_CITY" ) ),
        @AttributeOverride( name = "zipcode",
            column = @Column( name = "BILLING_ZIPCODE" ) )
    } )
    private Address billingAddress;

    public Student() {}

    public Student( String firstName, String lastName, String email ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress( Address homeAddress ) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress( Address billingAddress ) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                   .add("id=" + id)
                   .add("firstName='" + firstName + "'")
                   .add("lastName='" + lastName + "'")
                   .add("email='" + email + "'")
                   .toString();
    }
}
