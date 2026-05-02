package Bits.Restaurant.System.SGA_2.demo.controller;

import Bits.Restaurant.System.SGA_2.demo.entity.MenuItem;
import Bits.Restaurant.System.SGA_2.demo.service.MenuItemService;
import Bits.Restaurant.System.SGA_2.demo.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuItemController {

    private final MenuItemService menuItemService;
    private final RestaurantService restaurantService;

    public MenuItemController(MenuItemService menuItemService, RestaurantService restaurantService) {
        this.menuItemService = menuItemService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/menu")
    public String listMenuItems(Model model) {
        model.addAttribute("menuItems", menuItemService.getAllMenuItems());
        return "menu-list";
    }

    @GetMapping("/menu-join")
    public String listMenuJoinData(Model model) {
        model.addAttribute("menuData", menuItemService.getMenuWithRestaurant());
        return "menu-join";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "menu-form";
    }

    @PostMapping("/save")
    public String saveMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.saveMenuItem(menuItem);
        return "redirect:/menu";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("menuItem", menuItemService.getMenuItemById(id));
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "menu-form";
    }

    @PostMapping("/update")
    public String updateMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.updateMenuItem(menuItem.getId(), menuItem);
        return "redirect:/menu";
    }
}
