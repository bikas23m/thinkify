package com.bikas23m.thinkify.controller;

import com.bikas23m.thinkify.dtos.request.DriverDto;
import com.bikas23m.thinkify.dtos.request.BookRideDto;
import com.bikas23m.thinkify.dtos.request.RideRequestDto;
import com.bikas23m.thinkify.entity.Driver;
import com.bikas23m.thinkify.service.DriverService;
import com.bikas23m.thinkify.transformers.DriverTransformer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping("/create")
    public ResponseEntity<Driver> addDriver(@RequestBody DriverDto driverDto){
        Driver driver = DriverTransformer.convertDtoToEntity(driverDto);

        return ResponseEntity.ok(driverService.addDriver(driver));
    }
    @GetMapping("/findride")
    public ResponseEntity<List<String>> findRidersUnder5UnitDistance(@RequestBody RideRequestDto rideRequestDto){
        return ResponseEntity.ok(driverService.findRidersUnder5UnitDistance(rideRequestDto));
    }
    @PatchMapping("/bookride")
    public ResponseEntity<String> bookRide(@RequestBody BookRideDto bookRideDto){
        return ResponseEntity.ok(driverService.bookRide(bookRideDto));
    }
}
