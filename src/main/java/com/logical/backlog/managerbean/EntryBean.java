/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.managerbean;

import com.logical.backlog.iDao.BacklogDaoLocal;
import com.logical.backlog.iDao.EntryDaoLocal;
import com.logical.backlog.model.Backlog;
import com.logical.backlog.model.Entries;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author yirou
 */
@ManagedBean(name = "entreebean", eager = true)
@RequestScoped
public class EntryBean {
    
    @EJB
    EntryDaoLocal entryDao;
    @EJB
    BacklogDaoLocal backloDao;
   
    
    private Entries entry;
    
    public EntryBean() {
        super();
        entry = new Entries();
        
    }
    
    public List<Entries> getAllEntry() {
        Backlog backlog = (Backlog) SessionBean.getSession().getAttribute("backlog");
        backlog = backloDao.get(backlog);
        return entryDao.getAll(backlog);
    }
    
    public String addEntry() {
        Backlog backlog = (Backlog) SessionBean.getSession().getAttribute("backlog");
        backlog = backloDao.get(backlog);
        backloDao.update(backlog);
        entry.setCreationDate(new Date());
        entry.setBacklog(backlog);
        entryDao.add(entry);
        return entry();
    }
    
    
    
    private String entry() {
        return "entry";
    }
    
   
    
    public String access(Entries entry) {
        SessionBean.getSession().setAttribute("entry", entry);
        System.out.println("entry "+entry);
        return entry();
    }
    
    public Entries getEntry() {
        return entry;
    }
    
    public void setEntry(Entries entry) {
        this.entry = entry;
    }
    
}
