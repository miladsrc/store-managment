package model;


public class Brand {

    private int id;
    private String name;
    private String website;
    private String description;

    //constructor

    public Brand() {
    }

    public Brand(int id, String name, String website, String description) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.description = description;
    }

    public Brand(String name, String website, String description) {
        this.name = name;
        this.website = website;
        this.description = description;
    }


    //get and set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    //method


    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
