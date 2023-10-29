package edu.homeworks.hw_3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

public final class BackwardIterator<T> implements Iterator<T> {

    private final List<T> list;
    private int cursor;

    public BackwardIterator(@NotNull List<T> list) {
        this.list = list;
        cursor = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return cursor > -1;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (cursor < 0) {
            throw new NoSuchElementException();
        }
        return list.get(cursor--);
    }
}
