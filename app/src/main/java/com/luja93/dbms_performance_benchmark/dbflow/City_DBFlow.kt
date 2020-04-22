package com.luja93.dbms_performance_benchmark.dbflow

import com.google.gson.annotations.SerializedName
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * \brief Model used as the data holder for objects saved/read from the database.
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
@Table(database = DBFlowDB::class, name = "CityDBFlowTable")
data class City_DBFlow(
    @PrimaryKey
    @SerializedName("id")
    var id: Long = 0L,
    @Column
    @SerializedName("uid")
    var uid: Long = 0L,
    @Column
    @SerializedName("lat")
    var lat: Float = 0f,
    @Column
    @SerializedName("lon")
    var lon: Float = 0f,
    @Column
    @SerializedName("name")
    var name: String = "",
    @Column
    @SerializedName("place")
    var place: String = ""
) : BaseModel()