package com.luja93.dbms_benchmark

import android.content.Context
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.core.app.ApplicationProvider
import com.luja93.dbms_performance_benchmark.BaseHelpers
import org.junit.Rule

/**
 * \brief Base benchmark class, each individual benchmark should extend to ensure benchmark
 * standardization.
 * \details
 *
 * @author  Luka Leopoldović
 * @version 1.0
 * \date 19/04/2020
 * \copyright
 *     This code and information is provided "as is" without warranty of
 *     any kind, either expressed or implied, including but not limited to
 *     the implied warranties of merchantability and/or fitness for a
 *     particular purpose.
 */
abstract class BaseBenchmark<City, Database, DBHelper : BaseHelpers<City, Database>> {

    //region SETUP
    /**
     * Call this function from @Before annotated function to load the cities and setup the database.
     *
     * @param take Number of cities to load.
     * @param dbInit Lambda for database initialization.
     */
    protected fun initialize(take: Int, dbInit: () -> Unit) {
        helpers.loadCities(context)

        dbInit()

        if (cities.isEmpty())
            cities = helpers.getCities(take)
    }
    //endregion


    //region BENCHMARK
    /**
     * Call this function for benchmarking insert operation.
     *
     * @param db [Database] instance.
     */
    protected fun insert(db: Database) {
        benchmarkRule.measureRepeated {
            runWithTimingDisabled {
                helpers.deleteCities(db)
            }

            helpers.insertCities(db, cities)
        }
    }

    /**
     * Call this function for benchmarking read operation.
     *
     * @param db [Database] instance.
     */
    protected fun read(db: Database) {
        helpers.deleteCities(db)
        helpers.insertCities(db, cities)

        benchmarkRule.measureRepeated {
            helpers.readCities(db)
        }
    }

    /**
     * Call this function for benchmarking update operation.
     *
     * @param db [Database] instance.
     * @param cityUpdate Lambda for providing the list of updated [City].
     */
    protected fun update(db: Database, cityUpdate: (cities: List<City>) -> List<City>) {
        val citiesUpdated = cityUpdate(cities)

        benchmarkRule.measureRepeated {
            runWithTimingDisabled {
                helpers.deleteCities(db)
                helpers.insertCities(db, cities)
            }

            helpers.updateCities(db, citiesUpdated)
        }
    }

    /**
     * Call this function for benchmarking delete operation.
     *
     * @param db [Database] instance.
     */
    protected fun delete(db: Database) {
        benchmarkRule.measureRepeated {
            runWithTimingDisabled {
                helpers.deleteCities(db)
                helpers.insertCities(db, cities)
            }

            helpers.deleteCities(db)
        }
    }
    //endregion


    //region ABSTRACT VALs
    /**
     * The rule used for benchmarking. Must be public.
     */
    @get:Rule
    abstract val benchmarkRule: BenchmarkRule

    /**
     * [Context], usually obtained via [ApplicationProvider].
     */
    protected abstract val context: Context

    /**
     * The list of cities used for benchmarking.
     */
    protected abstract var cities: List<City>

    /**
     * DatabaseHelper object of [BaseHelpers] type, used for performing database operations.
     */
    protected abstract val helpers: DBHelper
    //endregion
}