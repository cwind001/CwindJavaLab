package ch5.rmi;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */
public class Customer implements Serializable {

    private int age;
    private int sex;
    private String[] hobbies;

    public Customer(int age, int sex, String[] hobbies) {
        this.age = age;
        this.sex = sex;
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                ", sex=" + sex +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public boolean hasHobby(String aHobby){
        if(aHobby == ""){
            return true;
        }
        for (String hobby : hobbies){
            if(aHobby.equals(hobby)){
                return true;
            }
        }
        return false;
    }

    public void reset(){
        age = 0;
        sex = 0;
        hobbies = null;
    }
}
