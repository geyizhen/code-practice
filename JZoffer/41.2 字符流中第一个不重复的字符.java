import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    private int[] cnts = new int[256];//创建大小为256的数组对应不同的字符，括号里为ASCII码，值为出现的次数
    private Queue<Character> queue = new LinkedList<>();
    //Insert one char from stringstream 
    //从字符流中读取一个字符
    public void Insert(char ch)
    {
        cnts[ch]++;//对应的字符次数+1
        queue.add(ch);//添加到队列中
        while(!queue.isEmpty()&&cnts[queue.peek()] > 1)//若队列不为空且当前第一个出现的字符出现的次数超过一次
            queue.poll();//则清除该字符
    }
  //return the first appearence once char in current stringstream
  //返回当前字符流中第一个出现一次的字符
    public char FirstAppearingOnce()
    {
        return queue.isEmpty()? '#': queue.peek();//返回队列的第一个值
    }
}