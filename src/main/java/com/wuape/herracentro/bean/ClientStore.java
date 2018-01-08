package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */
@Entity
@Table(name = "tiendas_clientes")
public class ClientStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tienda")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nit_cliente")
    private Client client;

    @Column(name = "nombre_tienda")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Address address;

    @Column(name = "nota_tienda")
    private String note;

    @Column(name = "telefono_1")
    private String phone;
    @Column(name = "telefono_2")
    private String secondPhone;

    public ClientStore(Client client, String name, Address address, String note, String phone, String secondPhone) {
        this.client = client;
        this.name = name;
        this.address = address;
        this.note = note;
        this.phone = phone;
        this.secondPhone = secondPhone;
    }

    public ClientStore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    @Override
    public String toString() {
        return "ClientStore{" +
                "id=" + id +
                ", client=" + client +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", note='" + note + '\'' +
                ", phone='" + phone + '\'' +
                ", secondPhone='" + secondPhone + '\'' +
                '}';
    }
}
