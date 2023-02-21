package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.animate().scaleX(0.5f).scaleY(-0.5f).setDuration(2000);

    }
}