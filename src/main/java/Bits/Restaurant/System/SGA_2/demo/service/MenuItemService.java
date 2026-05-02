package Bits.Restaurant.System.SGA_2.demo.service;

import Bits.Restaurant.System.SGA_2.demo.entity.MenuItem;
import Bits.Restaurant.System.SGA_2.demo.entity.Restaurant;
import Bits.Restaurant.System.SGA_2.demo.repository.MenuItemJoinView;
import Bits.Restaurant.System.SGA_2.demo.repository.MenuItemRepository;
import Bits.Restaurant.System.SGA_2.demo.repository.RestaurantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuItem saveMenuItem(MenuItem item) {
        return menuItemRepository.save(item);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
        MenuItem existing = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        existing.setItemName(updatedItem.getItemName());
        existing.setPrice(updatedItem.getPrice());
        existing.setRestaurant(updatedItem.getRestaurant());
        return menuItemRepository.save(existing);
    }

    public List<Object[]> getMenuWithRestaurant() {
        List<MenuItemJoinView> rows = menuItemRepository.findMenuItemJoinData();
        return rows.stream()
                .map(row -> new Object[]{row.getItemName(), row.getPrice(), row.getRestaurantName()})
                .toList();
    }

    public MenuItem saveMenuItem(MenuItem menuItem, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException("Restaurant not found: " + restaurantId));
        menuItem.setRestaurant(restaurant);
        return menuItemRepository.save(menuItem);
    }

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Menu item not found: " + id));
    }

    public MenuItem updateMenuItem(MenuItem menuItem, Long restaurantId) {
        MenuItem existing = getMenuItemById(menuItem.getId());
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException("Restaurant not found: " + restaurantId));
        existing.setItemName(menuItem.getItemName());
        existing.setPrice(menuItem.getPrice());
        existing.setRestaurant(restaurant);
        return menuItemRepository.save(existing);
    }

    public List<MenuItemJoinView> getMenuItemJoinData() {
        return menuItemRepository.findMenuItemJoinData();
    }
}
