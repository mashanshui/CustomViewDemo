package com.shanshui.customviewdemo;

import java.math.BigDecimal;

/**
 * @author mashanshui
 * @date 2020/1/2
 * @desc TODO
 */
public class Test {
    public static void main(String[] args) {
        float f = 2.1f;
        for (int j = 0; j < 10; j++) {
            BigDecimal b1 = new BigDecimal(Float.toString(f));
            BigDecimal b2 = new BigDecimal(Float.toString(0.1f));
            f = b1.add(b2).floatValue();
            System.out.println(f);
        }
    }
}
