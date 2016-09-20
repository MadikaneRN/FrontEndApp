package cput.ac.za.mobilebanking1;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cput.ac.za.mobilebanking1.domain.Client;
import cput.ac.za.mobilebanking1.services.ClientService;
import cput.ac.za.mobilebanking1.services.impl.ClientServiceImpl;

public class ClientDelete extends AppCompatActivity {

    private EditText clientId;
    ClientService service = new ClientServiceImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_delete);

        //Force connection
        StrictMode.ThreadPolicy policy  = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Button cancel = (Button) findViewById(R.id.btnCancelDelete);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);


            }

        });


        clientId = (EditText) findViewById(R.id.editText5);

        Button deleteClient = (Button) findViewById(R.id.btnDeleteMenu);

        deleteClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clientId = (EditText) findViewById(R.id.editText5);

                Client myClient = new Client.Builder()
                        .id(Long.parseLong(clientId.getText().toString()))
                        .build();
                String response = service.delete(myClient);

                Toast.makeText(getBaseContext(),"Client Deleted",Toast.LENGTH_SHORT).show();


            }
        });



    }




}
