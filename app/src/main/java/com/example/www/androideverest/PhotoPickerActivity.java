package com.example.www.androideverest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class PhotoPickerActivity extends AppCompatActivity {

    private final int GALLERY_RESULT_CODE = 4003;
    private final int CAMERA_RESULT_CODE = 5003;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_picker);

        imageView = findViewById(R.id.my_image_view);
    }

    public void pick_from_gallery(View view) {
        Intent galleryIntent = new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY_RESULT_CODE);
    }

    public void pick_from_camera(View view) {
        Intent galleryIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(galleryIntent, CAMERA_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Can't Get Any Photo.", Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode) {
            case GALLERY_RESULT_CODE:
                if (data != null) {
                    Uri selected_photo_uri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selected_photo_uri);

                        imageView.setImageBitmap(bitmap);

                    } catch (IOException e) {
                        String temp = "Selected Image cannot be read." + "\nError Message:\n" + e.getMessage();
                        Toast.makeText(this, temp, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Selected Image is Null.", Toast.LENGTH_LONG).show();
                }
                break;

            case CAMERA_RESULT_CODE:
                if (data != null) {
                    Bundle data_bundle = data.getExtras();
                    if (data_bundle != null) {
                        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(bitmap);
                    }
                } else {
                    Toast.makeText(this, "Captured Photo is Null.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
