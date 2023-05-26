package com.taiyi.behavioral;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 观察者抽象
 */
interface EventListener {
}

@Data
class Event {
    // 事件源，动作是由谁发动的
    private Object source;
    // 事件触发，要通知谁（观察者）
    private EventListener target;
    // 观察者给的回应
    private Method callback;
    //事件的名称
    private String trigger;
    //事件的触发事件
    private long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

}

/**
 * 被观察者的抽象
 */
class EventContext {
    protected Map<String, Event> events = new HashMap<String, Event>();

    public void addListener(String eventType, EventListener target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    public void addListener(String eventType, EventListener target) {

        try {
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            return;
        }

    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            if (event.getCallback() != null) {
                // 用反射调用回调函数
                event.getCallback().invoke(event.getTarget(), event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 事件触发
    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            return;
        }
        trigger(this.events.get(trigger));
    }
}


interface MouseEventType {
    String ON_CLICK = "click";
    String ON_MOVE = "move";
}

/**
 * 具体的被观察者
 */
class Mouse extends EventContext {
    public void click() {
        System.out.println("调用点击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void move() {
        System.out.println("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }
}

/**
 * 观察者
 */
class MouseEventListener implements EventListener {
    public void onClick(Event e) {
        System.out.println("===============触发 click 事件=============\n" + e);
    }

    public void onMove(Event e) {
        System.out.println("===============触发 move 事件=============\n" + e);
    }
}

public class Observer {
    public static void main(String[] args) {
        MouseEventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();
    }
}
