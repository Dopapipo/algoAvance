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
    public void add(T e) {
        this.ensureCapacity();
        this.t[this.index++] = e;
    }
    public T get(int i) {
        return (T) this.t[i];
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.index; i++) {
            sb.append(this.t[i].toString() +", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();

    }

}