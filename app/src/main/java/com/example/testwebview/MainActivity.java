package com.example.testwebview;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import static android.Manifest.permission.READ_PHONE_STATE;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    TextView textView;
    TelephonyManager telephonyManager;
    String url = "";
    String postData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity changeData = new MainActivity();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);
        }else{
            WebView webview = new WebView(this);
            String PhoneNum = "0000000000";
            PhoneNum = telephonyManager.getLine1Number();
            setContentView(webview);
//            this.getData(PhoneNum);
            if (PhoneNum.startsWith("+82")) {
                PhoneNum = PhoneNum.replace("+82", "0");
            }
            String url = "http://192.168.0.54/test.php";
            String postData = "userNumber=" + PhoneNum;
            this.getData(url, postData);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE: if( ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
                return;
            }
            else{
                WebView webview = new WebView(this);
                String PhoneNum = "0000000000";
                PhoneNum = telephonyManager.getLine1Number();
                setContentView(webview);
                if (PhoneNum.startsWith("+82")) {
                    PhoneNum = PhoneNum.replace("+82", "0");
                }
                String url = "http://192.168.0.54/test.php";
                String postData = "userNumber=" + PhoneNum;
                webview.postUrl(url, postData.getBytes());
            }
        }
    }
    public void getData(String url, String postData){
        WebView webview = new WebView(this);
        System.out.print("sssssss");
        webview.postUrl(url, postData.getBytes());

    }
}