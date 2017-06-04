package com.mpp.race.repository;

import com.mpp.race.model.Race;

import java.util.ArrayList;

/**
 * Created by claudiu on 5/30/2017.
 */
public interface IRaceRepository {
    void save(Race race);
    void delete(int id);
    void update(int id, Race race);
    Race findOne(Integer integer);
    ArrayList<Race> findAll();
}
