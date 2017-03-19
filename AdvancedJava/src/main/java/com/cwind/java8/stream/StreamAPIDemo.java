package com.cwind.java8.stream;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stay hungry, stay foolish.
 * Author: Cwind
 * Date: 2017/3/19
 * Description:
 */
public class StreamAPIDemo {

    private List<Item> shoppingList;

    @Before
    public void setUp() throws Exception {
        shoppingList = Lists.newArrayList();
        shoppingList.add(new Item("iPhone 7", 7250L));
        shoppingList.add(new Item("Rolex Watch", 28888L));
        shoppingList.add(new Item("Electric Toothbrush", 388L));
        shoppingList.add(new Item("Kindle Paperwhite", 1098L));
        shoppingList.add(new Item("Coca Cola", 3L));
    }

    // 打印购物清单
    @Test
    public void printShoppingList() {
        shoppingList.stream().forEach(System.out::println);
    }

    // 统计购物清单总数与总价
    @Test
    public void printTotalPrice() {
        long itemNum = shoppingList.stream().count();
        System.out.println("Sum of items in the shopping list: " + itemNum);

        long totalPrice = shoppingList.stream().collect(Collectors.summingLong(Item::getPrice));
        System.out.println("Total price: " + totalPrice);
    }

    // 过滤价格小于1000的商品
    @Test
    public void filterItems(){
        shoppingList.stream().filter(p -> p.getPrice() >= 1000L).forEach(System.out::println);
    }

    // 按价格排序
    @Test
    public void sortItemsByPrice(){
        shoppingList.stream().sorted(Comparator.comparingLong(Item::getPrice)).forEach(System.out::println);
    }

    // 所有商品价格减100 - Map
    @Test
    public void streamMap(){
        shoppingList.stream().map(p -> new Item(p.getItemName(), p.getPrice()-100)).forEach(System.out::println);
    }

    // 取出如上优惠之后金额超过1000元的商品中，价格最低的商品（最便宜的奢侈品）
    @Test
    public void streamReduce(){
        Item cheapestLuxury = shoppingList.stream().map(p -> new Item(p.getItemName(), p.getPrice()-100))
            .filter(p -> p.getPrice() > 1000).reduce((a, b) -> a.getPrice()<b.getPrice()?a:b).get();
        System.out.println(cheapestLuxury);
    }

    class Item {
        String itemName;
        long price;

        public Item(String itemName, long price) {
            this.itemName = itemName;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemName='" + itemName + '\'' +
                    ", price=" + price +
                    '}';
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }
    }

}
