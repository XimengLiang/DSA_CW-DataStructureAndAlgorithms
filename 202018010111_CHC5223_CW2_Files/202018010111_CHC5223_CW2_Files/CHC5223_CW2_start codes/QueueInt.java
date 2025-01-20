package CHC5223;

public class QueueInt extends AbsQueueInt {

    public QueueInt(int capacity) {
        super(capacity);
    }

    @Override
    public void addToBack(int n) {
        assert getSize() < getCapacity() : " Queue is full, cannot add to back";


        this.queue[this.size] = n;
        this.size++;
        assert this.queue[this.size - 1] == n : "n is not at the back of the queue";
    }

    @Override
    public int removeFromFront() {

        assert getSize() > 0 : "Queue is empty, cannot remove from front";
        int frontElement = this.queue[0];
        System.arraycopy(this.queue, 1, this.queue, 0, this.size - 1);
        this.size--;
        assert !this.contains(frontElement) : "Post-condition violation: Removed element is still in the queue";

        return frontElement;
    }

    private boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.queue[i] == element) {
                return true;
            }
        }
        return false;
    }

}
