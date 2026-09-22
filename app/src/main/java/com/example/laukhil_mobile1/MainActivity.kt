package com.example.laukhil_mobile1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.laukhil_mobile1.databinding.ActivityMainBinding
import com.example.laukhil_mobile1.pertemuan4.FourthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "{nama_activity} dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Hapus setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)

            Toast.makeText(this, "Berhasil berpindah ke FourthActivity", Toast.LENGTH_SHORT).show()
        }
    }
        override fun onStart() {
            super.onStart()
            Log.e("onStart", "onStart: {Fourth_activity} terlihat di layar")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.e("onDestroy", "{Fourth_activity} dihapus dari stack")
        }
    }
