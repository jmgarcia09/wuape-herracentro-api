package com.wuape.herracentro.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "incidencias")
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_incidencia")
    private Long id;

    @Column(name = "fecha_llamada")
    @Temporal(TemporalType.DATE)
    private Date callDate;

    @Column(name = "id_tienda")
    private Long storeId;

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
    private String transmitterName;

    @Column(name = "telefono_emisor")
    private String transmitterPhone;

    @Column(name = "entrante_saliente")
    private int incomingOutcoming;

    public Incidence(Date callDate, Long storeId, String incidenceDescription, String solutionDescription, IncidenceType incidenceType, User user, String transmitterName, String transmitterPhone, int incomingOutcoming) {
        this.callDate = callDate;
        this.storeId = storeId;
        this.incidenceDescription = incidenceDescription;
        this.solutionDescription = solutionDescription;
        this.incidenceType = incidenceType;
        this.user = user;
        this.transmitterName = transmitterName;
        this.transmitterPhone = transmitterPhone;
        this.incomingOutcoming = incomingOutcoming;
    }

    public Incidence() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getTransmitterName() {
        return transmitterName;
    }

    public void setTransmitterName(String transmitterName) {
        this.transmitterName = transmitterName;
    }

    public String getTransmitterPhone() {
        return transmitterPhone;
    }

    public void setTransmitterPhone(String transmitterPhone) {
        this.transmitterPhone = transmitterPhone;
    }

    public int getIncomingOutcoming() {
        return incomingOutcoming;
    }

    public void setIncomingOutcoming(int incomingOutcoming) {
        this.incomingOutcoming = incomingOutcoming;
    }

    @Override
    public String toString() {
        return "Incidence{" +
                "id=" + id +
                ", callDate=" + callDate +
                ", storeId=" + storeId +
                ", incidenceDescription='" + incidenceDescription + '\'' +
                ", solutionDescription='" + solutionDescription + '\'' +
                ", incidenceType=" + incidenceType +
                ", user=" + user +
                ", transmitterName='" + transmitterName + '\'' +
                ", transmitterPhone='" + transmitterPhone + '\'' +
                ", incomingOutcoming=" + incomingOutcoming +
                '}';
    }
}
