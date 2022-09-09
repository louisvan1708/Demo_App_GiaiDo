package com.example.demo_app_giaido

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_Start)

        button.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity :: class.java)
            startActivity(intent)
        }

    }
}