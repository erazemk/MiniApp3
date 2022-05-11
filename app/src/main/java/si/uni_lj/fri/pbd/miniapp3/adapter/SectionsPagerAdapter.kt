package si.uni_lj.fri.pbd.miniapp3.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import si.uni_lj.fri.pbd.miniapp3.ui.favorites.FavoritesFragment
import si.uni_lj.fri.pbd.miniapp3.ui.search.SearchFragment

class SectionsPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> FavoritesFragment()
            else -> SearchFragment()
        }
    }

}
