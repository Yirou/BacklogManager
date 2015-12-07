/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.iDao;

import com.logical.backlog.model.Backlog;
import com.logical.backlog.model.Entries;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author yirou
 */
@Remote
public interface EntryDaoLocal {

    public void add(Entries entry);

    public Entries get(int id);

    public List<Entries> getAll();

    public void update(Entries entry);

    public void detele(Entries entry);

    public List<Entries> getAll(Backlog backlog);
}
