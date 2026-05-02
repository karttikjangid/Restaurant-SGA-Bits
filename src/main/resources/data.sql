INSERT IGNORE INTO restaurant (id, name, location) VALUES
(1, 'Spice Hub', 'Downtown'),
(2, 'Green Garden', 'Uptown'),
(3, 'Ocean Bites', 'Seaside'),
(4, 'Urban Grill', 'Midtown'),
(5, 'Casa Fiesta', 'Old Town');

INSERT IGNORE INTO menu_item (id, item_name, price, restaurant_id) VALUES
(1, 'Chicken Biryani', 12.99, 1),
(2, 'Paneer Tikka', 9.49, 1),
(3, 'Avocado Salad', 8.25, 2),
(4, 'Veggie Bowl', 10.50, 2),
(5, 'Grilled Salmon', 16.75, 3),
(6, 'Shrimp Tacos', 13.40, 3),
(7, 'BBQ Burger', 11.30, 4),
(8, 'Smoked Ribs', 18.90, 4),
(9, 'Beef Enchiladas', 12.60, 5),
(10, 'Churros', 5.80, 5);
