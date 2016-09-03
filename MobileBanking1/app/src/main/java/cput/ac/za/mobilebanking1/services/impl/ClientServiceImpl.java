package cput.ac.za.mobilebanking1.services.impl;

import java.util.List;

import cput.ac.za.mobilebanking1.domain.Client;
import cput.ac.za.mobilebanking1.repositories.RestAPI;
import cput.ac.za.mobilebanking1.repositories.rest.RestClient;
import cput.ac.za.mobilebanking1.services.ClientService;

/**
 * Created by Scorpian on 2016-08-31.
 */
public class ClientServiceImpl implements ClientService {
    final RestAPI<Client,Long> rest = new RestClient();

    @Override
    public Client findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Client entity) {
        return rest.post(entity);
    }

    @Override
    public String update(Client entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Client entity) {

        return rest.delete(entity);
    }

    @Override
    public List<Client> findAll() {
        return rest.getAll();
    }

}
