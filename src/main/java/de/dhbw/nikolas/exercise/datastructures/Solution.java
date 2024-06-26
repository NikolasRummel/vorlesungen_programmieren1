package de.dhbw.nikolas.exercise.datastructures;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        AtomicInteger r = new AtomicInteger(Integer.MAX_VALUE);
        map.forEach((k, v) -> {
            if (v == 1) {
                r.set(k);
            }
        });

        return r.get();
    }
}