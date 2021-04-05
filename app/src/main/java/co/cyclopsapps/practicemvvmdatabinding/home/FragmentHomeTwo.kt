package co.cyclopsapps.practicemvvmdatabinding.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.cyclopsapps.practicemvvmdatabinding.R
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentHomeTwoBinding
import co.cyclopsapps.practicemvvmdatabinding.home.FragmentHomeTwoArgs.fromBundle

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentHomeTwo : Fragment() {

    lateinit var binding: FragmentHomeTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_two, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = fromBundle(requireArguments())
        binding.textView.text = args.category
    }
}