package com.thetapractice.KotlinProjectBatchNov2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        thetaWebView.loadUrl("https://thetasolutions.pk/")
        thetaWebView.settings.javaScriptEnabled=true

        thetaWebView.webViewClient= WebViewClient()


    }

    override fun onBackPressed() {
        if(thetaWebView.canGoBack())
        {
            thetaWebView.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}