package ru.netology.domain;

public class Product {
  private Product[] items = new Product[0];

  private int id;
  private String name;
  private int price;

  public Product(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

//  public int getId() {
//    return id;
//  }

  public String getName() {
    return name;
  }

  public void add(Product item) {
    int length = items.length + 1;
    Product[] tmp = new Product[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Product[] searchBy(String text) {
    Product[] result = new Product[0];
    for (Product product: findAll()) {
      if (product.matches(text)) {
        Product[] tmp = new Product[result.length + 1];
        System.arraycopy(result, 0, tmp, 0, result.length);
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }
  public boolean matches(String search) {

    return (getName().equalsIgnoreCase(search));
  }

  public Product[] findAll() {
    return items;
  }
}
