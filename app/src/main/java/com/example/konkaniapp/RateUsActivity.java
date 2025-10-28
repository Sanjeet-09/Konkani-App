package com.example.konkaniapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RateUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rate_us);

        Button submitButton = findViewById(R.id.submitButton);
        EditText feedbackInput = findViewById(R.id.feedbackInput);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating =ratingBar.getRating();
                String comment = feedbackInput.getText().toString().trim();

                if(rating == 0.0f){
                    Toast.makeText(getApplicationContext(), "Please provide a rating.", Toast.LENGTH_SHORT).show();
                }
                else if (comment.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a comment.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}