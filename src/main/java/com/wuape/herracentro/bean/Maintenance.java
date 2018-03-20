package com.wuape.herracentro.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Bowpi GT
 * Created by Jose on 19/03/2018.
 */
@Entity
@Table(name = "mantenimientos")
public class Maintenance {

    @Id
    @GeneratedValue
    @Column(name = "id_mantenimiento")
    private long id;

    @Column(name = "fecha_ini")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date startDate;

    @Column(name = "fecha_fin")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "id_usuario_creador")
    private User user;

    public Maintenance(Date startDate, Date endDate, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public Maintenance() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", user=" + user +
                '}';
    }
}
