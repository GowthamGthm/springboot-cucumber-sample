package com.gthm.cucumber.model.onestream;


import lombok.Data;

@Data
public class Packet {


    String uuid;
    Event data;

}