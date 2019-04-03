package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
                if (emailid.isEmpty())
                {
                    eml.setError("Enter email first");
                    eml.requestFocus();
                }
                else if(password.isEmpty())
                {
                    pass.setError("Enter email first");
                    pass.requestFocus();
                }
                else if(!emailid.isEmpty() && password.isEmpty())
                {
                    firebaseAuth.createUserWithEmailAndPassword(emailid,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Signup Unsuccessfull", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            startActivity(new Intent(MainActivity.this,UserActivity.class));
                        }}
                    });
                }
            }
        });
        bsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Login.class);
            }
        });
    }
}
