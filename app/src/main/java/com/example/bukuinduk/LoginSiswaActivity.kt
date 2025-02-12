package com.example.bukuinduk

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class LoginSiswaActivity : AppCompatActivity() {

    private lateinit var etTanggalLahir: EditText
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_siswa)

        etTanggalLahir = findViewById(R.id.et_tanggal_lahir)

        // "Masuk" button click
        val btnMasuk: Button = findViewById(R.id.btn_masuk)
        btnMasuk.setOnClickListener {
            val intent = Intent(this, layout_siswa::class.java)
            startActivity(intent)
        }

        // "Kembali" button click
        val btnKembali: Button = findViewById(R.id.btn_kembali)
        btnKembali.setOnClickListener {
            startActivity(Intent(this, MainHomePageActivity::class.java))
            finish()
        }
    }

    fun showDatePickerDialog(view: View) {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

        val datePickerDialog = DatePickerDialog(
            this,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etTanggalLahir.setText(sdf.format(calendar.time))
    }
}
