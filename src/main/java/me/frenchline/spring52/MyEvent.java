package me.frenchline.spring52;

public class MyEvent {

    private int data;
    
    private Object source; //이벤트를 발생시킨 소스를 갖고 싶다면 이렇게 필드를 두면 된다
    
    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}
