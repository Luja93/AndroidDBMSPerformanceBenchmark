package com.luja93.dbms_performance_benchmark.realm

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * \brief Model used as the data holder for objects saved/read from the database.
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
open class City_Realm : RealmObject {

    @PrimaryKey
    @SerializedName("id")
    var id: Long = 0L
    @SerializedName("uid")
    var uid: Long = 0L
    @SerializedName("lat")
    var lat: Float = 0f
    @SerializedName("lon")
    var lon: Float = 0f
    @SerializedName("name")
    var name: String = ""
    @SerializedName("place")
    var place: String = ""

    constructor()

    constructor(id: Long, uid: Long, lat: Float, lon: Float, name: String, place: String) {
        this.id = id
        this.uid = uid
        this.lat = lat
        this.lon = lon
        this.name = name
        this.place = place
    }

}