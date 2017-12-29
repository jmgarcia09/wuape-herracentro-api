package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 28/12/2017.
 */
@Entity
@Table(name = "privilegios_usuarios")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_privilegio")
    private long id;

    @Column(name = "nombre_privilegio")
    private String name;

    public UserAuthority(String name) {
        this.name = name;
    }

    public UserAuthority() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "UserAuthority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
