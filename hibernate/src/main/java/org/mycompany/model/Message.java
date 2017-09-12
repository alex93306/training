package org.mycompany.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Created by ALEX on 21.08.2017.
 */
@Entity
public class Message {
    @Id
    @SequenceGenerator(name = "base_seq", sequenceName = "base_seq", initialValue = 10)
    @GeneratedValue(generator = "base_seq")    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
