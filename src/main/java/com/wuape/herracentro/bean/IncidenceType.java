package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */
@Entity
@Table(name = "tipos_incidencias")
public class IncidenceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_incidencia")
    private Long id;

    @Column(name = "nombre_tipo_incidencia")
    private String name;

    public IncidenceType(String name) {
        this.name = name;
    }

    public IncidenceType() {
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
        return "IncidenceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
