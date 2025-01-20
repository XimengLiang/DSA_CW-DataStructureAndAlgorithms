package CHC5223;

public class ListInt extends AbsListInt {
    public ListInt(int capacity){
        super(capacity);
    }

    @Override
    public void append(int n) {
        assert this.size != this.capacity : "List is full, cannot append value";
        this.list[this.size++] = n;
    }

    @Override
    public boolean contains(int x) {
        for(int i = 0; i < size; i++) {
            if(this.list[i] == x) {
                return true;
            }
        }


        return false;
    }
}

