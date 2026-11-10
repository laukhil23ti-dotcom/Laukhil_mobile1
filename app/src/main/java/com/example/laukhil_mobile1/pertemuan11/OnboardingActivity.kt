package com.example.laukhil_mobile1.pertemuan11

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laukhil_mobile1.databinding.ActivityOnboardingBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            OnboardingItem(
                title = "Selamat Datang di Mobile App",
                description = "Pelajari modul Pertemuan 11 dengan fitur ViewPager2, TabLayout, dan RecyclerView.",
                imageUrl = "https://picsum.photos/400/400?random=10"
            ),
            OnboardingItem(
                title = "Pengalaman Interaktif",
                description = "Navigasi halaman dengan mudah menggunakan indikator cacing dari dotsindicator.",
                imageUrl = "https://picsum.photos/400/400?random=11"
            ),
            OnboardingItem(
                title = "Siap Digunakan",
                description = "Klik tombol di bawah untuk mulai menjelajahi aplikasi.",
                imageUrl = "https://picsum.photos/400/400?random=12"
            )
        )

        val adapter = OnboardingAdapter(items)
        binding.viewPagerOnboarding.adapter = adapter

        // Hubungkan dotsindicator dengan ViewPager2
        binding.dotsIndicator.attachTo(binding.viewPagerOnboarding)

        binding.btnNext.setOnClickListener {
            if (binding.viewPagerOnboarding.currentItem < adapter.itemCount - 1) {
                binding.viewPagerOnboarding.currentItem += 1
            } else {
                startActivity(Intent(this, TabPagerActivity::class.java))
                finish()
            }
        }
    }
}
