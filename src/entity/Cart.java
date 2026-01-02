package entity;

import java.time.LocalDate;

public class Cart {

    private int id;
    private int customerId;
    private int productId;
    private int price;
    private int quantity;
    private String note;
    private LocalDate date;
    private Customer customer;
    private Product product;

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{"
                + "\nid=" + id
                + ", \ncustomerId=" + customerId
                + ", \nproductId=" + productId
                + ", \nprice=" + price
                + ", \nquantity=" + quantity
                + ", \nnote=" + note
                + ", \ndate=" + date
                + ", \ncustomer=" + customer
                + ", \nproduct=" + product
                + "\n}";
    }

}
