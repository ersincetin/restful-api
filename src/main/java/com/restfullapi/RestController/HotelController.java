package com.restfullapi.RestController;

import com.restfullapi.Business.HotelManager;
import com.restfullapi.Entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class HotelController {

    private HotelManager hotelManager;

    @Autowired
    public HotelController(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    @RequestMapping(value = "/hotels")
    public List<Hotel> getHotels() {
        return this.hotelManager.getAll();
    }
}
