package ch2.collections;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/21
 * Email: billchen01@163.com
 */
public class TreeSetTest {

    public static void main(String[] args){
        SortedSet<Item> parts = new TreeSet<Item>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String descA = o1.getDescription();
                String descB = o2.getDescription();
                return descA.compareTo(descB);
            }
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }

}

class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNumber != item.partNumber) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + partNumber;
        return result;
    }

    @Override
    public int compareTo(Item o) {
        return partNumber - o.partNumber;
    }

}