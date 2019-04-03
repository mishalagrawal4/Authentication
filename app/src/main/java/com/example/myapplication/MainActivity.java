package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public
    EditText eml,pass;
    Button bsignup;
    TextView bsignin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Signup);
        firebaseAuth=FirebaseAuth.getInstance();
        eml=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        bsignup=findViewById(R.id.signup);
        bsignin=findViewById(R.id.signin);
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid=eml.getText().toString();
                String password=pass.getText().toString();
                
            }
        });
    }
}
