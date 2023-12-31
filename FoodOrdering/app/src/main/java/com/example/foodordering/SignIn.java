package com.example.foodordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodordering.Common.Common;
import com.example.foodordering.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText editPhone, editPasword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPasword = (MaterialEditText)findViewById(R.id.edtPassword);
        editPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://foodorderingapp-d1c2f-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Loading...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Get User Information
                        if(snapshot.child(editPhone.getText().toString()).exists())
                        {
                            mDialog.dismiss();

                            User user = new User(snapshot.child(editPhone.getText().toString()).child("name").getValue().toString(), snapshot.child(editPhone.getText().toString()).child("password").getValue().toString());
                            user.setPhone(editPhone.getText().toString());
                            if(user.getPassword().equals(editPasword.getText().toString()))
                            {
                              Intent homeIntent= new Intent(SignIn.this,Home.class);
                                Common.currentUser=user;
                                startActivity(homeIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(SignIn.this, "Sign in failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "User doesn't exist!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}