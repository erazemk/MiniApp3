package si.uni_lj.fri.pbd.miniapp3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.adapter.SectionsPagerAdapter
import si.uni_lj.fri.pbd.miniapp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        viewPager.adapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)

        // Source: https://medium.com/busoft/how-to-use-viewpager2-with-tablayout-in-android-eaf5b810ef7c
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (position == 0) {
                tab.text = R.string.toolbar_tab_1.toString()
            } else {
                tab.text = R.string.toolbar_tab_2.toString()
            }
        }.attach()
    }
}
