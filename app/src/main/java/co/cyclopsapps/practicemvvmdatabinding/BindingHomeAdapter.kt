package co.cyclopsapps.practicemvvmdatabinding

import android.media.Image
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.practicemvvmdatabinding.model.FirstFunctionItem
import co.cyclopsapps.practicemvvmdatabinding.withrecyclerview.ItemsAdapter
import com.bumptech.glide.Glide

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */

@BindingAdapter(value = ["functions", "position"], requireAll = false)
fun loadFunctionsImage(view: ImageView, functions: ArrayList<FirstFunctionItem>?, position: Int) {
    functions?.let {
        if(functions.size > position) {
            Log.d("Binding Adapter", functions[position].image)
            Log.d("Binding Adapter", "position: $position")
            Log.d("Binding Adapter", "position: ${functions[position]}")
            Glide
                .with(view.context)
                .load(functions[position].image)
                .into(view)
        }
    }
}

@BindingAdapter(value = ["showFirstFunction", "position"], requireAll = false)
fun showFirstFunction(view : View, showFirstFunction: ArrayList<FirstFunctionItem>?, position: Int) {
    showFirstFunction?.let {
        if(showFirstFunction.size > position) {
            if(showFirstFunction[position].visible) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        } else {
            view.visibility = View.GONE
        }
    }
}

@BindingAdapter(value = ["functions", "position"], requireAll = false)
fun loadFunctionText(view : TextView, functions: ArrayList<FirstFunctionItem>?, position: Int) {
    functions?.let {
        if(functions.size > position) {
            view.text = functions[position].title
        }
    }
}

@BindingAdapter("setAdapter")
fun setAdapter(view : RecyclerView, itemsAdapter: ItemsAdapter) {
    view.adapter = itemsAdapter
}



