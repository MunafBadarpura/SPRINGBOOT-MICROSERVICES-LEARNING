package com.munaf.HotelService.services;

import com.munaf.HotelService.enitites.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel createHotel(Hotel hotel);

    public Hotel getHotelById(Long hotelId);

    public List<Hotel> getAllHotels();

    public String deleteHotel(Long hotelId);


}
