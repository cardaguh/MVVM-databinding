package co.cyclopsapps.practicemvvmdatabinding.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.cyclopsapps.practicemvvmdatabinding.model.FirstFunctionItem

class HomeOneViewModel(app: Application) : AndroidViewModel(app) {
    public val firstFunctionsList = MutableLiveData<ArrayList<FirstFunctionItem>>()
    var navigationRoute = ""

    private val _showLogin = MutableLiveData<Boolean>()
    val showLogin: LiveData<Boolean> = _showLogin

    private val _openCat2 = MutableLiveData<Boolean>()
    val openCat2: LiveData<Boolean> = _openCat2

    private val _openCat3 = MutableLiveData<Boolean>()
    val openCat3: LiveData<Boolean> = _openCat3

    private val _openCat4 = MutableLiveData<Boolean>()
    val openCat4: LiveData<Boolean> = _openCat4

    init {
        val list = ArrayList<FirstFunctionItem>()
        list.add(
            FirstFunctionItem(
                "https://picsum.photos/id/237/200/200",
                "one",
                "Category 1",
                true,
                "https://picsum.photos/id/237/200/300",
                true
            )
        )
        list.add(
            FirstFunctionItem(
                "https://picsum.photos/id/238/200/200",
                "two",
                "Category 2",
                true,
                "https://picsum.photos/id/237/200/300",
                false
            )
        )
        list.add(
            FirstFunctionItem(
                "https://picsum.photos/id/239/200/200",
                "three",
                "Category 3",
                true,
                "https://picsum.photos/id/237/200/300",
                false
            )
        )
        list.add(
            FirstFunctionItem(
                "https://picsum.photos/id/240/200/200",
                "four",
                "Category 4",
                true,
                "https://picsum.photos/id/237/200/300",
                false
            )
        )
        firstFunctionsList.value = list
    }

    fun navigate(firstFunctionItem: FirstFunctionItem) {
        if (firstFunctionItem.loginRequired) {
            _showLogin.value = true
        } else {
            navigationRoute = firstFunctionItem.route
            navigate()
        }
    }

    fun navigate() {
        when (navigationRoute) {
            "two" -> _openCat2.value = true
            "three" -> _openCat3.value = true
            else -> _openCat4.value = true
        }
    }

    fun loginOpened() {
        _showLogin.value = null
    }

    fun category2Opened() {
        _openCat2.value = null
    }

    fun category3Opened() {
        _openCat3.value = null
    }

    fun category4Opened() {
        _openCat4.value = null
    }

}
