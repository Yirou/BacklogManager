/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.iDao;

import com.logical.backlog.model.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author yirou
 */
@Remote
public interface UserDaoLocal {

    public void add(User user);

    public User get(int id);

    public List<User> getAll();

    public void update(User user);

    public void detele(User user);

    public boolean login(User user);
    
    public User get(User user);
}
