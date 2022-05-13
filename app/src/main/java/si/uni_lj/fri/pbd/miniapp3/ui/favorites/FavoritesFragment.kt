package si.uni_lj.fri.pbd.miniapp3.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.adapter.RecyclerViewAdapter
import si.uni_lj.fri.pbd.miniapp3.databinding.FragmentFavoritesBinding
import si.uni_lj.fri.pbd.miniapp3.models.FavoritesViewModel

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private var fViewModel: FavoritesViewModel? = null
    private var recyclerAdapter: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fViewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]
        observerSetup()
        recyclerSetup()
    }

    private fun observerSetup() {
        fViewModel?.favorites?.observe(viewLifecycleOwner) { favorites ->
            recyclerAdapter?.setRecipes(favorites)
            recyclerAdapter?.setCaller("FavoritesFragment")
        }
    }

    private fun recyclerSetup() {
        recyclerAdapter = RecyclerViewAdapter()

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerAdapter
    }

}
