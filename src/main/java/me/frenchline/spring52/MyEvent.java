package me.frenchline.spring52;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent { //Spring 4.2 이전에는 항상 ApplicationEvent이란 추상 클래스를 상속받아야 했다

    private int data;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, int data) {
        super(source);
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
