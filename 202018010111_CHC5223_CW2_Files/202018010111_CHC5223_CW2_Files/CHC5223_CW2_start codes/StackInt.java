package CHC5223;

public class StackInt extends AbsStackInt {

    public StackInt(int capacity) {
        super(capacity);
    }

    @Override
    public void push(int n) {
        assert this.size != this.capacity : "Stack is full, cannot push";

        this.stack[this.size] = n;
        this.size++;
    }

    @Override
    public int pop() {
        assert this.size != 0 : "Stack is empty, cannot pop";

        int poppedValue = this.stack[this.size - 1];
        this.size--;
        return poppedValue;
    }

    @Override
    public int peek() {
        assert this.size != 0 : "Stack is empty, cannot peek";

        return this.stack[this.size - 1];
    }
}
