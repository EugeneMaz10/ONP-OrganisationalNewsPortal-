package dao;

import models.News;

import java.util.List;

public interface NewsDao
{

    //create
    void add (News news);
    // void addRestaurantToFoodType(News restaurant, Departments foodtype)

    //read
    List<News> getAll();
    News findById(int id);
    // List<Departments> getAllFoodtypesForARestaurant(int restaurantId);

    //update
    void update(int id, String name, String address, String zipcode, String phone, String website, String email);

    //delete
    void deleteById(int id);
    void clearAll();
}