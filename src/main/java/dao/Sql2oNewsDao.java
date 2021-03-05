package dao;

import models.News;
import org.sql2o.Sql2o;

public class Sql2oNewsDao
{
    public Sql2oNewsDao(Sql2o sql2o)
    {
    }

    public void add(News news)
    {
    }

    public Object getAll()
    {
        return 0;
    }

    public Object findById(int restaurantId)
    {
        return restaurantId;
    }
}
