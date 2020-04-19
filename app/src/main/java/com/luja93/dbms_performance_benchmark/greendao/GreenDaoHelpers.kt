package com.luja93.dbms_performance_benchmark.greendao

import android.content.Context
import com.luja93.dbms_performance_benchmark.BaseHelpers

/**
 * \brief Helper class for initializing, loading and performing GreenDao queries.
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
object GreenDaoHelpers : BaseHelpers<City_GreenDao, DaoSession>() {

    //region SETUP
    override fun buildDb(context: Context): DaoSession {
        val helper = GreenDaoOpenHelper(context)
        val db = helper.writableDb
        val daoMaster = DaoMaster(db)
        val daoSession = daoMaster.newSession()

        DaoMaster.createAllTables(daoMaster.database, true)

        return daoSession
    }

    override fun loadCities(context: Context) {
        loadCitiesData<List<City_GreenDao>>(context)
    }
    //endregion


    //region BENCHMARK HELPERS
    override fun insertCities(db: DaoSession, cities: List<City_GreenDao>) {
        db.city_GreenDaoDao.insertInTx(cities)
    }

    override fun readCities(db: DaoSession): List<City_GreenDao> {
        return db.city_GreenDaoDao.loadAll()
    }

    override fun updateCities(db: DaoSession, cities: List<City_GreenDao>) {
        db.city_GreenDaoDao.updateInTx(cities)
    }

    override fun deleteCities(db: DaoSession) {
        db.city_GreenDaoDao.deleteAll()
    }
    //endregion

}