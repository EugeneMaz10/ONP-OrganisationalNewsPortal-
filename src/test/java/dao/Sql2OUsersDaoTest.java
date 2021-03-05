//import the data access object dao
package dao;
//import models package which contains Java Class News
import models.News;
//import models package which contains Users Class
import models.Users;
//import the org.junit Test After Class.The After class is used package Annotating a public static void method with
// @AfterClass causes that method to be run after all the tests in the class have been run.
import org.junit.After;
//If you allocate expensive external resources in a BeforeClass method you need to release them after all the tests in the class have run
import org.junit.Before;
//imports all the libraries to be used for testing in sql2oReviewDaoTest.
import org.junit.Test;
//import Connection class.This will ensure that the program is
// able to access the database
import org.sql2o.Connection;
//
import org.sql2o.Sql2o;
//
import static org.junit.Assert.*;
//

//


public class Sql2OUsersDaoTest {
    private Connection conn;
    private Sql2oUsersDao reviewDao;
    private Sql2oNewsDao restaurantDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        reviewDao = new Sql2oUsersDao(sql2o);
        restaurantDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingReviewSetsId() throws Exception {
        Users testUsers = setupReview();
        assertEquals(1, testUsers.getId());
    }

    @Test
    public void getAll() throws Exception {
        Users users1 = setupReview();
        Users users2 = setupReview();
        assertEquals(2, reviewDao.getAll().size());
    }

    @Test
    public void getAllReviewsByRestaurant() throws Exception {
        News testNews = setupRestaurant();
        News otherNews = setupRestaurant(); //add in some extra data to see if it interferes
        Users users1 = setupReviewForRestaurant(testNews);
        Users users2 = setupReviewForRestaurant(testNews);
        Users usersForOtherRestaurant = setupReviewForRestaurant(otherNews);
        assertEquals(2, reviewDao.getAllReviewsByRestaurant(testNews.getId()).size());
    }

    @Test
    public void deleteById() throws Exception {
        Users testUsers = setupReview();
        Users otherUsers = setupReview();
        assertEquals(2, reviewDao.getAll().size());
        reviewDao.deleteById(testUsers.getId());
        assertEquals(1, reviewDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Users testUsers = setupReview();
        Users otherUsers = setupReview();
        reviewDao.clearAll();
        assertEquals(0, reviewDao.getAll().size());
    }

    //helpers

    public Users setupReview() {
        Users users = new Users("great", "Kim", 4, 555);
        reviewDao.add(users);
        return users;
    }

    public Users setupReviewForRestaurant(News news) {
        Users users = new Users("great", "Kim", 4, news.getId());
        reviewDao.add(users);
        return users;
    }

    public News setupRestaurant() {
        News news = new News("Fish Witch", "214 NE Broadway", "97232", "503-402-9874", "http://fishwitch.com", "hellofishy@fishwitch.com");
        restaurantDao.add(news);
        return news;
    }
}