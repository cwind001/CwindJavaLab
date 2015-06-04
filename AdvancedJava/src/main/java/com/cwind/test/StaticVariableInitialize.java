package com.cwind.test;

class Person {  
    
    public static int count1;  
    public static int count2 = 5;  
      
    private static Person person = new Person();  
      
    private Person() {  
        count1++;  
        count2++;  
    }  
      
    public static Person getInstance()  
    {  
        return person;  
    }  
      
}  
  
public class StaticVariableInitialize {  
    public static void main(String[] args) {  
  
        Person person=Person.getInstance();  
          
        //可以用直接Person.count1  
        System.out.println("count1: "+person.count1);  
      
        System.out.println("count2: "+person.count2);  
    }  
  
}  