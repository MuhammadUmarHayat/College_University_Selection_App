package com.example.fyp8july23;


import android.graphics.Bitmap;

public class ImageModel {
    private Bitmap image;

    public ImageModel(Bitmap image)
    {
        this.image = image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage()
    {
        return image;
    }
}
