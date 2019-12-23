package com.ayman.banzena.model.pojo;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ayman on 2019-05-15.
 */

public class BanzenaPojo implements Serializable {

    private Long id;
    private String banzenaName;
    private String banzenaOhda;
    private Double lng;
    private Double lat;
    private Double  banzenaOils;
    private Double banzenaTanks;

    public BanzenaPojo() {
    }

    public BanzenaPojo(Long id, String banzenaName, String banzenaOhda, Double banzenaOils, Double banzenaTanks  , Double lng, Double lat) {
        this.id = id;
        this.banzenaName = banzenaName;
        this.banzenaOhda = banzenaOhda;
        this.lng = lng;
        this.lat = lat;
        this.banzenaOils = banzenaOils;
        this.banzenaTanks = banzenaTanks;
    }

    public Long getId() {
        return id;
    }

    public String getBanzenaName() {
        return banzenaName;
    }

    public String getBanzenaOhda() {
        return banzenaOhda;
    }

    public Double getLng() {
        return lng;
    }

    public Double getLat() {
        return lat;
    }

    public Double getBanzenaOils() {
        return banzenaOils;
    }

    public Double getBanzenaTanks() {
        return banzenaTanks;
    }
}
