package org.example.Problems.AmazonLocker;

/**
 * Represents a delivery person responsible for delivering and collecting locker items.
 */
public class DeliveryPerson {
    private final int id;
    private String name;
    private String contact;

    public DeliveryPerson(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
