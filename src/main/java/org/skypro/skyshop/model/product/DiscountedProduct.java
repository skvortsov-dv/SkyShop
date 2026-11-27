package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public int getDiscount() {
        return discount;
    }

    public DiscountedProduct(UUID id, String name, int price, int discount) {
        super(id, name);

        if (price <= 0) {
            throw new IllegalArgumentException("Некорректная цена");
        }

        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Некорректная скидка");
        }

        this.price = price;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "(" + getDiscount() + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof DiscountedProduct that)) return false;
//        if (!super.equals(o)) return false;
//        return price == that.price && discount == that.discount;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), price, discount);
//    }
}
