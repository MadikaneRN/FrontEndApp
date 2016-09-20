package cput.ac.za.mobilebanking1;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cput.ac.za.mobilebanking1.domain.Client;
import cput.ac.za.mobilebanking1.services.ClientService;
import cput.ac.za.mobilebanking1.services.impl.ClientServiceImpl;

public class ClientUpdate extends AppCompatActivity {

    private EditText id;
    private EditText fname;
    private EditText lname;
    private EditText idNumber;
    final Context context=this;

    ClientService service = new ClientServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_update);


        //Force connection
        StrictMode.ThreadPolicy policy  = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Button updatebtn = (Button)findViewById(R.id.btnUpdateDetails);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                try
                {
                    id = (EditText)findViewById(R.id.UpdateIdText);
                    fname = (EditText)findViewById(R.id.editText7);
                    lname = (EditText)findViewById(R.id.editText8);
                    idNumber = (EditText)findViewById(R.id.editText9);


                    Client myClient = new Client.Builder()
                            .id(Long.parseLong(id.getText().toString()))
                            .name(fname.getText().toString())
                            .surname(lname.getText().toString())
                            .idno(idNumber.getText().toString())
                            .build();

                    String response = service.save(myClient);


                    id.getText().clear();
                    fname.getText().clear();
                    lname.getText().clear();
                    idNumber.getText().clear();

                    Toast.makeText(getApplicationContext(),
                            "Client Updated",
                            Toast.LENGTH_SHORT).show();


                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), e.toString(),
                            Toast.LENGTH_SHORT).show();

                }





            }
        });



        

    }
}
