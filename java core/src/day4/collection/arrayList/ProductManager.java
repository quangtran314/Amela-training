package day4.collection.arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ProductManager{
    private ArrayList<Product> products;

    public ProductManager(){
        products = new ArrayList<>();
    }

    public boolean add(Product newProduct){
        products.add(newProduct);
        return true;
    }

    public Product getProduct(int id){
        Product result = null;
        for (Product product : products){
            if(product.getId() == id){
                result = product;
            }
        }
        return result;
    }

    public Product getProduct(String name){
        Product result = null;
        for (Product product : products){
            if(product.getName().equals(name)){
                result = product;
            }
        }
        return result;
    }

    public void setProduct(int id, String name, double price){
        Product product = getProduct(id);
        product.setName(name);
        product.setPrice(price);
    }

    public boolean remove(int id){
        Product product = getProduct(id);
        return products.remove(product);
    }

    public void printProducts(){
        for(Product product : products){
            System.out.println(product);
        }
    }

    public void sort(){
        Collections.sort(products);
        return;
    }
}
