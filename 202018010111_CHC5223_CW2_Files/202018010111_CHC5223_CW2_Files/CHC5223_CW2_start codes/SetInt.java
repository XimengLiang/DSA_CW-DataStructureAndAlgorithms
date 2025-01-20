package CHC5223;

public class SetInt extends AbsSetInt {

    public SetInt(int capacity) {
        super(capacity);
    }

    @Override
    public boolean contains(int x) {
        for (int i = 0; i < this.size; i++) {
            if (this.set[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void include(int n) {
        assert contains(n) || getSize() != getCapacity() : "Set is full or element already exists";

        if (!contains(n)) {
            this.set[this.size] = n;
            this.size++;
        }

        assert contains(n) : "Element was not included in the set";
    }

    @Override
    public void exclude(int n) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.set[i] == n) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < this.size - 1; i++) {
                this.set[i] = this.set[i+1];
            }
            this.size--;
        }

        assert !contains(n) : "Element was not removed from the set";
    }
}
