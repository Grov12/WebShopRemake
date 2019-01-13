package JavaClasses;

public class Product {
    
    private String name;
    private double price;
    //private int articleID;
    //private int quantity;
    
    
    public Product(String name, double price /*, int articleID*/){
        this.name = name;
        this.price = price;
        //this.articleID = articleID;
        //this.quantity = 1;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    /*
    public int getArticleID(){
        return articleID;
    }
    
    public void setArticleID(int articleID){
        this.articleID = articleID;
    }
    
    
    public void increaseQuantity(){
        this.quantity++;
    }
    
    public void decreaseQuantity(){
        this.quantity--;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    */
    
    @Override
    public String toString(){
        return "Product name: " + this.name + /*", article ID: " + this.articleID + */ ", cost: " + (/*this.quantity **/ this.price) + " SEK.";
    }
    
    
}
