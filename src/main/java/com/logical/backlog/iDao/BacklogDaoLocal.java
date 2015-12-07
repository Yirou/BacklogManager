/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.iDao;

import com.logical.backlog.model.Agence;
import com.logical.backlog.model.Backlog;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author yirou
 */
@Remote
public interface BacklogDaoLocal {

    public void add(Backlog backlog);

    public Backlog get(int id);

    public List<Backlog> getAll(Agence agence);

    public void update(Backlog backlog);

    public void detele(Backlog backlog);

    public Backlog get(Backlog backlog);
}
