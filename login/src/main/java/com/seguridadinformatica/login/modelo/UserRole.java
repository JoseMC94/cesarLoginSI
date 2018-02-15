package com.seguridadinformatica.login.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by USUARIO on 12/08/2017.
 */
@Entity
@Table(name ="user_Role", uniqueConstraints = @UniqueConstraint(
        columnNames = {"role","username"}
))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role",unique = true,nullable = false)
    private int userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username",nullable = false)
    private User user;
    @Column(name = "role", nullable = false,length = 45)
    private String role;

    public UserRole() {
    }
    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}