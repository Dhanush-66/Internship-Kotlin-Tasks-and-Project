package com.example.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.task1.R.id.editTextTextPersonName

class MainActivity : AppCompatActivity() {
    private lateinit var b1: Button
    private lateinit var e1: EditText
    private lateinit var t1: TextView
    private lateinit var b2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        e1=findViewById(editTextTextPersonName)
        b1=findViewById(R.id.button)
        t1=findViewById(R.id.textView)
        b2=findViewById(R.id.button2)

        b1.setOnClickListener {
            val name = e1.text.toString()
            t1.text = "Hello $name"
        }
        b2.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            val name2 = e1.text.toString()
            intent.putExtra("EXTRA_TEXT", name2)
            startActivity(intent)
        }

    }
}