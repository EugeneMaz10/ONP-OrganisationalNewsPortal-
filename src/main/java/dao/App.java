package dao;//import google.gson.Gson
//import com.google.gson.Gson;
import com.google.gson.Gson;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentsDao foodtypeDao;
        Sql2oNewsDao restaurantDao;
        Sql2oUsersDao reviewDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        restaurantDao = new Sql2oNewsDao(sql2o);
        foodtypeDao = new Sql2oDepartmentsDao(sql2o);
        reviewDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();

        post("/restaurants/new", "application/json", (req, res) -> { //accept a request in format JSON
            News news = gson.fromJson(req.body(), News.class);//make with GSON
            restaurantDao.add(news);//Do our thing with our DAO
            res.status(201);//everything went well - update the response status code
            res.type("application/json");
            return gson.toJson(news);//send it back to be displayed
        });

        get("/restaurants", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(restaurantDao.getAll());//send it back to be displayed
        });

        get("/restaurants/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int restaurantId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(restaurantDao.findById(restaurantId));
        });
    }
}