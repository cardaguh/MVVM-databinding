package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import co.cyclopsapps.practicemvvmdatabinding.R
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentRecyclerviewBinding

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentRecyclerOne: Fragment() {

    lateinit var viewModel: RecyclerOneViewModel
    lateinit var binding: FragmentRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecyclerOneViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_recyclerview, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadItemsRecyclerView()

        viewModel.itemSelected.observe(viewLifecycleOwner) {
            it?.let {
                Toast.makeText(context, "$it Selected", Toast.LENGTH_SHORT).show()
                viewModel.clearSelection()
                //findNavController(R.id.nav_host_fragment).navigate(R.id.fragmentProfile)
                findNavController().navigate(R.id.fragmentDetail)
            }
        }
    }
}