package com.example.calculator;

public class Model {
    public long calculation(long a, long b,String operator){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "x":
                return a*b;
            case "/":
                if (b == 0) return 0;
                return a/b;
            case "c":
                return (a+b)*0;
        }
        System.out.println("Не коректная операция " + operator);
        return 0;
    }
}
