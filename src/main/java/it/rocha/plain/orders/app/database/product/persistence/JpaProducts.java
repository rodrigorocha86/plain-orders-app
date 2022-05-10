package it.rocha.plain.orders.app.database.product.persistence;

import it.rocha.plain.orders.domain.product.Product;
import it.rocha.plain.orders.domain.product.Products;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JpaProducts
        implements Products {

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Set<Product> all() {
        return null;
    }
}