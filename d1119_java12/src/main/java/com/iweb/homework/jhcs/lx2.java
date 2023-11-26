package com.iweb.homework.jhcs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午3:46
 */
public class lx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int n = scanner.nextInt();
        int[] abilities = new int[n];
        for (int i = 0; i < n; i++) {
            abilities[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int d = scanner.nextInt();

        // 计算最大乘积
        long[][] dpMax = new long[k][n];
        long[][] dpMin = new long[k][n];

        // 初始化k=1的情况
        for (int i = 0; i < n; i++) {
            dpMax[0][i] = abilities[i];
            dpMin[0][i] = abilities[i];
        }

        // 计算dpMax和dpMin
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 1; x <= d && j - x >= 0; x++) {
                    dpMax[i][j] = Math.max(dpMax[i][j], Math.max(dpMax[i - 1][j - x] * abilities[j], dpMin[i - 1][j - x] * abilities[j]));
                    dpMin[i][j] = Math.min(dpMin[i][j], Math.min(dpMax[i - 1][j - x] * abilities[j], dpMin[i - 1][j - x] * abilities[j]));
                }
            }
        }

        // 找出最后一行中的最大值
        long result = Long.MIN_VALUE;
        for (int i = k - 1; i < n; i++) {
            result = Math.max(result, dpMax[k - 1][i]);
        }

        System.out.println(result);
    }
}
