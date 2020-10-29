package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();

    Product first = new Book(1, "Carrie", 1000, "King");
    Product second = new Book(2, "Бородино", 2000, "Лермонтов");
    Product third = new Book(3, "Евгений Онегин", 3000, "Пушкин");
    Product fourth = new Smartphone(4, "A35", 4000, "Siemens");
    Product fifth = new Smartphone(5, "C100", 5000, "Samsung");
    Product sixth = new Smartphone(6, "3310", 6000, "Nokia");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldUseSearchByBookName() {

        Product[] actual = manager.searchBy("Carrie");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByBookAuthor() {

        Product[] actual = manager.searchBy("Пушкин");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchBySmartphoneName() {

        Product[] actual = manager.searchBy("A35");
        Product[] expected = new Product[]{fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchBySmartphoneManufacturer() {

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNonexistent() {

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}
