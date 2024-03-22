package com.bikas23m.thinkify.service;

import com.bikas23m.thinkify.dtos.request.BookRideDto;
import com.bikas23m.thinkify.dtos.request.RideRequestDto;
import com.bikas23m.thinkify.entity.Driver;
import com.bikas23m.thinkify.enums.Status;
import com.bikas23m.thinkify.exception.DriverIsNotAvailableException;
import com.bikas23m.thinkify.exception.DriverNotFoundUnder5UnitDistanceException;
import com.bikas23m.thinkify.exception.UserNotFoundException;
import com.bikas23m.thinkify.repository.DriverRepository;
import com.bikas23m.thinkify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final UserRepository userRepository;

    public DriverService(DriverRepository driverRepository, UserRepository userRepository){
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
    }

    public Driver addDriver(Driver driver) {

            return driverRepository.addDriver(driver);

    }

    public String bookRide(BookRideDto bookRideDto){

        String driverName = bookRideDto.getDriverName();

        String user = bookRideDto.getUserName();

        if(userRepository.getUser(user) == null){
            throw new UserNotFoundException("Cant find user with name "+user);
        }

        if(driverRepository.getDriver(driverName).getStatus() != Status.AVAILABLE){
            throw new DriverIsNotAvailableException("Driver is set to not available");
        }
        driverRepository.getDriver(driverName).setStatus(Status.NOTAVAILABLE);
        return "ride booked successfully with driver : "+driverName;
    }

    public List<String> findRidersUnder5UnitDistance(RideRequestDto rideRequestDto){

        if(userRepository.getUser(rideRequestDto.getName()) == null){
            throw  new UserNotFoundException("cant find user :"+rideRequestDto.getName());
        }

        List<Driver> nearByDriversList = driverRepository.findRiderUnder5UnitDistance(rideRequestDto.getSource());

        if(nearByDriversList == null){
            throw new DriverNotFoundUnder5UnitDistanceException("Can't find any driver for your location");
        }

        List<String> nearByDriversNameList =
                new ArrayList<>();
        for (Driver driver : nearByDriversList) {
            String name = driver.getName();
            nearByDriversNameList.add(name);
        }

        return nearByDriversNameList;

    }

}
