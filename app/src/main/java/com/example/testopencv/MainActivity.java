package com.example.testopencv;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testopencv.databinding.ActivityMainBinding;

//public class MainActivity extends AppCompatActivity {
//
//    // Used to load the 'testopencv' library on application startup.
//    static {
//        System.loadLibrary("testopencv");
//    }
//
//    private ActivityMainBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        // Example of a call to a native method
//        TextView tv = binding.sampleText;
//        tv.setText(stringFromJNI());
//    }
//
//    /**
//     * A native method that is implemented by the 'testopencv' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
//}


public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("testopencv");
    }
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bitmap Original_bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit);

        ImageView Original_image=findViewById(R.id.Original_image);
        Original_image.setImageBitmap(Original_bitmap);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencv_test(bitmap);
                ImageView Image=findViewById(R.id.Image);
                Image.setImageBitmap(bitmap);
            }
        });

    }
    public static native void opencv_test(Object bitmap);
}