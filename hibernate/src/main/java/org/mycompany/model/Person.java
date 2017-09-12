package org.mycompany.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEX on 02.08.2017.
 */
@Entity(name = "Person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    public Person() {
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Phone> phones = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", phones=" + phones +
                '}';
    }
}
