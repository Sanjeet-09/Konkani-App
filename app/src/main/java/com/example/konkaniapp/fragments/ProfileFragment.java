package com.example.konkaniapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.konkaniapp.AboutUsActivity;
import com.example.konkaniapp.ProfilePageActivity;
import com.example.konkaniapp.R;
import com.example.konkaniapp.RateUsActivity;


public class ProfileFragment extends Fragment {
    private static final int REQUEST_IMAGE_PICK = 1001;
    private ImageView imageView4;
    private Uri imageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imageView4 = view.findViewById(R.id.imageView4);
        Button about_us = view.findViewById(R.id.about_us);
        Button rate_us = view.findViewById(R.id.rate_us);
        Button profile = view.findViewById(R.id.profile);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AboutUsActivity.class));
            }
        });

        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RateUsActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfilePageActivity.class));
            }
        });

        return view;
    }


    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK && data != null) {
            imageUri = data.getData();
            if (imageUri != null) {
                imageView4.setImageURI(imageUri);
                Toast.makeText(getContext(), "Profile image applied temporarily", Toast.LENGTH_SHORT).show();
            }
        }
    }
}