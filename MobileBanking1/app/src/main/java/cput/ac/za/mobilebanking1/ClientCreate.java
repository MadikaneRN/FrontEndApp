package cput.ac.za.mobilebanking1;

import android.content.Context;
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

public class ClientCreate extends AppCompatActivity {
//Id = editext 1 Name = editext 2 Surname = editext 3 IdNumber editext4


    ClientService service = new ClientServiceImpl();
    private EditText fname;
    private EditText lname;
    private EditText idNumber;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_create);


        //force connection
        StrictMode.ThreadPolicy policy  = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);




        Button cancel = (Button) findViewById(R.id.btnCancelCreate);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);


            }

        });


        Button submitCreate = (Button) findViewById(R.id.btnSubmitCreate);

        submitCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = (EditText)findViewById(R.id.editText2);
                lname = (EditText)findViewById(R.id.editText3);
                idNumber = (EditText)findViewById(R.id.editText4);


                Client myClient = new Client.Builder()
                        .name(fname.getText().toString())
                        .idno(idNumber.getText().toString())
                        .surname(lname.getText().toString())
                        .build();

                String response = service.save(myClient); //save Item

                fname.getText().clear();
                lname.getText().clear();
                idNumber.getText().clear();

                Toast.makeText(getApplicationContext(),"Client Saved",Toast.LENGTH_LONG).show();



            }
        });



    }
}
