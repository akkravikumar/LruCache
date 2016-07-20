package com.javatechig.customizedlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.customizedlist.R;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

/**
 * Created by Ravikumar on 6/22/2016.
 */
public class PicassoClass extends Activity {
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_activity);

        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso p = new Picasso.Builder(this)
                .memoryCache(new LruCache(24000))
                .build();
        //Loading Image from URL
        p.with(this)
                .load("https://www.simplifiedcoding.net/wp-content/uploads/2015/10/advertise.png")
                .placeholder(R.drawable.placeholder)   // optional
                .error(R.drawable.ic_launcher)      // optional
                .resize(400,400)                        // optional
                .into(imageView);
    }
}