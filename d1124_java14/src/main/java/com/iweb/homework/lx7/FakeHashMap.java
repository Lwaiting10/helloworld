package com.iweb.homework.lx7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午11:05
 */
public class FakeHashMap<K, V> implements FakeMap<K, V> {
    private static int listSize = 1000;
    ArrayList<LinkedList<Entry<K, V>>> list = new ArrayList<>();
    private int count;

    public FakeHashMap() {
        for (int i = 0; i < listSize; i++) {
            list.add(null);
        }
        count = 0;
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode() % listSize;
        LinkedList<Entry<K, V>> linkedList = list.get(hashcode);
        if (linkedList == null) {
            list.set(hashcode, new LinkedList<>());
            Entry<K, V> entry = new Entry<>(key, value);
            list.get(hashcode).add(entry);
            count++;
            return value;
        }
        for (Entry<K, V> entry : linkedList) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return value;
            }
        }
        Entry<K, V> entry = new Entry<>(key, value);
        linkedList.add(entry);
        count++;
        return value;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        int hashcode = key.hashCode() % listSize;
        LinkedList<Entry<K, V>> linkedList = list.get(hashcode);
        if (linkedList == null) {
            return null;
        }
        for (Entry<K, V> entry : linkedList) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            return null;
        }
        int hashcode = key.hashCode() % listSize;
        LinkedList<Entry<K, V>> linkedList = list.get(hashcode);
        if (linkedList == null) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            if (key.equals(linkedList.get(i).getKey())) {
                V value = linkedList.get(i).getValue();
                linkedList.remove(linkedList.get(i));
                count--;
                return value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

}
