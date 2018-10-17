package com.wuape.herracentro.bean;

import javax.persistence.*;

/**
 * Bowpi GT
 * Created by Jose on 2/01/2018.
 */

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private UserType userType;
    @ManyToOne
    @JoinColumn(name = "id_privilegio")
    private UserAuthority userAuthority;
    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "dpi")
    private String dpi;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "login")
    private String loginId;
    @Column(name = "password")
    private String password;
    @Column(name = "acceso")
    private int access;

    public User(UserType userType, UserAuthority userAuthority, Address address, Client client, String name, String lastName, String dpi, String phone, String loginId, String password, int access) {
        this.userType = userType;
        this.userAuthority = userAuthority;
        this.address = address;
        this.client = client;
        this.name = name;
        this.lastName = lastName;
        this.dpi = dpi;
        this.phone = phone;
        this.loginId = loginId;
        this.password = password;
        this.access = access;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserAuthority getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(UserAuthority userAuthority) {
        this.userAuthority = userAuthority;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userType=" + userType +
                ", userAuthority=" + userAuthority +
                ", address=" + address +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dpi='" + dpi + '\'' +
                ", phone='" + phone + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}
