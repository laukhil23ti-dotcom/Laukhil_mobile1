package com.example.laukhil_mobile1.pertemuan11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laukhil_mobile1.R
import com.example.laukhil_mobile1.databinding.ActivityTabPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabPagerBinding

    private val tabTitles = arrayOf("Berita", "Notifikasi", "Profil")
    private val tabIcons = arrayOf(
        R.drawable.ic_nav_home,
        R.drawable.ic_nav_message,
        R.drawable.ic_nav_more
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MainPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // TabLayoutMediator menghubungkan TabLayout & ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
            tab.setIcon(tabIcons[position])
        }.attach()

        // Menambahkan Badge pada Tab Notifikasi (indeks 1)
        val badge = binding.tabLayout.getTabAt(1)?.orCreateBadge
        badge?.apply {
            number = 5
            isVisible = true
        }
    }
}
