package cput.ac.za.mobilebanking1.factory;

import cput.ac.za.mobilebanking1.domain.Client;

/**
 * Created by Bonga on 9/3/2016.
 */
public class ClientFactory {

    public static Client getClient(String idNo, String name, String surName)
    {
        Client myClient = new Client.Builder()
                .idno(idNo)
                .name(name)
                .surname(surName)
                .build();

        return myClient;

    }


}
