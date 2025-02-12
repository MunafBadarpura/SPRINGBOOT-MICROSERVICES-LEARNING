package com.munaf.HotelService.services.impl;

import com.munaf.HotelService.enitites.Hotel;
import com.munaf.HotelService.exeptions.ResourceAlreadyExistsException;
import com.munaf.HotelService.exeptions.ResourceNotFoundException;
import com.munaf.HotelService.repositories.HotelRepository;
import com.munaf.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceIMPL implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


    @Override
    public String deleteHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));

        hotelRepository.delete(hotel);
        return "Hotel with id " + hotelId + " has been deleted successfully.";
    }

}
