package cput.ac.za.mobilebanking1.services;

import java.util.List;

import cput.ac.za.mobilebanking1.domain.Client;

/**
 * Created by Scorpian on 2016-08-31.
 */
public interface Services<H, ID> {

    public H findById(ID id);

    public String save(H entity);

    public String update(Client entity);

    public String delete(Client entity); // Getter, GET implements Resource Support, Post Supports Entity model

    public List<H> findAll();

}