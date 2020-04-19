package com.luja93.dbms_performance_benchmark.sqlite

import android.content.Context
import com.luja93.dbms_performance_benchmark.BaseHelpers
import com.luja93.dbms_performance_benchmark.sqlite.CityReaderContract.CityEntry

/**
 * \brief Helper class for initializing, loading and performing SQLite queries.
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
object SQLiteHelpers : BaseHelpers<City_SQLite, CityReaderDbHelper>() {

    //region SETUP
    override fun buildDb(context: Context): CityReaderDbHelper {
        return CityReaderDbHelper(context)
    }

    override fun loadCities(context: Context) {
        loadCitiesData<List<City_SQLite>>(context)
    }
    //endregion


    //region BENCHMARK HELPERS
    override fun insertCities(db: CityReaderDbHelper, cities: List<City_SQLite>) {
        val database = db.writableDatabase

        val query = "INSERT INTO " + CityEntry.TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?)"
        val statement = database.compileStatement(query)

        database.beginTransaction()

        for (city in cities) {
            statement.clearBindings()

            statement.bindLong(1, city.id)
            statement.bindLong(2, city.uid)
            statement.bindDouble(3, city.lat.toDouble())
            statement.bindDouble(4, city.lon.toDouble())
            statement.bindString(5, city.name)
            statement.bindString(6, city.place)

            statement.executeInsert()
        }

        database.setTransactionSuccessful()
        database.endTransaction()
        database.close()
    }

    override fun readCities(db: CityReaderDbHelper): List<City_SQLite> {
        val cities = ArrayList<City_SQLite>()

        val database = db.readableDatabase
        val cursor = database.rawQuery("SELECT * FROM " + CityEntry.TABLE_NAME, null)

        cursor.moveToPosition(-1)
        while (cursor.moveToNext()) {
            val city = City_SQLite(
                id = cursor.getLong(0),
                uid = cursor.getLong(1),
                lat = cursor.getFloat(2),
                lon = cursor.getFloat(3),
                name = cursor.getString(4),
                place = cursor.getString(5)
            )
            cities.add(city)
        }

        cursor.close()
        database.close()

        return cities
    }

    override fun updateCities(db: CityReaderDbHelper, cities: List<City_SQLite>) {
        val database = db.writableDatabase

        val query = "UPDATE " + CityEntry.TABLE_NAME + " SET " +
                CityEntry.COLUMN_NAME_NAME + "=" + "? WHERE " + CityEntry.COLUMN_NAME_ID +
                "= ?"
        val statement = database.compileStatement(query)

        database.beginTransaction()

        for (city in cities) {
            statement.clearBindings()

            statement.bindString(1, city.name)
            statement.bindLong(2, city.id)

            statement.executeUpdateDelete()
        }

        database.setTransactionSuccessful()
        database.endTransaction()
        database.close()
    }

    override fun deleteCities(db: CityReaderDbHelper) {
        val database = db.writableDatabase

        database.delete(CityEntry.TABLE_NAME, null, null)

        database.close()
    }
    //endregion
}