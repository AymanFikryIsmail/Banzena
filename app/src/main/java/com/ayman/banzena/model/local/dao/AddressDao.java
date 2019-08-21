package com.ayman.banzena.model.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ayman.banzena.model.pojo.BanzenaPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayman on 2019-02-18.
 */

@Dao
public interface AddressDao {
    @Insert
    long addAddress(BanzenaPojo tripDTO);
    @Query("SELECT * FROM address  ")//
    List<BanzenaPojo> getAllAddresses();

    @Update
    int updateTrip(BanzenaPojo address);

    @Insert
    void insertAll(ArrayList<BanzenaPojo> addressDTOArrayList);

    @Delete
    void delete(BanzenaPojo address);

}
