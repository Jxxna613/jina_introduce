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
            if (areFields()) {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("ID", id_view.text.toString())
                startActivity(intent)
            }
        }
    }
    // 다 채우지 않았을 경우 로그인 진행 불가 , 다음엔 areFieldsEmpty => 필드가 비었을 때를 areFields로 변경해주면 아래에 false 및 true에서 헷갈리지 않을 수 있다.
    private fun areFields(): Boolean {
        val upname = findViewById<EditText>(R.id.upname)
        val upid = findViewById<EditText>(R.id.upid)
        val uppw = findViewById<EditText>(R.id.uppw)
        val upmbti = findViewById<EditText>(R.id.upmbti)
        val uplike = findViewById<EditText>(R.id.uplike)

        val name = upname.text.toString()
        val id = upid.text.toString()
        val pw = uppw.text.toString()
        val mbti = upmbti.text.toString()
        var like = uplike.text.toString()

        if (name.isEmpty() || id.isEmpty() || pw.isEmpty() || mbti.isEmpty() || like.isEmpty ()) {
            Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}