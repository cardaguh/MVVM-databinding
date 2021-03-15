package co.cyclopsapps.practicemvvmdatabinding.home

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
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentHomeOneBinding
import co.cyclopsapps.practicemvvmdatabinding.home.FragmentHomeOneDirections.*

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentHomeOne: Fragment() {

    lateinit var viewModel: HomeOneViewModel
    lateinit var binding: FragmentHomeOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeOneViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_one, container, false)
        binding.viewModel = viewModel
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showLogin.observe(viewLifecycleOwner) {
            it?.let {
                Toast.makeText(context, "Show Login", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.showLogin.observe(viewLifecycleOwner) {
            it?.let {
                Toast.makeText(context, "Show Login", Toast.LENGTH_SHORT).show()
                viewModel.loginOpened()
            }
        }

        viewModel.openCat2.observe(viewLifecycleOwner) {
            it?.let {
                val direction =
                    actionFragmentHomeOneToFragmentHomeTwo("Category 2")
                findNavController().navigate(direction)
                viewModel.category2Opened()
            }
        }

        viewModel.openCat3.observe(viewLifecycleOwner) {
            it?.let {
                val direction =
                    actionFragmentHomeOneToFragmentHomeTwo("Category 3")
                findNavController().navigate(direction)
                viewModel.category3Opened()
            }
        }

        viewModel.openCat4.observe(viewLifecycleOwner) {
            it?.let {
                val direction =
                    actionFragmentHomeOneToFragmentHomeTwo("Category 4")
                findNavController().navigate(direction)
                viewModel.category4Opened()
            }
        }
    }
}