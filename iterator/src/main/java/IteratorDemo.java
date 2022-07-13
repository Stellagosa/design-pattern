public class IteratorDemo {
}

interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}

interface Aggregate {
    void add(Object object);
    void remove(Object object);
    Iterator getIterator();
}

class ConcreteIterator implements Iterator {

    @Override
    public Object first() {
        return null;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}

class ConcreteAggregate implements Aggregate {

    @Override
    public void add(Object object) {

    }

    @Override
    public void remove(Object object) {

    }

    @Override
    public Iterator getIterator() {
        return null;
    }
}















