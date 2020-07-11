package com.pouyaheydari.sample.map.android.features.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.sample.map.android.base.BaseViewModel
import com.pouyaheydari.sample.map.android.pojo.VehiclesData
import com.pouyaheydari.sample.map.android.repository.DataRepositoryInterface
import com.pouyaheydari.sample.map.android.utils.coroutinesExceptionHandler
import kotlinx.coroutines.launch

class MapsViewModel(private val repository: DataRepositoryInterface) : BaseViewModel() {
    private val liveData = MutableLiveData<VehiclesData>()

    fun getVehicles() = viewModelScope.launch(coroutinesExceptionHandler(exceptionLiveData)) {
        val vehicles = repository.getVehicles()
        liveData.postValue(vehicles)
    }

    /**
     * Turns the MutableLiveData to LiveData to prevent accidental postValue on the Fragment
     *
     * @return liveData of type [VehiclesData]
     */
    fun getVehicleLiveData(): LiveData<VehiclesData> = liveData
}