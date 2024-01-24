public class ArrayListe<T> {
    private Object[] t;
    private int index;

    public ArrayListe() {
        this.t = new Object[8];
        this.index = 0;

    }

    private void ensureCapacity() {
        if (this.index < this.t.length) {
            return;
        }
        Object[] tmp = new Object[this.t.length * 2];
        for (int i = 0; i < this.t.length; i++) {
            tmp[i] = this.t[i];
        }
        this.t = tmp;
    }

    public boolean add(T e) {
        this.ensureCapacity();
        this.t[this.index++] = e;
        return true;
    }

    public T get(int i) {
        return (T) this.t[i];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.index; i++) {
            sb.append(this.t[i].toString() + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();

    }

    void add(int indice, T e) {
        this.ensureCapacity();
        for (int i = this.index; i > indice; i--) {
            this.t[i] = this.t[i - 1];
        }
        this.t[indice] = e;
        this.index++;
    }
    boolean contains(T e) {
        for (int i = 0; i<this.index;i++) {
            if (this.t[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    void ensureCapacity(int minCapacity) {
        if (minCapacity < this.t.length) {
            return;
        }
        Object[] tmp = new Object[minCapacity];
        for (int i = 0; i < this.t.length; i++) {
            tmp[i] = this.t[i];
        }
        this.t = tmp;
    }
    int indexOf(T e) {
        for (int i = 0; i<this.index;i++) {
            if (this.t[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    boolean isEmpty() {
        return this.index == 0;
    }
    T remove (int indice) {
        T tmp = (T) this.t[indice];
        for (int i = indice; i<this.index-1;i++) {
            this.t[i] = this.t[i+1];
        }
        this.index--;
        return tmp;
    }
    
}
