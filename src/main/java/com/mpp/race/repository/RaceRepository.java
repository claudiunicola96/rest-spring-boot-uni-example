package com.mpp.race.repository;

import com.mpp.race.model.Race;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by claudiu on 5/30/2017.
 */
@Component
public class RaceRepository implements IRaceRepository {
    private  ArrayList<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
        // populate with dummy data
        Race race = new Race(1,"Cursa 1",125,2 );
        save(race);
        race = new Race(2,"Cursa 2",225,2 );
        save(race);
    }

    @Override
    public void save(Race race) {
        races.add(race);
    }

    @Override
    public void delete(int id) {
        for(Race r : races) {
            if (r.getId() == id) {
                races.remove(r);
                return;
            }
        }
    }

    @Override
    public void update(int id, Race race) {
        delete(id);
        save(race);
    }

    @Override
    public Race findOne(Integer integer) {
        for(Race r : races) {
            if (r.getId() == integer) {
                return r;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Race> findAll() {
        return  races;
    }
}
