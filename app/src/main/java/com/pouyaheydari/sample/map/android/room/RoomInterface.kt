package com.pouyaheydari.sample.map.android.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pouyaheydari.sample.map.android.pojo.Vehicle

@Dao
interface RoomInterface {

    @Query("SELECT * FROM vehicle")
    suspend fun getVehicles(): List<Vehicle>

    @Query("DELETE FROM vehicle")
    suspend fun deleteAllVehicles()

    @Insert
    suspend fun insertVehicle(vehicle: Vehicle)
}