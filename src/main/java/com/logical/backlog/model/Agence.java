/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author yirou
 */
@Table(name = "agence")
@Entity
public class Agence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Backlog> backlogs = new ArrayList<>();

    public Agence() {
    }

    public Agence(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Backlog> getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(List<Backlog> backlogs) {
        this.backlogs = backlogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Agence{" + "id=" + id + ", name=" + name + ", users=" + users + ", backlogs=" + backlogs + '}';
    }

}
