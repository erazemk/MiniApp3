package si.uni_lj.fri.pbd.miniapp3.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.zhanghai.android.materialprogressbar.MaterialProgressBar
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.adapter.RecyclerViewAdapter
import si.uni_lj.fri.pbd.miniapp3.adapter.SpinnerAdapter
import si.uni_lj.fri.pbd.miniapp3.databinding.FragmentSearchBinding
import si.uni_lj.fri.pbd.miniapp3.models.SearchViewModel
import si.uni_lj.fri.pbd.miniapp3.models.dto.IngredientsDTO
import timber.log.Timber

class SearchFragment: Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private var sViewModel: SearchViewModel? = null
    private var spinnerAdapter: SpinnerAdapter? = null
    private var recyclerAdapter: RecyclerViewAdapter? = null
    private var progressBar: MaterialProgressBar? = null

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

        progressBar = binding.progressBar
        progressBar?.visibility = View.INVISIBLE

        sViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        sViewModel?.getIngredients()

        observerSetup()
        recyclerSetup()
    }

    private fun observerSetup() {
        // Observer for ingredients - spinner
        sViewModel?.allIngredients?.observe(viewLifecycleOwner) { ingredients ->
            Timber.d("Updated list of ingredients")
            spinnerSetup(ingredients)
        }

        // Observer for drinks - recyclerView
        sViewModel?.searchResults?.observe(viewLifecycleOwner) { recipes ->
            Timber.d("Updated list of drinks")
            recyclerAdapter?.setRecipesFromDto(recipes.drinks)
            recyclerAdapter?.setCaller("SearchFragment")
            progressBar?.visibility = View.INVISIBLE
        }
    }

    private fun recyclerSetup() {
        recyclerAdapter = RecyclerViewAdapter()

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerAdapter
    }

    // Source: https://www.geeksforgeeks.org/spinner-in-kotlin/
    private fun spinnerSetup(ingredients: IngredientsDTO) {
        spinnerAdapter = SpinnerAdapter(ingredients)

        val spinner: Spinner = binding.spinner
        spinner.adapter = spinnerAdapter

        // Prevent auto selecting first ingredient
        //spinner.setSelection(spinner.selectedItemPosition, false)

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                sViewModel?.getRecipesByIngredient(spinnerAdapter?.getItem(position) as String)
                progressBar?.visibility = View.VISIBLE
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

}
