package com.example.testwebview;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GeoLocationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity changeData = new MainActivity();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }
}
