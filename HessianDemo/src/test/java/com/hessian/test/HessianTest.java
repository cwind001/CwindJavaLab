package com.hessian.test;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Created by Cwind on 2016/3/17.
 */
public class HessianTest {
    public static void main(String[] args){
        String url = "http://localhost:8080/demo/hessian/math";
        HessianProxyFactory factory = new HessianProxyFactory();
        MathService mathService = null;
        try {
            mathService = (MathService) factory.create(MathService.class, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("3 + 2 = " + mathService.add(3,2));
    }
}
