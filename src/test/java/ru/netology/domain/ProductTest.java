package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductTest {
    Product product = new Product(0, "", 0);

    Product first = new Book(1, "Carrie", 1000, "King");
    Product second = new Book(2, "Бородино", 2000, "Лермонтов");
    Product third = new Book(3, "Евгений Онегин", 3000, "Пушкин");
    Product fourth = new Smartphone(4, "A35", 4000, "Siemens");
    Product fifth = new Smartphone(5, "C100", 5000, "Samsung");
    Product sixth = new Smartphone(6, "3310", 6000, "Nokia");

    @BeforeEach
    public void SetUp() {
        product.add(first);
        product.add(second);
        product.add(third);
        product.add(fourth);
        product.add(fifth);
        product.add(sixth);
    }

    @Test
    public void shouldUseSearchByBookName() {

        Product[] actual = product.searchBy("Евгений Онегин");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByBookAuthor() {

        Product[] actual = product.searchBy("King");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchBySmartphoneName() {

        Product[] actual = product.searchBy("C100");
        Product[] expected = new Product[]{fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchBySmartphoneManufacturer() {

        Product[] actual = product.searchBy("Nokia");
        Product[] expected = new Product[]{sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNonexistent() {

        Product[] actual = product.searchBy("Motorola");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}
