package models;


//Class Review is defined
public class Review
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
    private int restaurantId; //will be used to connect Restaurant to Review (one-to-many)

    public Review(String content, String writtenBy, int rating, int restaurantId) {
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