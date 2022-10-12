package com.restfullapi.RestController;

import com.restfullapi.Business.HotelManager;
import com.restfullapi.Entities.Hotel;
import com.restfullapi.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Hotel> getAllHotels() {
        return this.hotelManager.getAll();
    }

    @RequestMapping(value = "/hotel/create")
    public void create(@RequestBody User user) {
        this.hotelManager.create(user);
    }

    @RequestMapping(value = "/hotel/{id}")
    public Object getByHotel(@PathVariable int id) {
        return this.hotelManager.getById(id);
    }

    @RequestMapping(value = "/hotel/update")
    public void update(@RequestBody User user) {
        this.hotelManager.update(user);
    }

    @RequestMapping(value = "/hotel/delete")
    public void delete(@RequestBody int id) {
        this.hotelManager.delete(id);
    }
}
