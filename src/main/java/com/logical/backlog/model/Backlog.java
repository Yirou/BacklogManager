/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yirou
 */
@Table(name = "backlog")
@Entity
public class Backlog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agence_id")
    private Agence agence;
//    @OneToMany(mappedBy = "backlog")
//    private List<Entries> listEntries = new ArrayList<>();

    public Backlog() {
    }

    public Backlog(String name, Date creationDate, User user, Agence agence) {
        this.name = name;
        this.creationDate = creationDate;
        this.user = user;
        this.agence = agence;
    }
     public Backlog(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

//    public List<Entries> getListEntries() {
//        return listEntries;
//    }
//
//    public void setListEntries(List<Entries> listEntries) {
//        this.listEntries = listEntries;
//    }

//    @Override
//    public String toString() {
//        return "Backlog{" + "id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", user=" + user + ", agence=" + agence + ", listEntries=" + listEntries + '}';
//    }

}
