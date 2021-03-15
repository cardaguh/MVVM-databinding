package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class RecyclerOneViewModel(app: Application) : AndroidViewModel(app) {

    var itemsAdapter = MutableLiveData<ItemsAdapter>()
    val itemList = ArrayList<String>()

    private val _itemSelected = MutableLiveData<String>()
    val itemSelected: LiveData<String> = _itemSelected

    lateinit var observerOnCategorySelected: Observer<String>

    init {
        for (i in 1..50) {
            itemList.add("Item $i")
        }
        initObserver()
    }

    fun initObserver() {
        observerOnCategorySelected = Observer { value ->
            value.let {
                _itemSelected.value = it
            }
        }
    }

    fun loadItemsRecyclerView() {
        val adapter = ItemsAdapter(itemList)
        itemsAdapter.value = adapter
        adapter.onItemSelected.observeForever(observerOnCategorySelected)
        adapter.notifyDataSetChanged()
    }

    fun clearSelection() {
        _itemSelected.value = null
    }

}
