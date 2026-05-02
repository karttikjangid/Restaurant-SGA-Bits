package Bits.Restaurant.System.SGA_2.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Bits.Restaurant.System.SGA_2.demo.entity.MenuItem;
import Bits.Restaurant.System.SGA_2.demo.repository.MenuItemRepository;
import Bits.Restaurant.System.SGA_2.demo.repository.RestaurantRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MenuItemServiceTest {

    @Mock
    private MenuItemRepository menuItemRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private MenuItemService menuItemService;

    @Test
    void saveMenuItem() {
        MenuItem input = new MenuItem();
        input.setItemName("Test Item");
        input.setPrice(9.99);

        MenuItem saved = new MenuItem();
        saved.setId(1L);
        saved.setItemName("Test Item");
        saved.setPrice(9.99);
        when(menuItemRepository.save(any(MenuItem.class))).thenReturn(saved);

        MenuItem result = menuItemService.saveMenuItem(input);

        assertEquals(1L, result.getId());
        assertEquals("Test Item", result.getItemName());
        verify(menuItemRepository).save(any(MenuItem.class));
    }

    @Test
    void getAllMenuItems() {
        when(menuItemRepository.findAll()).thenReturn(List.of(new MenuItem(), new MenuItem()));

        List<MenuItem> results = menuItemService.getAllMenuItems();

        assertEquals(2, results.size());
    }
}
