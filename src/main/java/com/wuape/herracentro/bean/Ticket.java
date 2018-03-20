package com.wuape.herracentro.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Bowpi GT
 * Created by Jose on 19/03/2018.
 */
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "id_ticket")
    private long id;

    @Column(name = "usuario_creador")
    private String createUser;

    @Column(name = "fecha_ticket")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date creationDate;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_incidencia")
    private Incidence incidence;

    public Ticket(String createUser, Date creationDate, String state, Incidence incidence) {
        this.createUser = createUser;
        this.creationDate = creationDate;
        this.state = state;
        this.incidence = incidence;
    }

    public Ticket() {
        this.creationDate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Incidence getIncidence() {
        return incidence;
    }

    public void setIncidence(Incidence incidence) {
        this.incidence = incidence;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", createUser='" + createUser + '\'' +
                ", creationDate=" + creationDate +
                ", state='" + state + '\'' +
                ", incidence=" + incidence +
                '}';
    }
}
