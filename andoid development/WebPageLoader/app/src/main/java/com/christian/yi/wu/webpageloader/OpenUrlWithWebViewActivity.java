package com.christian.yi.wu.webpageloader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/9/7.
 */

public class OpenUrlWithWebViewActivity extends AppCompatActivity {

    private static final String baseURL = "http://google.translate.cn/m";
    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_url_with_web_view);
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.loadUrl(baseURL);

        try {
            URL newURL = new URL(baseURL);
            URLConnection connect = newURL.openConnection();
            InputStream is = connect.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis, "utf-8"));
            String html = "";
            String readLine = "";
            while ((readLine = br.readLine()) != null) {
                html = html + readLine;
                Log.d("OpenWebviewActivity", readLine);
            }
            br.close();
            dis.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
