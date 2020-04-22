package com.luja93.dbms_performance_benchmark.greendao;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * \brief Model used as the data holder for objects saved/read from the database.
 * \details Must be defined as Java class.
 *
 * @author Luka Leopoldović
 * @version 1.0
 * \date 13/04/2020
 * \copyright
 * This code and information is provided "as is" without warranty of
 * any kind, either expressed or implied, including but not limited to
 * the implied warranties of merchantability and/or fitness for a
 * particular purpose.
 */
@Entity
public class City_GreenDao {

    @Id
    @SerializedName("id")
    private long id;
    @SerializedName("uid")
    private long uid;
    @SerializedName("lat")
    private float lat;
    @SerializedName("lon")
    private float lon;
    @SerializedName("name")
    private String name;
    @SerializedName("place")
    private String place;

    @Generated(hash = 2037213612)
    public City_GreenDao(long id, long uid, float lat, float lon, String name, String place) {
        this.id = id;
        this.uid = uid;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.place = place;
    }

    @Generated(hash = 750110077)
    public City_GreenDao() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLat() {
        return lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLon() {
        return lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }
}
