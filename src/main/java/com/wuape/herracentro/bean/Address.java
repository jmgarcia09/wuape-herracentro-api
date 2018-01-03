package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 2/01/2018.
 */
@Entity
@Table(name = "direcciones")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_direccion")
    private Long id;

    @Column(name = "dir_1")
    private String firstAddress;
    @Column(name = "dir_2")
    private String secondAddress;
    @Column(name = "colonia_barrio")
    private String colony;
    @Column(name = "zona")
    private String zone;
    @Column(name = "nota")
    private String note;
    @Column(name = "direccion_completa")
    private String completeAddress;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Town town;

    public Address(String firstAddress, String secondAddress, String colony, String zone, String note, String completeAddress, Department department, Town town) {
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.colony = colony;
        this.zone = zone;
        this.note = note;
        this.completeAddress = completeAddress;
        this.department = department;
        this.town = town;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", firstAddress='" + firstAddress + '\'' +
                ", secondAddress='" + secondAddress + '\'' +
                ", colony='" + colony + '\'' +
                ", zone='" + zone + '\'' +
                ", note='" + note + '\'' +
                ", completeAddress='" + completeAddress + '\'' +
                ", department=" + department +
                ", town=" + town +
                '}';
    }
}
