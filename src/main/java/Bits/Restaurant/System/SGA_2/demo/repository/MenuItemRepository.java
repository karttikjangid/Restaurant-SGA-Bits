package Bits.Restaurant.System.SGA_2.demo.repository;

import Bits.Restaurant.System.SGA_2.demo.entity.MenuItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("select m.id as id, m.itemName as itemName, m.price as price, r.name as restaurantName from MenuItem m inner join m.restaurant r")
    List<MenuItemJoinView> findMenuItemJoinData();
}
