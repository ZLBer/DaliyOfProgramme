package guava;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImmutableCollectionTest {
    public static void main(String[] args) {
                /*
2. 不可变集合ImmutableCollection
         */
        ImmutableSet<Integer> integerImmutableSet=ImmutableSet.of(1,2,3);
        integerImmutableSet.iterator();
    }


    //简易的装饰器
    class AddLoggingList<E> extends ForwardingList<E> {
        final List<E> delegate=new ArrayList<>(); // backing list
        @Override protected List<E> delegate() {
            return delegate;
        }
        @Override public void add(int index, E elem) {
            super.add(index, elem);
        }
        @Override public boolean add(E elem) {
            return standardAdd(elem); // 用add(int, E)实现
        }
        @Override public boolean addAll(Collection<? extends E> c) {
            return standardAddAll(c); // 用add实现
        }
    }
}
