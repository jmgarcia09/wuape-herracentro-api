package com.wuape.herracentro.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Bowpi GT
 * Created by Jose on 19/03/2018.
 */
@Entity
@Table(name = "incidencias")
public class Incidence {

    @GeneratedValue
    @Id
    @Column(name = "id_incidencia")
    private long id;

    @Column(name = "fecha_llamada")
    private Date creationDate;

    @Column(name = "descripcion_incidencia")
    private String incidenceDescription;

    @Column(name = "descripcion_solucion")
    private String solutionDescription;

    @ManyToOne
    @JoinColumn(name = "id_tipo_incidencia")
    private IncidenceType incidenceType;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @Column(name = "nombre_emisor")
    private String issuerName;

    @Column(name = "telefono_emisor")
    private String issuerPhone;


    public Incidence(Date creationDate, String incidenceDescription, String solutionDescription, IncidenceType incidenceType, User user, String issuerName, String issuerPhone) {
        this.creationDate = creationDate;
        this.incidenceDescription = incidenceDescription;
        this.solutionDescription = solutionDescription;
        this.incidenceType = incidenceType;
        this.user = user;
        this.issuerName = issuerName;
        this.issuerPhone = issuerPhone;
    }

    public Incidence() {
        this.creationDate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getIncidenceDescription() {
        return incidenceDescription;
    }

    public void setIncidenceDescription(String incidenceDescription) {
        this.incidenceDescription = incidenceDescription;
    }

    public String getSolutionDescription() {
        return solutionDescription;
    }

    public void setSolutionDescription(String solutionDescription) {
        this.solutionDescription = solutionDescription;
    }

    public IncidenceType getIncidenceType() {
        return incidenceType;
    }

    public void setIncidenceType(IncidenceType incidenceType) {
        this.incidenceType = incidenceType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getIssuerPhone() {
        return issuerPhone;
    }

    public void setIssuerPhone(String issuerPhone) {
        this.issuerPhone = issuerPhone;
    }

    @Override
    public String toString() {
        return "Incidence{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", incidenceDescription='" + incidenceDescription + '\'' +
                ", solutionDescription='" + solutionDescription + '\'' +
                ", incidenceType=" + incidenceType +
                ", user=" + user +
                ", issuerName='" + issuerName + '\'' +
                ", issuerPhone='" + issuerPhone + '\'' +
                '}';
    }
}
