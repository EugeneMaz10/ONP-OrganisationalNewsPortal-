package dao;

import models.Departments;

import java.util.List;

public interface DepartmentsDao
{

    //create
    void add(Departments departments);
    //void addFoodtypeToRestaurant(Departments foodtype, News restaurant);

    //read
    List<Departments> getAll();
    // List<News> getAllRestaurantsForAFoodtype(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}