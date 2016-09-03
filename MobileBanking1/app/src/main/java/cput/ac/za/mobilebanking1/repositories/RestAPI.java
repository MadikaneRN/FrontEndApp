package cput.ac.za.mobilebanking1.repositories;

import java.util.List;

import cput.ac.za.mobilebanking1.domain.Client;

/**
 * Created by Scorpian on 2016-08-31.
 */
public interface RestAPI <S,ID>{

    S get(ID id);

    String post(S entity);

    String put (Client entity);

    String delete(Client entity);

    List<S> getAll();
}
