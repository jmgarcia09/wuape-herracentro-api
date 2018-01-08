package com.wuape.herracentro.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */

@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nit_cliente")
    private String id;

    @Column(name = "razon_social")
    private String businessName;

    @Column(name = "nombre_comercial")
    private String commercialName;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Speciality speciality;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "telefono_central")
    private String principalPhone;

    @Column(name = "telefono_contacto")
    private String secondPhone;

    @ManyToOne
    @JoinColumn(name = "id_direccion_central")
    private Address address;

    @Column(name = "contacto")
    private String contact;

    @Column(name = "nota")
    private String note;

    public Client(String businessName, String commercialName, Speciality speciality, Date startDate, String principalPhone, String secondPhone, Address address, String contact, String note) {
        this.businessName = businessName;
        this.commercialName = commercialName;
        this.speciality = speciality;
        this.startDate = startDate;
        this.principalPhone = principalPhone;
        this.secondPhone = secondPhone;
        this.address = address;
        this.contact = contact;
        this.note = note;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", commercialName='" + commercialName + '\'' +
                ", speciality=" + speciality +
                ", startDate=" + startDate +
                ", principalPhone='" + principalPhone + '\'' +
                ", secondPhone='" + secondPhone + '\'' +
                ", address=" + address +
                ", contact='" + contact + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
