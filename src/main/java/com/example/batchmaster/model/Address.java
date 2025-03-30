package com.example.batchmaster.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    // Fields
    private String street;
    private String city;
    private String district;
    private String state;
    private String postalCode;

}