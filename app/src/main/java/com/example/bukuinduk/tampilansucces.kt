package com.example.bukuinduk

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class tampilansucces : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilansucces)

        val btnBack: Button = findViewById(R.id.btn_back)

        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke activity sebelumnya
        }
    }
}
