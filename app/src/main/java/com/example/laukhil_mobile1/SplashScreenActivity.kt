package com.example.laukhil_mobile1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Memberi delay 3000 ms (3 detik)
        Handler(Looper.getMainLooper()).postDelayed({

            // 1. Inisialisasi SharedPreferences
            val sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE)

            // 2. Ambil status isLoggedIn (default: false)
            val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

            // 3. Cek kondisi login
            if (isLoggedIn) {
                // Jika sudah login, langsung ke MainActivity
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika belum login, arahkan ke AuthActivity
                val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
            }

            // Tutup SplashScreenActivity agar tidak bisa kembali ke splash screen saat di-back
            finish()

        }, 3000)
    }
}
