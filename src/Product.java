import java.io.Serializable;
import java.util.Date;

public  class Product implements Serializable {

    private static final long serialVersionUID = 1L;


    private final String id;
    private String brand;
    private String model;
    private String countryProduction;
    private int productionDate;
    private int price;
//    private int quantity;
    private String category;
    private String description;
    private Date addedDate;
    private double rating;
    private int warrantyMoths;

    public Product(String id, String brand, String model, String countryProduction,
                   int productionDate, int price, String category,String description, int warrantyMoths)
    {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.countryProduction = countryProduction;
        this.productionDate = productionDate;
        this.price = price;
//        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.addedDate = new Date();
        this.rating = 0.0;
        this.warrantyMoths = warrantyMoths;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getCountryProduction() {
        return countryProduction;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public int getPrice() {
        return price;
    }

//    public int getQuantity() {
//        return quantity;
//    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public double getRating() {
        return rating;
    }

    public int getWarrantyMoths() {
        return warrantyMoths;
    }

    public String getFullName() {
        return brand + model;
    }





    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountryProduction(String countryProduction) {
        this.countryProduction = countryProduction;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setWarrantyMoths(int warrantyMoths) {
        this.warrantyMoths = warrantyMoths;
    }

}
