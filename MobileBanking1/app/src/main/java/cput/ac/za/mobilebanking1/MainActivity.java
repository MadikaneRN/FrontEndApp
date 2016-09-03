package cput.ac.za.mobilebanking1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create = (Button) findViewById(R.id.btnCreate);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), ClientCreate.class);
                startActivityForResult(myIntent, 0);


            }

        });



        Button delete = (Button) findViewById(R.id.btnDeleteMenu);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), ClientDelete.class);
                startActivityForResult(myIntent, 0);


            }

        });

        Button read = (Button) findViewById(R.id.btnRead);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), ClientRead.class);
                startActivityForResult(myIntent, 0);


            }

        });


        Button update = (Button) findViewById(R.id.btnUpdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), ClientUpdate.class);
                startActivityForResult(myIntent, 0);


            }

        });



        Button display = (Button) findViewById(R.id.btnDisplay);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), ClientAll.class);
                startActivityForResult(myIntent, 0);


            }

        });


        Button exit = (Button) findViewById(R.id.btnExit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                System.exit(0);


            }

        });














    }





}
