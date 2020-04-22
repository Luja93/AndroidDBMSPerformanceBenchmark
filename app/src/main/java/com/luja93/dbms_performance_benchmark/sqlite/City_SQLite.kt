package com.luja93.dbms_performance_benchmark.sqlite

import com.google.gson.annotations.SerializedName

/**
 * \brief Model used as the data holder for objects saved/read from the database.
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
data class City_SQLite(
    @SerializedName("id")
    val id: Long,
    @SerializedName("uid")
    var uid: Long,
    @SerializedName("lat")
    var lat: Float,
    @SerializedName("lon")
    var lon: Float,
    @SerializedName("name")
    var name: String,
    @SerializedName("place")
    var place: String
)