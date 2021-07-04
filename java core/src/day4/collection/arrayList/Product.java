package day4.collection.arrayList;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product name: "
               + this.name
               + ", id: "
               + this.id
               + ", price: "
               + this.price;
    }

    @Override
    public int compareTo(Product other) {
        if (this.price > other.getPrice()){
            return 1;
        } else if (this.price < other.price){
            return -1;
        } else {
            return 0;
        }
    }
}
