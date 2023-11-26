package com.iweb.homework.lx7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午11:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry<K,V>{
    private K key;
    private V value;
}
