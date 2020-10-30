package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTestEmptyAndOneElement {
    ProductManager manager = new ProductManager();

    @Test
    public void shouldArrayEmpty() {

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldArrayOneElement() {

        Product first = new Book(1, "Carrie", 1000, "King");
        manager.add(first);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }
}
