package com.example.loginlogout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Create_An_Account extends AppCompatActivity {

    EditText userName,password;
    Button signup;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__an__account);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName1=userName.getText().toString();
                String password1=password.getText().toString();

                mAuth.createUserWithEmailAndPassword(userName1, password1)
                        .addOnCompleteListener(Create_An_Account.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Create_An_Account.this, "account created Successfull", Toast.LENGTH_SHORT).show();
                                    Log.w("rajeev", "succ");
                                    Intent intent = new Intent(Create_An_Account.this, Login.class);
                                    startActivity(intent);
                                } else {

                                    Toast.makeText(Create_An_Account.this, "Account creation failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
