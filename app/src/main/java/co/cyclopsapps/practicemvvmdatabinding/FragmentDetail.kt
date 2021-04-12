package co.cyclopsapps.practicemvvmdatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentDetailBinding
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentProfileBinding

/**
 * Created by Carlos Daniel Agudelo on 11/04/2021.
 */
class FragmentDetail: Fragment() {
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }
}