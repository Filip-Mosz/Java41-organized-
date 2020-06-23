package pl.FilipM.May23;

public class Stack {
    private static final int MAX_HEIGHT = 10;

    private int[] stack;
    private int height;

    public Stack() {
        this.stack = new int[MAX_HEIGHT];
        this.height = 0;
    }

    public void push(int value){
        if (height < MAX_HEIGHT){
            stack[height++] = value;
        }
    }

    public int peek(){
        if (height > 0){
            return stack[height-1];
        }
        return Integer.MAX_VALUE;
    }

    public int pop(){
        if (height > 0){
            int value = stack[height - 1];
            height--;
            return value;
        }
        return Integer.MIN_VALUE;
    }
}
