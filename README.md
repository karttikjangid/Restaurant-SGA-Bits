# Food Delivery Management System

## Project Overview
Food Delivery Management System is a simple Spring Boot web app for managing menu items and their restaurants. It lets you add menu items, view them in a list, update existing items, and see joined menu/restaurant data.

## Features
- Add menu item
- View menu items
- Update menu items
- View joined data of menu items and restaurants

## Project Structure
- entity: JPA entities such as Restaurant and MenuItem
- repository: Spring Data JPA repositories for database access
- service: Business logic and data operations
- controller: Web controllers for handling requests

## How to Run
1. Clone the repository.
2. Open the project in your IDE.
3. Configure MySQL and create a database.
4. Update the database settings in `application.yaml`.
5. Run the application.

## Database Configuration
Update these values in `application.yaml` (do not commit real credentials):
- username
- password
- database name

## Endpoints
- /menu
- /add
- /menu-join

## Screenshots
Add screenshots here.
