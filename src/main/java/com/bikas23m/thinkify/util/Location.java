package com.bikas23m.thinkify.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;


@Getter
public class Location {

    private Double x;
    private Double y;

    public Location(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    public static Double findDistanceBetweenTwoPoints(Location l1, Location l2){
        Double delta_x = (Double) l2.getX()-l1.getX();
        Double delta_y = (Double) l2.getY()-l1.getY();

        Double diostance = Math.sqrt(delta_x*delta_x + delta_y*delta_y);

        return diostance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(x, location.x) && Objects.equals(y, location.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
