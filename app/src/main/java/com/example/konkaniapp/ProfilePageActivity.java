package com.example.konkaniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfilePageActivity extends AppCompatActivity {

    EditText etName, etAge, etRegion, etEmail, etPhone;
    Button btnSave, btnCancel;
    boolean isSaved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);


        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etRegion = findViewById(R.id.etRegion);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!isSaved) {

                    String name = etName.getText().toString().trim();
                    String age = etAge.getText().toString().trim();
                    String region = etRegion.getText().toString().trim();
                    String email = etEmail.getText().toString().trim();
                    String phone = etPhone.getText().toString().trim();

                    if (name.isEmpty() || age.isEmpty() || region.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                        Toast.makeText(ProfilePageActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    etName.setEnabled(false);
                    etAge.setEnabled(false);
                    etRegion.setEnabled(false);
                    etEmail.setEnabled(false);
                    etPhone.setEnabled(false);

                    isSaved = true;
                    btnSave.setText("Edit");
                    Toast.makeText(ProfilePageActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                } else {

                    etName.setEnabled(true);
                    etAge.setEnabled(true);
                    etRegion.setEnabled(true);
                    etEmail.setEnabled(true);
                    etPhone.setEnabled(true);

                    isSaved = false;
                    btnSave.setText("Save");
                    Toast.makeText(ProfilePageActivity.this, "Edit Mode Enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                etName.setText("");
                etAge.setText("");
                etRegion.setText("");
                etEmail.setText("");
                etPhone.setText("");

                etName.setEnabled(true);
                etAge.setEnabled(true);
                etRegion.setEnabled(true);
                etEmail.setEnabled(true);
                etPhone.setEnabled(true);

                isSaved = false;
                btnSave.setText("Save");

                Toast.makeText(ProfilePageActivity.this, "Inputs cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
