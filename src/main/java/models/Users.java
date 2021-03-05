package models;


//Class Users is defined
public class Users
{
    //Private String content
    private String content;
    //Private String writtenBy
    private String writtenBy;
    //Private int rating
    private int rating;
    //Private integer id is now defined here
    private int id;
    //
    private int restaurantId; //will be used to connect News to Users (one-to-many)

    public Users(String content, String writtenBy, int rating, int restaurantId) {
        this.content = content;
        this.writtenBy = writtenBy;
        this.rating = rating;
        this.restaurantId = restaurantId;
    }

    public void setId(int id)
    {
    }

    public int getId()
    {
    }
}