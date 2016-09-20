package cput.ac.za.mobilebanking1.domain;

import java.io.Serializable;

/**
 * Created by Scorpian on 2016-08-31.
 */
public class Client implements Serializable{

    private long id;
    private String idno;
    private String name;
    private String surname;

    private Client()
    {

    }


    public Client(Builder builder) {

        this.id = builder.id;
        this.idno = builder.idno;
        this.surname = builder.surname;
        this.name = builder.name;
    }


    public long getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public String getIdNo() {
        return idno;
    }


    public static class Builder {

        //Equivalent to setters
        private long id;
        private String name;
        private String surname;
        private String idno;


        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder idno (String idno) {
            this.idno = idno;
            return this;
        }




        public Builder surname(String Surname) {
            this.surname = Surname;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }



        public Builder copy(Client client){
            this.id = client.id;
            this.idno = client.idno;
            this.name = client.name;
            this.surname = client.surname;
            return this;
        }

//

        public Client build() {
            return new Client(this);
        }
    }



    @Override
    public String toString()
    {
        return String.format("Id : %d\n name : %s\n surname : %s\n idNum : %s",id,name,surname,idno);
    }


}
