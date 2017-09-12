package org.mycompany.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Phone")
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "`number`")
    private String number;

    @ManyToOne()
    @JoinColumn(name = "person")
    private Person person;


    public Phone() {
    }
    public Phone(String number) {
        this.number = number;
    }
    public Long getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
        person.getPhones().add(this);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
