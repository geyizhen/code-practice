//使用冒泡算法把最大的length-k的值移到最右侧，输出前K个值即可
//算法复杂度为O（n*k）还能优化，算法复杂度最优为O（n），还没太理解

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k == 0 || k > input.length)
            return ret;
        for (int i = 0; i < input.length - k; i++){
            for(int j = 0; j < input.length - 1 - i; j ++){
                if (input[j] >= input[j + 1]){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < k; i ++)
            ret.add(input[i]);
        return ret;
    }
}



public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
    if (k > nums.length || k <= 0)
        return new ArrayList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int num : nums) {
        maxHeap.add(num);
        if (maxHeap.size() > k)
            maxHeap.poll();
    }
    return new ArrayList<>(maxHeap);
}