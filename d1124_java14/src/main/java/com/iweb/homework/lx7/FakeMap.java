package com.iweb.homework.lx7;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午11:01
 */
public interface FakeMap<K, V> {
    V put(K key, V value);

    V get(Object key);

    V remove(Object key);

    int size();

}
