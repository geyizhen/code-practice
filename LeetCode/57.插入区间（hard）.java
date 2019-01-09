/*
** Data     ：2019-1-9 15:25:43
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
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
//思路：把每一个区间与newInterval进行比较，分三种情况进行考虑
import java.util.ArrayList;
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int nums = intervals.size();
        ArrayList<Interval> res = new ArrayList<Interval>();
        int i;
        for(i = 0; i < nums; i++){
            if(newInterval.start > intervals.get(i).end){
                res.add(intervals.get(i));
            }else if(newInterval.end < intervals.get(i).start){
                break;//当后续所有区间都比newInterval大的时候跳出
            }else{
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        res.add(newInterval);
        for( ; i < nums; i++){
            res.add(intervals.get(i));
        }
        return res;
    }
}