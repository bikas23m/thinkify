package com.bikas23m.thinkify.repository;

import com.bikas23m.thinkify.entity.Driver;
import com.bikas23m.thinkify.entity.User;
import com.bikas23m.thinkify.enums.Status;
import com.bikas23m.thinkify.util.Location;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Controller
public class DriverRepository {

    private final ConcurrentHashMap<String, Driver> drivers = new ConcurrentHashMap<>();

    public Driver addDriver(Driver driver) {
        drivers.put(driver.getName(), driver);
        return drivers.get(driver.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverRepository that = (DriverRepository) o;
        return Objects.equals(drivers, that.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drivers);
    }

    public Driver getDriver(String drivername) {
        return drivers.get(drivername);
    }

    public List<Driver> findRiderUnder5UnitDistance(Location userLocation){
        return drivers.entrySet().stream()
                .filter((driver)->{
                    Location driverLocation  = driver.getValue().getLocation();
                    boolean status = driver.getValue().getStatus() == Status.AVAILABLE;
                    return Location.findDistanceBetweenTwoPoints(userLocation, driverLocation) < (Double) 5.0
                            && status;
                })
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
