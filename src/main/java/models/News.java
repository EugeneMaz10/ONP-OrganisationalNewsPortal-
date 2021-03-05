package models;

public class News
{
    private String name;
    private String address;
    private String zipcode;
    private String phone;
    private String website;
    private String email;
    private int id;


    public News(String name, String address, String zipcode, String phone)
    {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = "no website listed";
        this.email = "no email available";
    }

    public News(String fish_witch, String s, String s1, String s2, String s3, String s4)
    {
    }

    public int getId()
    {
    }
}