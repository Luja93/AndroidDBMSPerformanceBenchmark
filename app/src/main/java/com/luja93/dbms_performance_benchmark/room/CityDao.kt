package com.luja93.dbms_performance_benchmark.room

import androidx.room.*

/**
 * \brief [City_Room] data access object.
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
@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<City_Room>)

    @Query("SELECT * FROM City_Room")
    fun readCities(): List<City_Room>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCities(cities: List<City_Room>)

    @Query("DELETE FROM City_Room")
    fun deleteCities()

}