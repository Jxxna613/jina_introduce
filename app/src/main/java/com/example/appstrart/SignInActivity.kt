package com.example.appstrart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)

        val btn = findViewById<Button>(R.id.btn)
        val id_view = findViewById<EditText>(R.id.inid)
        btn.setOnClickListener {
            if (areFields()) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("ID", id_view.text.toString())
                startActivity(intent)
            }
        }

        val btn_1 = findViewById<Button>(R.id.btn_1)
        btn_1.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
// 다 채우지 않았을 경우 로그인 진행 불가 , 다음엔 areFieldsEmpty => 필드가 비었을 때를 areFields로 변경해주면 아래에 false 및 true에서 헷갈리지 않을 수 있다.
    private fun areFields(): Boolean {
        val inid = findViewById<EditText>(R.id.inid)
        val inpw = findViewById<EditText>(R.id.inpw)

        val id = inid.text.toString()
        val pw = inpw.text.toString()

        if (id.isEmpty() || pw.isEmpty()) {
            Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            return false
        }
        Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
        return true
    }
}
