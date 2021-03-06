package com.apple.hightrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Button button;
    WebView webView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button = findViewById(R.id.button);
        webView = findViewById(R.id.webview2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "웹사이트로 이동",
                        Toast.LENGTH_SHORT
                    ).show();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://ec2-43-200-2-85.ap-northeast-2.compute.amazonaws.com:8080/trip/main.jsp")
                        );
                startActivity(intent);
            } // onclick
        }); // button

        webView.setWebViewClient(new TripClient2());
        // webview에 url을 끼워넣을 객체를 하나 지정
        // url을 끼워넣어주는 객체를 webViewClient
        // 사이트를 액티비티에 끼워넣었을 때
        // 여러 설정을 따로 해주어야 한다
        // 여러 설정만을 담당하는 객체를 사용한다
        WebSettings webSet = webView.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);
        webSet.setAllowContentAccess(true);
        webSet.setAppCacheEnabled(true);
        webSet.setDomStorageEnabled(true);
        webSet.setUseWideViewPort(true);
        webSet.setAllowFileAccess(true);
        webSet.setAllowFileAccessFromFileURLs(true);

        webView.loadUrl("http://ec2-43-200-2-85.ap-northeast-2.compute.amazonaws.com:8080/trip/main.jsp");
    }
}

class TripClient2 extends WebViewClient{

    // 오버라이드

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }
}
