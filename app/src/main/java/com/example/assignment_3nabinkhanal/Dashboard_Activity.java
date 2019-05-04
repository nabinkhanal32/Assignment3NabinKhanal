package com.example.assignment_3nabinkhanal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Adapter.AdapterClothes;
import Adapter.Cloth;

public class Dashboard_Activity extends AppCompatActivity {
        private RecyclerView recyclerView;

        private Button btnadd;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard_);
            recyclerView=findViewById(R.id.recyclerview);
            btnadd=findViewById(R.id.btnAdd);


            List<Cloth> clothlist = new ArrayList<>();
            try {
                FileInputStream fileInputStream = openFileInput("items.txt");
                InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    String[] parts=line.split("->");



                    int image= getResources().getIdentifier(parts[2],"drawable",getPackageName());
                    clothlist.add(new Cloth(parts[0],parts[1],image,parts[3]));
                }
                AdapterClothes cAdapter = new AdapterClothes(this,clothlist);
                recyclerView.setAdapter(cAdapter);


                recyclerView.setLayoutManager(new GridLayoutManager(this,2));


            }  catch (IOException e) {
                e.printStackTrace();
            }

            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(Dashboard_Activity.this,ItamAdd_activity.class);
                    startActivity(intent);

                }
            });



        }
}
