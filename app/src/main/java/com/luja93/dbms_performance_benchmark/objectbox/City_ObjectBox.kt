package com.luja93.dbms_performance_benchmark.objectbox

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * \brief Model used as the data holder for objects saved/read from the database.
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
@Entity
data class City_ObjectBox(
    @Id(assignable = true)
    @SerializedName("id")
    var id: Long = 0L,
    @SerializedName("uid")
    var uid: Long = 0L,
    @SerializedName("lat")
    var lat: Float = 0f,
    @SerializedName("lon")
    var lon: Float = 0f,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("place")
    var place: String = ""
)