package si.uni_lj.fri.pbd.miniapp3.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import si.uni_lj.fri.pbd.miniapp3.ui.favorites.FavoritesFragment
import si.uni_lj.fri.pbd.miniapp3.ui.search.SearchFragment

class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> FavoritesFragment()
            else -> SearchFragment()
        }
    }

}
