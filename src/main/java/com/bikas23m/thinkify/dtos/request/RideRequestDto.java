package com.bikas23m.thinkify.dtos.request;

import com.bikas23m.thinkify.util.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
    private String name;
    private Location source;
    private Location destination;
}
