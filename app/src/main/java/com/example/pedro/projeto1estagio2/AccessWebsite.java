package com.example.pedro.projeto1estagio2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class AccessWebsite extends AppCompatActivity {

    private EditText etURL;
    private WebView webview;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_website);
        etURL = (EditText)findViewById(R.id.etURL);
        webview = (WebView)findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewCustomClient());
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setSupportZoom(true);

    }

    public void access(View v){
        progress = new ProgressDialog(this);
        progress.setTitle("Atenção!");
        progress.setMessage("Carregando a pagina");
        progress.show();
        webview.loadUrl(etURL.getText().toString());
    }

    private class WebViewCustomClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if(webview.getProgress() == 100) {
                progress.dismiss();
            }
        }
    }
}
