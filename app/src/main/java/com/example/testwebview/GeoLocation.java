package com.example.testwebview;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class GeoLocation extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        WebView webview = new WebView(this);
        setContentView(webview);
        String url = "http://192.168.0.54/gps.php";
        String postData = "userGeoLocation=" + "아이스카이";
        webview.postUrl(url, postData.getBytes());
    }
}
