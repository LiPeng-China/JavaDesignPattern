package com.taiyi.creational;

// 抽象产品和抽象工厂类
abstract class Product {
    public abstract void show();
}

abstract class Factory {
    public abstract Product manuFacture();
}

// 具体产品
class ProductA extends Product {
    @Override
    public void show() {
        System.out.println("产品 A ...");
    }
}

class ProductB extends Product {

    @Override
    public void show() {
        System.out.println("产品 B ...");
    }
}

// 具体工厂
class FactoryA extends Factory {

    @Override
    public Product manuFacture() {
        return new ProductA();
    }
}

class FactoryB extends Factory {

    @Override
    public Product manuFacture() {
        return new ProductB();
    }
}


public class FactoryMethod {
    public static void main(String[] args) {
        new FactoryA().manuFacture().show();
        new FactoryB().manuFacture().show();
    }

}
