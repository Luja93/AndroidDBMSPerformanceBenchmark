package com.luja93.dbms_performance_benchmark.realm

import android.content.Context
import com.luja93.dbms_performance_benchmark.BaseHelpers
import io.realm.Realm

/**
 * \brief Helper class for initializing, loading and performing Realm queries.
 * \details
 *
 * @author  Luka Leopoldović
 * @version 1.0
 * \date 13/04/2020
 * \copyright
 *     This code and information is provided "as is" without warranty of
 *     any kind, either expressed or implied, including but not limited to
 *     the implied warranties of merchantability and/or fitness for a
 *     particular purpose.
 */
object RealmHelpers : BaseHelpers<City_Realm, Realm>() {

    //region SETUP
    override fun buildDb(context: Context): Realm {
        Realm.init(context)

        return Realm.getDefaultInstance()
    }

    override fun loadCities(context: Context) {
        loadCitiesData<List<City_Realm>>(context)
    }
    //endregion


    //region BENCHMARK HELPERS
    override fun insertCities(db: Realm, cities: List<City_Realm>) {
        db.beginTransaction()
        db.insert(cities)
        db.commitTransaction()
    }

    override fun readCities(db: Realm): List<City_Realm> {
        return db.where(City_Realm::class.java).findAll()
    }

    override fun updateCities(db: Realm, cities: List<City_Realm>) {
        db.beginTransaction()
        db.insertOrUpdate(cities)
        db.commitTransaction()
    }

    override fun deleteCities(db: Realm) {
        db.beginTransaction()
        db.delete(City_Realm::class.java)
        db.commitTransaction()
    }
    //endregion
}