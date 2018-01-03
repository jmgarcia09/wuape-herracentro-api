package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 2/01/2018.
 */
@Entity
@Table(name = "municipios")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_municipio")
    private Long id;

    @Column(name = "nombre_municipio")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Department department;

    public Town(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Town() {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
