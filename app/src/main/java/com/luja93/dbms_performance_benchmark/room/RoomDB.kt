package com.luja93.dbms_performance_benchmark.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * \brief Base Room database class.
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
@Database(
    version = 1,
    entities = [City_Room::class]
)
abstract class RoomDB : RoomDatabase() {

    abstract fun cityDao(): CityDao

}