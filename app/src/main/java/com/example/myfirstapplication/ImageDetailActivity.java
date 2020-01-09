package com.example.myfirstapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        // receive int data from other .java
        // if no any int data -> setTo default: -1
        int index = getIntent().getIntExtra("com.example.ITEM_INDEX", -1);

        if (index > -1){
            int picIndex = getImage(index);     // get the int which represent the image
            ImageView img = (ImageView) findViewById(R.id.Image);
            scaleImg(img, picIndex);
        }
    }

    private int getImage(int index) {
        // R.drawable.images will return an integer that represent the image
        // that integer is generated in build
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int image_id) {
        Display screen = getWindowManager().getDefaultDisplay();    // access to screen
        BitmapFactory.Options options = new BitmapFactory.Options();    // lib for scaling img

        options.inJustDecodeBounds = true;  // makes data of image accessible  e.g.width, height...

        // get image we wanna scale
        BitmapFactory.decodeResource(getResources(), image_id, options);

        int imgWidth = options.outWidth,
            screenWidth = screen.getWidth();

        if (imgWidth > screenWidth)
            // it will makes the image auto scale, e.g. width = width / inSampleSize;
            options.inSampleSize = Math.round((float) imgWidth / (float) screenWidth);

        options.inJustDecodeBounds = false;     // turn off the data accessibility for security

        // update the image after scale it
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), image_id, options);
        img.setImageBitmap(scaledImg);
    }
}
