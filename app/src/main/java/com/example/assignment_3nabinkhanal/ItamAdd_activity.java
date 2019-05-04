package com.example.assignment_3nabinkhanal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ItamAdd_activity extends AppCompatActivity {

    private EditText etName,etPrice,etImage,etDesc;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itam_add_activity);

        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        etImage = findViewById(R.id.etImage);
        etDesc = findViewById(R.id.etDesc);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
    private void  save(){
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(openFileOutput("items.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etName.getText().toString() + "->" + etPrice.getText().toString() + "->" + etImage.getText().toString() + "->" + etDesc.getText().toString());
            Toast.makeText(this,"saved to " +getFilesDir(), Toast.LENGTH_LONG).show();
            printStream.close();
            Toast.makeText(this,"saved to "+getFilesDir(),Toast.LENGTH_LONG).show();
            Intent intent=new Intent(ItamAdd_activity.this,Dashboard_Activity.class);
            startActivity(intent);
        } catch (FileNotFoundException e) {
            Log.d("Dictionary app" , "Error: "+e.toString());
            e.printStackTrace();
        }

    }

}
