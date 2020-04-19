package com.luja93.dbms_performance_benchmark.dbflow

import android.content.Context
import com.luja93.dbms_performance_benchmark.BaseHelpers
import com.raizlabs.android.dbflow.config.DatabaseDefinition
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.Delete
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction

/**
 * \brief Helper class for initializing, loading and performing DBFlow queries.
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
object DBFlowHelpers : BaseHelpers<City_DBFlow, DatabaseDefinition>() {

    //region SETUP
    override fun buildDb(context: Context): DatabaseDefinition {
        FlowManager.init(context)

        return FlowManager.getDatabase(DBFlowDB.NAME)
    }

    override fun loadCities(context: Context) {
        loadCitiesData<List<City_DBFlow>>(context)
    }
    //endregion


    //region BENCHMARK HELPERS
    override fun insertCities(db: DatabaseDefinition, cities: List<City_DBFlow>) {
        db.executeTransaction(
            FastStoreModelTransaction
                .insertBuilder(FlowManager.getModelAdapter(City_DBFlow::class.java))
                .addAll(cities)
                .build()
        )
    }

    override fun readCities(db: DatabaseDefinition): List<City_DBFlow> {
        return SQLite.select().from(City_DBFlow::class.java).queryList()
    }

    override fun updateCities(db: DatabaseDefinition, cities: List<City_DBFlow>) {
        db.executeTransaction(
            FastStoreModelTransaction
                .updateBuilder(FlowManager.getModelAdapter(City_DBFlow::class.java))
                .addAll(cities)
                .build()
        )
    }

    override fun deleteCities(db: DatabaseDefinition) {
        Delete.table(City_DBFlow::class.java)
    }
    //endregion
}