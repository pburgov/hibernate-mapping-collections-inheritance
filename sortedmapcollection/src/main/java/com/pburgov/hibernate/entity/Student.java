package com.pburgov.hibernate.entity;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

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

    @ElementCollection
    @CollectionTable( name = "image" )
    @MapKeyColumn( name = "file_name" )
    @Column( name = "image_name" )
    //@OrderBy
    @SortComparator(ReverseStringComparator.class)
    private SortedMap <String, String> images = new TreeMap <>();

    public static class ReverseStringComparator implements Comparator<String>{
        @Override
        public int compare( String o1, String o2 ) {
            return o2.compareTo(o1);
        }
    }

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

    public SortedMap <String, String> getImages() {
        return images;
    }

    public void setImages( SortedMap <String, String> images ) {
        this.images = images;
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
