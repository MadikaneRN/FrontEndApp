package cput.ac.za.mobilebanking1;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cput.ac.za.mobilebanking1.domain.Client;
import cput.ac.za.mobilebanking1.services.ClientService;
import cput.ac.za.mobilebanking1.services.impl.ClientServiceImpl;

public class ClientAll extends AppCompatActivity {

    ClientService myService = new ClientServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_all);

        //Force connection
        StrictMode.ThreadPolicy policy  = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Button display = (Button) findViewById(R.id.btnShowList);

        final Context context = this;

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Client> results = myService.findAll();

                String clientToast =" ";
                for(int i=1; i<results.size(); i++){

                    clientToast += " ";
                    String heading = "Client "+i+"\n";
                    clientToast +=  heading+"id: "+results.get(i).getId()+"\n"+"First Name:"+results.get(i).getName()+"\n"+"ID Number:"+results.get(i).getIdNo()+"\n"+"Surname :"+results.get(i).getSurName()+"\n\n";



                }
                Toast.makeText(getBaseContext(),clientToast,Toast.LENGTH_LONG).show();


            }
        });




    }


}
