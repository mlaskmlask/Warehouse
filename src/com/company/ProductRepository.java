package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();
    private static final ProductRepository productRepository = new ProductRepository();

    private ProductRepository() {
        products.add(new Clothes(38, "dress", "red", 5, "short"));
        products.add(new Clothes(40, "skirt", "blue", 10, "long"));
        products.add(new Jewellery(18, "necklace with ruby", "gold", 6, "necklaces"));
        products.add(new Jewellery(18, "ring with diamond", "gold", 6, "rings"));
    }

    public static ProductRepository getInstance() {
        return productRepository;
    }

    public List<Product> getAllProducts() {
        return this.products;
    }

    public boolean deliverProduct(String productName, int pieces) {
        for (Product currentProduct : this.products) {
            if (currentProduct.getName().equals(productName) && currentProduct.getPieces() >= pieces) {
                    currentProduct.setPieces(currentProduct.getPieces() - pieces);
                    return true;
                }
            }
        return false;
    }

    public Product findProduct (String productName){
        for(Product currentProduct : this.products){
            if(currentProduct.getName().equals(productName)){
                return currentProduct;
            }
        }
        return null;
    }

    public void addProductToDatabase(Product product){
        this.products.add(product);

    }
}
