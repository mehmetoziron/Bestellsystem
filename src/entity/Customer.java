package entity;

public class Customer {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private TYPE type;

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public enum TYPE {
        PERSON,
        COMPANY
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
     

    @Override
    public String toString() {
        return "Customer{" + "\nid=" + id
                + ",\n name=" + name
                + ",\n phone=" + phone
                + ",\n email=" + email
                + ",\n address=" + address
                + "\n}";
    }

}
