package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService () {
        products = new HashMap<>();
        articles = new HashMap<>();

        init();
    }

    private void init () {
        Product product1 = new SimpleProduct(UUID.randomUUID(), "Стол", 2000);
        Product product2 = new SimpleProduct(UUID.randomUUID(),"Стул", 1000);
        Product product3 = new DiscountedProduct(UUID.randomUUID(),"Хлеб", 50, 20);
        Product product4 = new DiscountedProduct(UUID.randomUUID(),"Молоко", 100, 0);
        Product product5 = new FixPriceProduct(UUID.randomUUID(),"Лицензия");

        products.put(product1.getId(),product1);
        products.put(product2.getId(),product2);
        products.put(product3.getId(),product3);
        products.put(product4.getId(),product4);
        products.put(product5.getId(),product5);

    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection <Searchable> getAllSearchables () {
        Collection <Searchable> searchables = new ArrayList<>();

        searchables.addAll(getAllProducts());
        searchables.addAll(getAllArticles());

        return searchables;
    }
}
