package com.munaf.HotelService.enitites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hotel_name")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

}
