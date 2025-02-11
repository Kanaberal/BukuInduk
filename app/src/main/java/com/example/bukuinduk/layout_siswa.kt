package com.example.bukuinduk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class layout_siswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_siswa)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, dashboardsiswa()) // Gunakan nama class fragment yang sesuai
                .commit()
        }

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(dashboardsiswa()) // Gunakan nama class fragment
                    true
                }
                R.id.navigation_biodata -> {
                    replaceFragment(profileFragment()) // Pastikan ini adalah subclass Fragment
                    true
                }
                R.id.navigation_request -> {
                    replaceFragment(RequestFragment())
                    true
                }
                R.id.navigation_eraport -> {
                    replaceFragment(PengajuanFragment()) // Pastikan ini adalah subclass Fragment
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}
