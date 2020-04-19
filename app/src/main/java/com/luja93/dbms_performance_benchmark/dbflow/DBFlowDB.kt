package com.luja93.dbms_performance_benchmark.dbflow

import com.raizlabs.android.dbflow.annotation.Database

/**
 * \brief Base DBFlow database class.
 * \details
 *
 * @author  Luka Leopoldović
 * @version 1.0
 * \date 04/04/2020
 * \copyright
 *     This code and information is provided "as is" without warranty of
 *     any kind, either expressed or implied, including but not limited to
 *     the implied warranties of merchantability and/or fitness for a
 *     particular purpose.
 */
@Database(name = DBFlowDB.NAME, version = DBFlowDB.VERSION)
object DBFlowDB {
    const val NAME = "DBFlowDB"
    const val VERSION = 1
}