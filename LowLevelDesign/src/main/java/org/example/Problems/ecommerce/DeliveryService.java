package org.example.Problems.ecommerce;

import java.util.List;

public class DeliveryService {
    List<DeliveryPerson> deliveryPersonList;

    public DeliveryService() {
    }

    public DeliveryPerson assignDeliveryPerson(String location)
    {
        return deliveryPersonList.get(0);
    }

    public void startDelivery(Order order)
    {

    }
    public void endDelivery(Order order)
    {

    }
    public void cancelDelivery(Order order)
    {

    }

    public void returnDelivery(Order order)
    {

    }

    public List<DeliveryPerson> getDeliveryPersonList() {
        return deliveryPersonList;
    }

    public void setDeliveryPersonList(List<DeliveryPerson> deliveryPersonList) {
        this.deliveryPersonList = deliveryPersonList;
    }
}
