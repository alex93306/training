package org.mycompany.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by ALEX on 01.08.2017.
 */
@Entity
@Table( name = "event" )
public class Event {
    private Long id;
    private Date date;
    private String title;

    public Event() {
    }

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_date")
    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                '}';
    }
}
