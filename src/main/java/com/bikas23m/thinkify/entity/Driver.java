package com.bikas23m.thinkify.entity;

import com.bikas23m.thinkify.enums.Status;
import com.bikas23m.thinkify.util.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {

    private String name;
    private Character gender;
    private Integer age;
    private String vehicle;
    private Location location;
    private Status status;

}
