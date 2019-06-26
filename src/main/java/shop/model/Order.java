package shop.model;

import java.awt.event.ItemEvent;
import java.util.List;

public class Order {
    private final Account account;
    private final DiscountPolicy discountPolicy;
    private final List<Item> items;
    private OrderStatus status;
    private Address address;
    private float discount;

    public Order(Account account, DiscountPolicy discountPolicy) {
        this.account = account;
        this.discountPolicy = discountPolicy;
        this.items = items;
        this.status = status;

    }

    
}
