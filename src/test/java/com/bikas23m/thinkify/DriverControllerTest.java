package com.bikas23m.thinkify;

import com.bikas23m.thinkify.controller.DriverController;
import com.bikas23m.thinkify.controller.UserController;
import com.bikas23m.thinkify.dtos.request.BookRideDto;
import com.bikas23m.thinkify.dtos.request.DriverDto;
import com.bikas23m.thinkify.dtos.request.RideRequestDto;
import com.bikas23m.thinkify.entity.Driver;
import com.bikas23m.thinkify.entity.User;
import com.bikas23m.thinkify.enums.Status;
import com.bikas23m.thinkify.service.DriverService;
import com.bikas23m.thinkify.service.UserService;
import com.bikas23m.thinkify.transformers.DriverTransformer;
import com.bikas23m.thinkify.util.Location;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DriverControllerTest {
    @InjectMocks
    private DriverController driverController;

    @Mock
    private DriverService driverService;

    @Test
    public void addDriver_validDriver_returnsCreatedDriver() {
        // Create a valid User object
        DriverDto driverDto = new DriverDto("Driver1", 'M', 22,"Swift, KA-01-12345", new Location(10.0,1.0));

        Driver driver = DriverTransformer.convertDtoToEntity(driverDto);

        // Mock UserService behavior
        Mockito.when(driverService.addDriver(driver)).thenReturn(driver);

        // Call the controller method
        ResponseEntity<Driver> response = driverController.addDriver(driverDto);

        // Verify response and service call
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody())
                .isEqualTo(driver);
        Mockito.verify(driverService).addDriver(driver);
    }

    @Test
    public void findRidersUnder5UnitDistance_validRequestDto_returnsListOfDriverNames() {
        RideRequestDto rideRequestDto = new RideRequestDto();
        Mockito.when(driverService.findRidersUnder5UnitDistance(rideRequestDto)).thenReturn(new ArrayList<>(List.of("Driver1")));
        ResponseEntity<List<String>> response = driverController.findRidersUnder5UnitDistance(rideRequestDto);
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().size())
                .isGreaterThan(0);
        Mockito.verify(driverService).findRidersUnder5UnitDistance(rideRequestDto);
    }

    @Test
    public void bookDriver_validDriverName_returnsSuccessMessage(){
        BookRideDto bookRideDto = new BookRideDto("Abhishek","Driver1");
        Mockito.when(driverService.bookRide(bookRideDto)).thenReturn("ride booked successfully with driver : "+bookRideDto.getDriverName());
        ResponseEntity<String> response = driverController.bookRide(bookRideDto);
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().length())
                .isGreaterThan(0);
        Mockito.verify(driverService).bookRide(bookRideDto);
    }

}
