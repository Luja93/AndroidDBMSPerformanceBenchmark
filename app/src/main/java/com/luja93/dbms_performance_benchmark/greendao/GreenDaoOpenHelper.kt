package com.luja93.dbms_performance_benchmark.greendao

import android.content.Context
import org.greenrobot.greendao.database.DatabaseOpenHelper

/**
 * \brief Open helper use to create GreenDao database.
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
class GreenDaoOpenHelper(context: Context) : DatabaseOpenHelper(context, NAME, VERSION) {

    companion object {
        private const val NAME = "GreenDaoDB"
        private const val VERSION = 1
    }

}