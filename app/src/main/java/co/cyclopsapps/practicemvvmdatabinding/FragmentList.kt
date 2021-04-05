package co.cyclopsapps.practicemvvmdatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentListBinding

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentList : Fragment() {

    lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }
}