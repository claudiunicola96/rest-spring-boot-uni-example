package com.mpp.race.model;

import java.io.Serializable;

/**
 * Created by claudiu on 5/30/2017.
 */
public class Race implements Serializable {
    private int id;
    private String name;
    private int capacity;
    private int countParticipants;

    public Race() {
    }

    public Race(int id, String name, int capacity, int countParticipants) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.countParticipants = countParticipants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCountParticipants() {
        return countParticipants;
    }

    public void setCountParticipants(int countParticipants) {
        this.countParticipants = countParticipants;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", countParticipants=" + countParticipants +
                '}';
    }
}
