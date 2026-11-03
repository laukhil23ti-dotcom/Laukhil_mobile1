package com.example.laukhil_mobile1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laukhil_mobile1.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

open class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Chip & ChipGroup Listener
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val chip = group.findViewById<Chip>(checkedIds[0])
                chip?.let {
                    Toast.makeText(this, "Filter: ${it.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Event Click Login Button
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (email.isEmpty()) {
                binding.textInputLayoutEmail.error = "Email tidak boleh kosong"
            } else {
                binding.textInputLayoutEmail.error = null
                Snackbar.make(binding.root, "Login berhasil untuk $email", Snackbar.LENGTH_SHORT).show()
            }
        }

        // Event Click Grid Menu Buttons
        val menuButtons = listOf(
            binding.btnMenu1,
            binding.btnMenu2,
            binding.btnMenu3,
            binding.btnMenu4,
            binding.btnMenu5,
            binding.btnMenu6
        )

        menuButtons.forEach { button ->
            button.setOnClickListener {
                Toast.makeText(this, "Klik ${button.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
