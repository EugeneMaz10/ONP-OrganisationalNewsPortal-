package models;

public class Restaurant
{
    private String name;
    private String address;
    private String zipcode;
    private String phone;
    private String website;
    private String email;
    private int id;


    public Restaurant(String name, String address, String zipcode, String phone) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = "no website listed";
        this.email = "no email available";
    }
}