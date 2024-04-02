package com.example.mylibrarymaven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.nsdl.egov.esignaar.NsdlEsignActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var textview = findViewById<TextView>(R.id.textView)

        textview.setOnClickListener{

            val appStartIntent = Intent(this, NsdlEsignActivity::class.java)
            appStartIntent.putExtra("msg", "jhbjkhvjhvhjvhjbhjjhvhvvhjv jh vj hj hj hj ")
            appStartIntent.putExtra("env", "PROD")
            appStartIntent.putExtra("returnUrl", "com.mobile.nsdlcommonsdk.accountopening.ApplicationFormFragment")
            startActivityForResult(appStartIntent, 101)

            Toast.makeText(this,"Invoke NsdlEsignActivity",Toast.LENGTH_SHORT).show()

        }

    }
}