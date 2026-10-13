package com.example.laukhil_mobile1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.laukhil_mobile1.pertemuan6.BaseActivity

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Validasi kredensial baru: Username = "laukhil", Password = "laukhil79"
            if (username == "laukhil" && password == "laukhil79") {

                // 1. Simpan session login ke SharedPreferences
                val sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.putString("username", username)
                editor.apply()

                // 2. Berhasil -> Pindah ke BaseActivity (Halaman Utama dengan Bottom Navigation)
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                // Gagal -> AlertDialog
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau password salah. Silahkan coba lagi.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}
