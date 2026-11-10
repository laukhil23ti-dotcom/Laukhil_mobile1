package com.example.laukhil_mobile1.pertemuan11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laukhil_mobile1.databinding.FragmentFirstTabBinding

class FirstTabFragment : Fragment() {

    private var _binding: FragmentFirstTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsList = listOf(
            NewsModel(1, "Peluncuran Fitur Baru Android 15", "Google mengumumkan fitur privasi dan kinerja terbaru pada update Android 15.", "https://picsum.photos/200/200?random=1"),
            NewsModel(2, "Workshop Mobile Development", "Mahasiswa PCR sukses menyelenggarakan workshop pembuatan aplikasi Android dengan Kotlin.", "https://picsum.photos/200/200?random=2"),
            NewsModel(3, "Update Terbaru Jetpack Compose", "Panduan praktis mengimplementasikan komponen Material 3 modern.", "https://picsum.photos/200/200?random=3"),
            NewsModel(4, "Tips Optimasi RecyclerView", "Cara mengoptimalkan kinerja RecyclerView agar tidak lag saat memuat ribuan data.", "https://picsum.photos/200/200?random=4"),
            NewsModel(5, "Integrasi ViewPager2 & TabLayout", "Tutorial lengkap membuat tampilan tab yang responsive dan responsif di Android Studio.", "https://picsum.photos/200/200?random=5")
        )

        val adapter = NewsAdapter(newsList) { selectedNews ->
            Toast.makeText(requireContext(), "Berita dipilih: ${selectedNews.title}", Toast.LENGTH_SHORT).show()
        }

        binding.rvNewsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNewsList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
