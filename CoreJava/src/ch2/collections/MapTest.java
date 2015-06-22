package ch2.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/21
 * Email: billchen01@163.com
 */
public class MapTest {

    public static void main(String[] args){
        Map<String, Employee> staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry hacker"));
        staff.put("157-62-7935", new Employee("Gary Copper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // print all entries
        System.out.println(staff);

        // remove an entry
        staff.remove("567-24-2546");

        staff.put("456-62-5527", new Employee("Francesca Miller"));
        System.out.println(staff.get("157-62-7935"));

        for(Map.Entry<String, Employee> entry : staff.entrySet()){
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key="+key+", value="+value);
        }
    }
}

class Employee{
    private String name;
    private double salary;

    public Employee(String name) {
        this.name = name;
        this.salary = 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
