package Bits.Restaurant.System.SGA_2.demo.service;

import Bits.Restaurant.System.SGA_2.demo.entity.Restaurant;
import Bits.Restaurant.System.SGA_2.demo.repository.RestaurantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant not found: " + id));
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {
        Restaurant existing = getRestaurantById(restaurant.getId());
        existing.setName(restaurant.getName());
        existing.setLocation(restaurant.getLocation());
        return restaurantRepository.save(existing);
    }
}
