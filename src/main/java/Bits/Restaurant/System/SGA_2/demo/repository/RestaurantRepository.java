package Bits.Restaurant.System.SGA_2.demo.repository;

import Bits.Restaurant.System.SGA_2.demo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
