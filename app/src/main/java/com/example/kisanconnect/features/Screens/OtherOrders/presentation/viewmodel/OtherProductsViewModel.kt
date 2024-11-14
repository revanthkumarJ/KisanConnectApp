package com.example.kisanconnect.features.Screens.OtherOrders.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OnTheWayItem
import com.example.kisanconnect.features.Screens.OtherOrders.data.repository.OtherProductsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtherProductsViewModel @Inject constructor(
    private val repo: OtherProductsRepo
):ViewModel() {

    var onTheWayItems = mutableStateOf<List<OnTheWayItem>>(emptyList())
        private set



    fun getOnTheWayItems() {
        viewModelScope.launch {
            try {
                val response = repo.getAllOnTheWay(getAuthHeader())
                onTheWayItems.value = response
            } catch (e: Exception) {
                // Handle exception (e.g., log it or update a UI state variable)
            }
        }
    }

    private fun getAuthHeader(): String {
        // Replace with logic to retrieve token dynamically
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY3MDdjNjM0OGZkMGZiYWFmMDc3NDcwZiIsImVtYWlsIjoicmFtZXNoMUBnbWFpbC5jb20iLCJuYW1lIjoiUmFtZXNoIiwiaXNBZG1pbiI6ZmFsc2UsImlzRmFybWVyIjp0cnVlLCJpc0RlbGl2ZXJ5Qm95IjpmYWxzZSwiaWF0IjoxNzMxNDEzODAyfQ.OeNA3pkfD5sef-Oq1phdE1oxqviwNRujIQjJXFvjs60"
    }
}