package org.geeksforgeeks.webpageloadingstatus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view_1)
        val mWebView = findViewById<WebView>(R.id.web_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        mButton.setOnClickListener {

            mWebView.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    mTextView.text = "Loading: $newProgress%"
                    if(newProgress == 100){
                        mTextView.text = "Loaded!"
                    }
                }
            }

            mWebView.loadUrl("https://www.geeksforgeeks.org")
        }
    }
}