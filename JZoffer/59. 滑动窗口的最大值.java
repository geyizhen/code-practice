/*
建造一个大顶堆
*/
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size <= 0 || num.length < 0)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //建造一个大顶堆来保存滑动窗口的三个值,
        //如果没有后面的（o1, o2）-> o2 - o1,则为小顶堆
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++){//维护一个大小为size的大顶堆
            heap.remove(num[i]); //删掉第i个值
            heap.add(num[j]);    //增加第j个值
            ret.add(heap.peek());//取滑动窗口最大值
        }
        return ret;
    }
}