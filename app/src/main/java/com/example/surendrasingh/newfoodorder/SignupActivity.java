package com.example.surendrasingh.newfoodorder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    EditText name,email,dob,password;
    Button reg;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name=(EditText)findViewById(R.id.firstname);
        email=(EditText)findViewById(R.id.mil);
        dob=(EditText)findViewById(R.id.DOB);
        password=(EditText)findViewById(R.id.ps);
        reg=(Button)findViewById(R.id.regi);
        mauth=FirebaseAuth.getInstance();


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String db=dob.getText().toString().trim();
                String nm=name.getText().toString().trim();
                if (!TextUtils.isEmpty(mail)&&!TextUtils.isEmpty(pass)&&!TextUtils.isEmpty(db)&&!TextUtils.isEmpty(nm)){
                mauth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Register Sucessfully \n Redirecting to login page",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SignupActivity.this,MainActivity.class));
                        }

                    }
                });
            }
            else
            Toast.makeText(getApplicationContext(),"Fill All Details!!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
