package com.luja93.dbms_performance_benchmark

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader

/**
 * \brief Base helper class for initializing, loading and performing database queries.
 * \details
 *
 * @author  Luka Leopoldović
 * @version 1.0
 * \date 05/04/2020
 * \copyright
 *     This code and information is provided "as is" without warranty of
 *     any kind, either expressed or implied, including but not limited to
 *     the implied warranties of merchantability and/or fitness for a
 *     particular purpose.
 */
abstract class BaseHelpers<City, Database> {

    //region CLASS PROPERTIES
    protected val gson: Gson = GsonBuilder().create()
    protected val cities: MutableList<City> = mutableListOf()
    protected var isCitiesLoaded: Boolean = false
    //endregion


    //region PUBLIC FUNCTIONS
    /**
     * Returns a list of [City] with the size of [take].
     *
     * @param [take] The count of the elements in the return list. If 0 or nothing is passed,
     *  returns the entire list of cities acquired with [loadCities].
     */
    fun getCities(take: Int = 0): List<City> {
        return if (take < 1)
            cities
        else
            cities.take(take)
    }
    //endregion


    //region PROTECTED FUNCTIONS
    /**
     * Loads [Assets.TOWNS] and parses them to a list of [City].
     *
     * @param context [Context].
     *
     * @throws ClassCastException if the specified type [CityList] does not match the [cities] type.
     */
    protected inline fun <reified CityList> loadCitiesData(context: Context) {
        if (isCitiesLoaded) return

        if (cities !is CityList)
            throw ClassCastException(
                "The specified type is not correct. Should be the list of " +
                        "related cities."
            )

        val fileReader: Reader = BufferedReader(
            InputStreamReader(context.assets.open(Assets.TOWNS))
        )

        @Suppress("UNCHECKED_CAST")
        cities.addAll(
            gson.fromJson<CityList>(
                fileReader,
                object : TypeToken<CityList>() {}.type
            ) as List<City>
        )

        isCitiesLoaded = true

        fileReader.close()
    }
    //endregion


    //region SETUP
    /**
     * Use this function to create and return an instance of [Database].
     */
    abstract fun buildDb(context: Context): Database

    /**
     * Use this function to load cities via [loadCitiesData].
     */
    abstract fun loadCities(context: Context)
    //endregion


    //region CRUD
    /**
     * Use this function to inserts the given list of cities to the database.
     *
     * @param db [Database] created via [buildDb]
     * @param cities List of [City] to save.
     */
    abstract fun insertCities(db: Database, cities: List<City>)

    /**
     * Use this function to read the cities from the database and return a list of [City].
     *
     * @param db [Database] created via [buildDb]
     */
    abstract fun readCities(db: Database): List<City>

    /**
     * Use this function to updates the database with the given list of cities.
     *
     * @param db [Database] created via [buildDb]
     * @param cities List of [City] to update the database.
     */
    abstract fun updateCities(db: Database, cities: List<City>)

    /**
     * Deletes all the rows from the [City] related database table.
     *
     * @param db [Database] created via [buildDb]
     */
    abstract fun deleteCities(db: Database)
    //endregion
}