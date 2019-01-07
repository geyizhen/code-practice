import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //建造一个大顶堆，存放左半边元素
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2)->o2 - o1);
    //建造一个小顶堆，存放右半边元素，且值均比左半边大
    private PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2)->o1 - o2);
    //当前读取的数据的个数N
    private int N = 0;
    //将第奇数个元素插入左边，第偶数个插入右边，每次插入之后选取堆顶元素插入另一个堆
    //这样可以保证右边大顶堆元素永远大于左边小顶堆元素
    public void Insert(Integer num) {
        if(N % 2 == 0){
            left.add(num);
            right.add(left.poll());
        }else{
            right.add(num);
            left.add(right.poll());
        }
        N ++;
    }
    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek())/2.0;
        else
            return (double) right.peek();
    }
}