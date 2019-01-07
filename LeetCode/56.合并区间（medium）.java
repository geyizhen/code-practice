/*
** Data     ：2018-12-27 21:28:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 0 || intervals == null)
            return intervals;
        ArrayList<Interval> res = new ArrayList<>();//创建一个新的数组链表来存放最终的输出结果
        Collections.sort(intervals, new Comparator<Interval>(){//使用比较器对区间按照start元素进行排序
            @Override
            public int compare(Interval o1, Interval o2){
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start == o2.start)
                    return 0;
                else
                    return 1;
            }
        });
        Interval top = intervals.get(0);
        res.add(new Interval(top.start, top.end));//将原链表的第一个元素放入新的res链表中
        for (int i = 1; i < intervals.size(); i++){//从原链表中取后续元素与res的最后一个元素进行比较
            Interval cur = intervals.get(i);
            top = res.get(res.size() - 1);
            if (top.end >= cur.start)//如果重叠则进行合并
                top.end = Math.max(top.end, cur.end);
            else
                res.add(new Interval(cur.start, cur.end));
        }
        return res;
    }
}