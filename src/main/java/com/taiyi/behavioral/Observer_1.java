package com.taiyi.behavioral;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 */
@Data
@AllArgsConstructor
class Child extends Observable {

    private String name;

    public void cry() {
        System.out.println("我哭了。。。");
        super.setChanged();
        super.notifyObservers();
    }
}

/**
 * 观察者
 */
@Data
@AllArgsConstructor
class Father implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + ":" + ((Child) o).getName() + "哭了，继续打游戏吧。");
    }
}

@Data
@AllArgsConstructor
class Mother implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + ":" + ((Child) o).getName() + "哭了，去冲个奶粉吧……");

    }
}

@Data
@AllArgsConstructor
class Pet implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + ":" + "汪汪汪……");

    }
}

public class Observer_1 {
    public static void main(String[] args) {

        Child baby = new Child("宝宝");

        Observer father = new Father("爸爸");
        Observer mother = new Mother("妈妈");
        Observer dog = new Pet("宠物狗");

        baby.addObserver(father);
        baby.addObserver(mother);
        baby.addObserver(dog);

        baby.cry();
    }
}
