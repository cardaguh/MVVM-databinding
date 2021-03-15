package co.cyclopsapps.practicemvvmdatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentMainBinding
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentMain : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openHome.observe(viewLifecycleOwner) {
            it?.let {
                val direction = FragmentMainDirections.actionFragmentOneToNavHome()
                findNavController().navigate(direction)
                viewModel.homeOpened()
            }
        }

        viewModel.openRecyclerView.observe(viewLifecycleOwner) {
            it?.let {
                val direction = FragmentMainDirections.actionFragmentMainToNavWithRecyclerview()
                findNavController().navigate(direction)
                viewModel.recyclerViewOpened()
            }
        }
    }
}