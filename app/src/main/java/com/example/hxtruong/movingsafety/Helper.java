package com.example.hxtruong.movingsafety;

import android.location.Address;

import java.io.Serializable;

public class Helper implements Serializable {
    private String name;
    private Address address;

    public Helper(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
