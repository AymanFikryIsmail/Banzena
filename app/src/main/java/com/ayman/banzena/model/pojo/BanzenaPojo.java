package com.ayman.banzena.model.pojo;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ayman on 2019-05-15.
 */

@Entity(tableName = "address")
public class BanzenaPojo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "regionName")
    private String regionName;
    @ColumnInfo(name = "addressDesc")
    private String addressDesc;
    @ColumnInfo(name = "lng")
    private Double lng;
    @ColumnInfo(name = "lat")
    private Double lat;
    public BanzenaPojo() {
    }

    @Ignore
    public BanzenaPojo(String regionName, String addressDesc, Double lng, Double lat) {
        this.regionName = regionName;
        this.addressDesc = addressDesc;
        this.lng = lng;
        this.lat = lat;
    }

    public int getId() {
        return id;
    }

    public Double getLng() {
        return lng;
    }

    public Double getLat() {
        return lat;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getAddressDesc() {
        return addressDesc;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
