package si.uni_lj.fri.pbd.miniapp3.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.adapter.RecyclerViewAdapter
import si.uni_lj.fri.pbd.miniapp3.adapter.SpinnerAdapter
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails
import si.uni_lj.fri.pbd.miniapp3.databinding.FragmentSearchBinding
import si.uni_lj.fri.pbd.miniapp3.models.SearchViewModel

class SearchFragment: Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private var sViewModel: SearchViewModel? = null
    private var spinnerAdapter: SpinnerAdapter? = null
    private var recyclerAdapter: RecyclerViewAdapter? = null

    private var recipes: List<RecipeDetails>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        spinnerAdapter = SpinnerAdapter(sViewModel?.getIngredients())
        // = RecyclerViewAdapter()
    }

}
