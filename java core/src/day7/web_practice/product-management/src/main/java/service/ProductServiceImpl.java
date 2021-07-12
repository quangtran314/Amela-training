package service;

import model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService{

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Laptop", 124, "This's description"));
        products.put(2, new Product(2, "Phone", 100, "This's description"));
        products.put(3, new Product(3, "Table", 50, "This's description"));
        products.put(4, new Product(4, "Television", 123.5, "This's description"));
        products.put(5, new Product(5, "Book", 2, "This's description"));
        products.put(6, new Product(6, "Pen", 5, "This's description"));
    }
    
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public ArrayList<Product> findByName(String name){
        ArrayList<Product> result = new ArrayList<>();
        Iterator  it = products.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry) it.next();
            Product product = (Product)(mapElement.getValue());
            if(name.equals(product.getName())){
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
