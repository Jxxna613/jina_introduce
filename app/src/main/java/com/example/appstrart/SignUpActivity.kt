package com.example.appstrart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        val btn = findViewById<Button>(R.id.btn_1)
        val id_view = findViewById<EditText>(R.id.upid)

        btn.setOnClickListener {
            if (areFieldsEmpty()) {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("ID", id_view.text.toString())
                startActivity(intent)
            }
        }
    }

    private fun areFieldsEmpty(): Boolean {
        val upname = findViewById<EditText>(R.id.upname)
        val upid = findViewById<EditText>(R.id.upid)
        val uppw = findViewById<EditText>(R.id.uppw)
        val upmbti = findViewById<EditText>(R.id.upmbti)
        val uplike = findViewById<EditText>(R.id.uplike)

        val name = upname.text.toString()
        val id = upid.text.toString()
        val pw = uppw.text.toString()
        val mbti = upmbti.text.toString()

        if (name.isEmpty() || id.isEmpty() || pw.isEmpty() || mbti.isEmpty()) {
            Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}