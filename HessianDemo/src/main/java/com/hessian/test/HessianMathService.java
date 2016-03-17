package com.hessian.test;

import com.caucho.hessian.server.HessianServlet;

/**
 * Created by Cwind on 2016/3/17.
 */
public class HessianMathService extends HessianServlet implements MathService{
    public int add(int a, int b) {
        return a+b;
    }
}
