package com.bikas23m.thinkify.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRideDto {
    private String userName;
    private String driverName;
}
