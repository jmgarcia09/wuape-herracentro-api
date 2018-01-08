package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */
@Entity
@Table(name = "especialidades")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_especialidad")
    private Long id;

    @Column(name = "nombre_especialidad")
    private String name;

    public Speciality(String name) {
        this.name = name;
    }

    public Speciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
