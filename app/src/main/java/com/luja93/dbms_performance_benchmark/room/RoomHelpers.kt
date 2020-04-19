package com.luja93.dbms_performance_benchmark.room

import android.content.Context
import androidx.room.Room
import com.luja93.dbms_performance_benchmark.BaseHelpers

/**
 * \brief Helper class for initializing, loading and performing Room queries.
 * \details
 *
 * @author  Luka Leopoldović
 * @version 1.0
 * \date 23/03/2020
 * \copyright
 *     This code and information is provided "as is" without warranty of
 *     any kind, either expressed or implied, including but not limited to
 *     the implied warranties of merchantability and/or fitness for a
 *     particular purpose.
 */
object RoomHelpers : BaseHelpers<City_Room, RoomDB>() {

    //region SETUP
    override fun buildDb(context: Context): RoomDB {
        return Room.databaseBuilder(context, RoomDB::class.java, "RoomDB")
            .allowMainThreadQueries()
            .build()
    }

    override fun loadCities(context: Context) {
        loadCitiesData<List<City_Room>>(context)
    }
    //endregion


    //region BENCHMARK HELPERS
    override fun insertCities(db: RoomDB, cities: List<City_Room>) {
        db.cityDao().insertCities(cities)
    }

    override fun readCities(db: RoomDB): List<City_Room> {
        return db.cityDao().readCities()
    }

    override fun updateCities(db: RoomDB, cities: List<City_Room>) {
        db.cityDao().updateCities(cities)
    }

    override fun deleteCities(db: RoomDB) {
        db.cityDao().deleteCities()
    }
    //endregion
}