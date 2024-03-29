package shop.model;

import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.items = new ArrayList<>();
        this.status = OrderStatus.IN_PROGRESS;

    }

    public Account getAccount() {
        return account;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void applyDiscount(String code){
        discount=discountPolicy.getDiscount(code);
    }

    public void sendOrder(Address address){
        if(status.equals(OrderStatus.IN_PROGRESS)){
            this.address=address;
            this.status=OrderStatus.SENT;
        }
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : items){
            BigDecimal itemPrice = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total=total.add(itemPrice);

        }

        return total
                .subtract(total.multiply(BigDecimal.valueOf(discount)))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(order.discount, discount) == 0 &&
                Objects.equals(account, order.account) &&
                Objects.equals(discountPolicy, order.discountPolicy) &&
                Objects.equals(items, order.items) &&
                status == order.status &&
                Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, discountPolicy, items, status, address, discount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "account=" + account +
                ", discountPolicy=" + discountPolicy +
                ", items=" + items +
                ", status=" + status +
                ", address=" + address +
                ", discount=" + discount +
                '}';
    }
}
