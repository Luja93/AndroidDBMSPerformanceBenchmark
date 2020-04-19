package com.luja93.dbms_performance_benchmark.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.luja93.dbms_performance_benchmark.sqlite.CityReaderContract.CityEntry

/**
 * \brief Base SQLite database class.
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
class CityReaderDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_NAME = "SQLiteDB.db"
        const val DATABASE_VERSION = 1
    }


    private object Queries {
        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS ${CityEntry.TABLE_NAME} (" +
                    "${CityEntry.COLUMN_NAME_ID} INTEGER PRIMARY KEY, " +
                    "${CityEntry.COLUMN_NAME_UID} INTEGER, " +
                    "${CityEntry.COLUMN_NAME_LAT} REAL, " +
                    "${CityEntry.COLUMN_NAME_LON} REAL, " +
                    "${CityEntry.COLUMN_NAME_NAME} TEXT, " +
                    "${CityEntry.COLUMN_NAME_PLACE} TEXT)"

        const val SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS ${CityEntry.TABLE_NAME}"
    }


    //region SQLITE OPEN HELPER IMPLEMENTATIONS
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Queries.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for benchmark data, so its upgrade policy is
        // simply to discard the data and start over.
        db?.execSQL(Queries.SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    //endregion
}