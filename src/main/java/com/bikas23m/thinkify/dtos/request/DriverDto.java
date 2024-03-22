package com.bikas23m.thinkify.dtos.request;

import com.bikas23m.thinkify.util.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private String name;
    private Character gender;
    private Integer age;
    private String vehicle;
    private Location location;
}
