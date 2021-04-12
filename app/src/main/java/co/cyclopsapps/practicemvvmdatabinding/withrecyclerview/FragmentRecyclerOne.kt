package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.practicemvvmdatabinding.FragmentDetail
import co.cyclopsapps.practicemvvmdatabinding.R
import co.cyclopsapps.practicemvvmdatabinding.databinding.FragmentRecyclerviewBinding

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class FragmentRecyclerOne : Fragment() {

    lateinit var viewModel: RecyclerOneViewModel
    lateinit var binding: FragmentRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecyclerOneViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_recyclerview, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //TODO (Cristofer) Migrar a DataBinding la inicialización
        //declramos recyclerview y adapter
        binding.recyclerview.layoutManager =  LinearLayoutManager(context)
        val mAdapter =  ItemsAdapter()
        binding.recyclerview.adapter = mAdapter

        //Escuchamos el click del item
        viewModel.itemSelected.observe(viewLifecycleOwner) {
            it?.let {
                Toast.makeText(context, "$it Selected", Toast.LENGTH_SHORT).show()
                viewModel.clearSelection()
                //findNavController().navigate(R.id.fragmentDetail)


                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(android.R.id.content, FragmentDetail.newInstance())
                    ?.addToBackStack(null)?.commitAllowingStateLoss()

            }
        }

        //Escuchamos cuando el servicio nos traiga una respuesta y actualizamos el adapter
        viewModel.listState.observe(viewLifecycleOwner) {
            mAdapter.setItems(list = it)
        }


        //Mandamos a llamar al servicio
        viewModel.fetchMorthyData()

    }
}