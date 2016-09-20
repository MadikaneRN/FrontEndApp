package cput.ac.za.mobilebanking1;

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

public class ClientRead extends AppCompatActivity {

    ClientService service = new ClientServiceImpl();

    private EditText id;
    private Button find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_read);


        //Force connection
        StrictMode.ThreadPolicy policy  = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        find = (Button)findViewById(R.id.btnSearchFind);
        id = (EditText) findViewById(R.id.editText6);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String ClientToast = "";

                Client client = service.findById(Long.parseLong(id.getText().toString()));

                ClientToast = "id: "+ "i"+client.getId()+"\n"+"Client Name:"+client.getName()+
                        "\n"+"Client Surname:"+client.getSurName()+"\n"+"Client ID Number"+client.getIdNo()+"\n\n";


                Toast.makeText(getBaseContext(),ClientToast,Toast.LENGTH_LONG).show();

            }
        });



    }
}
