package co.cyclopsapps.practicemvvmdatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentCartBinding

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentCart : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return binding.root
    }
}