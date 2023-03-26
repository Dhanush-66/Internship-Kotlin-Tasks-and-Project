package com.example.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var b1: Button
        var t4: TextView
        b1=findViewById(R.id.button3)
        t4=findViewById(R.id.textView2)
        val name1 = intent.getStringExtra("EXTRA_TEXT")
        b1.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }
        t4.text= "Welcome to 2nd page $name1"

    }
}