package dao;

import models.Users;

import java.util.List;

public interface ReviewDao {

    //create
    void add(Users users);

    //read
    List<Users> getAll();
    List<Users> getAllReviewsByRestaurant(int restaurantId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}