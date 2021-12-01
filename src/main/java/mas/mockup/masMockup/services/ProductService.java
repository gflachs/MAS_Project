package mas.mockup.masMockup.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.web.database.product.Product;

@Service
public class ProductService {
    
    private Set<Product> products;

    public ProductService(){
        products = new HashSet<>();
    }

    public Set<Product> getProducts(){
        return this.products;
    }

    public void createExampleProducts(){
        products.clear();
        Product p = new Product(1, "Das beste Olivenöl", 15.40f, "https://cdn.pixabay.com/photo/2015/10/02/15/59/olive-oil-968657_960_720.jpg");
        Product p1 = new Product(2, "Fleisch vom Lamm", 18.50f, "https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994_960_720.jpg");

        products.add(p);
        products.add(p1);
        
    }
}
