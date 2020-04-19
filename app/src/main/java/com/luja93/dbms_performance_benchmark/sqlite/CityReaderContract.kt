package com.luja93.dbms_performance_benchmark.sqlite

import android.provider.BaseColumns

/**
 * \brief Column definitions related to saving/reading [City_SQLite] from the database.
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
object CityReaderContract {

    // Table contents are grouped together in an anonymous object.
    object CityEntry : BaseColumns {
        const val TABLE_NAME = "City_SQlite"

        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_UID = "uid"
        const val COLUMN_NAME_LAT = "lat"
        const val COLUMN_NAME_LON = "lon"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_PLACE = "place"
    }

}