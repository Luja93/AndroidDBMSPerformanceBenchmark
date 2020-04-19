package com.luja93.dbms_performance_benchmark.objectbox

import android.content.Context
import io.objectbox.BoxStore

/**
 * \brief Core initializer of the ObjectBox database.
 * \details
 *
 * @author  Luka Leopoldović
 * @version 1.0
 * \date 14/04/2020
 * \copyright
 *     This code and information is provided "as is" without warranty of
 *     any kind, either expressed or implied, including but not limited to
 *     the implied warranties of merchantability and/or fitness for a
 *     particular purpose.
 */
object ObjectBoxDB {

    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }
}