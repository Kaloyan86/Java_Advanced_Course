package WORKSHOP;

import java.io.Console;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.data[this.size++] = element;
    }

    private void resize() {

        this.capacity *= 2;
        int[] newData = new int[this.capacity];
        if (this.size >= 0) {
            System.arraycopy(this.data, 0, newData, 0, this.size);
        }
        this.data = newData;
    }

    public int get(int index) {
        validateIndex(index);
        return this.data[index];
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean contains(int element) {
        for (int datum : data) {
            if (datum == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    public int remove(int index) {
        this.validateIndex(index);
        int element = this.data[index];
        this.shiftLeft(index);
        this.size--;
        if (this.size <= this.capacity / 4) {
            this.shrink();
        }
        return element;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] newData = new int[this.capacity];
        if (this.size >= 0) {
            System.arraycopy(this.data, 0, newData, 0, this.size);
        }
        this.data = newData;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;
    }

    private void add(int index, int element) {
        this.validateIndex(index);

        if (this.size+1 >= this.capacity) {
            this.resize();
        }
        this.size++;
        this.shiftRight(index);
        this.data[index] = element;
    }

    private void shiftRight(int index) {

        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }
}
