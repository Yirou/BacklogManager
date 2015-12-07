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
@Entity
@Table(name = "entry")
public class Entries implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "priority")
    private String priority;
    @Column(name = "estimation")
    private String estimation;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entry", fetch = FetchType.EAGER)
    List<Comment> comments = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "backlog_id")
    Backlog backlog;

    public Entries() {
    }

    public Entries(String name, Date creationDate, int priority, int estimation, String description) {
        this.name = name;
        this.creationDate = creationDate;
//        this.priority = priority;
//        this.estimation = estimation;
        this.description = description;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }

    public Backlog getBacklog() {
        return backlog;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getEstimation() {
        return estimation;
    }

    public void setEstimation(String estimation) {
        this.estimation = estimation;
    }

//    public int getPriority() {
//        return priority;
//    }
//
//    public void setPriority(int priority) {
//        this.priority = priority;
//    }
//
//    public int getEstimation() {
//        return estimation;
//    }
//
//    public void setEstimation(int estimation) {
//        this.estimation = estimation;
//    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Entries{" + "id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", priority=" + priority + ", estimation=" + estimation + ", description=" + description + ", comments=" + comments + ", backlog=" + backlog + '}';
    }

}
