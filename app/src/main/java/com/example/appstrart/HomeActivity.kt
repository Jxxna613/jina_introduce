package com.example.appstrart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val btn = findViewById<Button>(R.id.before)
        btn.setOnClickListener{
            finish()
        }
        //ID 값 intent 받아오기
        val myID = intent.getStringExtra("ID")

        val idTextView = findViewById<TextView>(R.id.idTextView)

        idTextView.text = "    ◼   ID : $myID "

// 자기소개 랜덤이미지
        val photoImageView = findViewById<ImageView>(R.id.imageView)

        val photoResources = arrayOf(
            R.drawable.jina_ai_1,
            R.drawable.jina_ai_2,
            R.drawable.jina_ai_3,
            R.drawable.jina_ai_4,
            R.drawable.jina_ai_5
        )

        val randomIndex = Random.nextInt(photoResources.size)
        photoImageView.setImageResource(photoResources[randomIndex])
    }
}

