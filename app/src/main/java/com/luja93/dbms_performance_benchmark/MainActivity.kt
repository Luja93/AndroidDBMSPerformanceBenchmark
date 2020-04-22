package com.luja93.dbms_performance_benchmark

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.luja93.dbms_performance_benchmark.sqlite.SQLiteHelpers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Change the helpers object to any of defined DBMS helpers to try out the implementations.
         */
        val helpers = SQLiteHelpers

        /**
         * The following flow will guide you through the implemented DBMS operations. Feel free to
         * run it to ensure everything works as intended. In that case, you will have to change the
         * <code>apply plugin: 'com.android.library'</code> line from build.gradle(app) to
         * <code>apply plugin: 'com.android.application'</code> and comment out the
         * <code>androidTestImplementation project(":app")</code> from build.gradle(DBMS-benchmark).
         */
        val db = helpers.buildDb(this)
        helpers.loadCities(this)
        val cities = helpers.getCities(50)

        Log.d("1. City #last - init load: ", cities[cities.size - 1].toString())

        helpers.deleteCities(db)
        helpers.insertCities(db, cities)
        val citiesFromDb = helpers.readCities(db)

        Log.d("2. City #last - DB: ", citiesFromDb[citiesFromDb.size - 1].toString())

        val citiesUpdated = cities.map { it.name = it.name + "_updated"; it }
        helpers.updateCities(db, citiesUpdated)
        val citiesFromDbUpdated = helpers.readCities(db)

        Log.d(
            "3. City #last - DB Updated: ",
            citiesFromDbUpdated[citiesFromDbUpdated.size - 1].toString()
        )

        helpers.deleteCities(db)
        val citiesAfterDeletion = helpers.readCities(db)

        Log.d("4. City #size - DB deletion: ", citiesAfterDeletion.size.toString())
    }

}
