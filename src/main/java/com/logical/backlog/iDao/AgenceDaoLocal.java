/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.iDao;

import com.logical.backlog.model.Agence;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author yirou
 */
@Remote
public interface AgenceDaoLocal {

    public void add(Agence agence);

    public Agence get(int id);
    
    public Agence get(Agence agence);

    public List<Agence> getAll();

    public void update(Agence agence);

    public void detele(Agence agence);
}
