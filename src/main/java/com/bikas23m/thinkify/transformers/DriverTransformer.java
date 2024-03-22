package com.bikas23m.thinkify.transformers;

import com.bikas23m.thinkify.dtos.request.DriverDto;
import com.bikas23m.thinkify.entity.Driver;
import com.bikas23m.thinkify.enums.Status;

public class DriverTransformer {
    public static Driver convertDtoToEntity(DriverDto driverDto){
        return Driver.builder()
                .name(driverDto.getName())
                .gender(driverDto.getGender())
                .age(driverDto.getAge())
                .vehicle(driverDto.getVehicle())
                .location(driverDto.getLocation())
                .status(Status.AVAILABLE)
                .build();
    }
}
