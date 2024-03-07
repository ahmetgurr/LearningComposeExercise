package com.example.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    //ilk basta _categorieState'i private şekilde tanımladık daha sonra state olarak dışarıya açtık
    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState

    init {
        fetchCategories()
    }

    //coroutine kullanarak veri çekme işlemini gerçekleştirdik
    //asenkron işlemleri yürütmek ve UI thread'i bloke etmeden uzun süren işlemleri gerçekleştirmek
    private fun fetchCategories(){
        viewModelScope.launch {
            //try bloğunda val response = recipeService derken recipeService'i çağırdık
            //.getCategories() diyerek veri çektik ve CategoriesResponse tipinde bir response döndürdük bu da Category listesi döndürdü
            //_categorieState.value değerini kopladık ve içerisindeki list değerini response.categories ile değiştirdik
            //loading değerini false yaptık ve error'ı null yaptık
            //catch bloğunda ise hata durumunda error mesajını döndürdük
            try {
                val response = recipeService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = e.message
                )
            }

        }
    }

    //importlarda sorun var dıkkatlı bak dakika 4
    data class RecipeState(
        val loading: Boolean = false,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

}