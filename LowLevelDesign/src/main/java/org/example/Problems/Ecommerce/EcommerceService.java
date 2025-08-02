package org.example.Problems.Ecommerce;

import java.util.List;
import java.util.stream.Collectors;

public class EcommerceService {
    private final Inventory inventory;
    private final DeliveryService deliveryService;
    private final PaymentService paymentService;
    private final CouponService couponService;
    private final NotificationService notificationService;

    public EcommerceService(List<Product> products) {
        this.inventory = new Inventory(products);
        this.deliveryService = new DeliveryService();
        this.paymentService = new PaymentService();
        this.couponService = new CouponService();
        this.notificationService = new NotificationService();
    }

    public List<Product> searchProduct(String productName) {
        System.out.println("Searching for product......");
        return inventory.getProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .collect(Collectors.toList());
    }

    public Cart createCart() {
        return new Cart();
    }

    public void addProductToCart(Cart cart, Product product, int quantity) {
        cart.addProductsToCart(product, quantity);
    }

    public Order checkoutCart(User user, Cart cart) {
        // Here you could apply coupons, calculate final price, etc.
        Order order = new Order(user, cart.getProducts());
        return order;
    }

    public Order placeOrder(Order order) {
        System.out.println("User paying for the order");
        boolean paymentSuccess = paymentService.processPayment(order);

        if (!paymentSuccess) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            notificationService.notifyUser(order.getUser(), "Payment failed. Order cancelled.");
            return order;
        }

        System.out.println("User marking payment as paid");
        order.setPaymentStatus(PaymentStatus.PAID);
        order.setOrderStatus(OrderStatus.COMPLETED);

        System.out.println("Assigning delivery person and notifying user");
        DeliveryPerson deliveryPerson = deliveryService.assignDeliveryPerson();
        // Ideally you would store DeliveryPerson info in Order or DeliveryInfo
        // For now, just notify
        notificationService.notifyUser(order.getUser(), "Order placed successfully. Delivery assigned to " + deliveryPerson.getName());

        return order;
    }

    public void cancelOrder(Order order) {
        order.setOrderStatus(OrderStatus.CANCELLED);
        paymentService.refund(order);
        notificationService.notifyUser(order.getUser(), "Order has been cancelled.");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public DeliveryService getDeliveryService() {
        return deliveryService;
    }
}
