/*
** Data     ：2019-1-17 18:12:36
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:

输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
示例 2:

输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;
public class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n < 3)
            return n;
        int ret = 0;
        for(int i = 0; i < n; i++){
            int dup = 1;//重复点数
            int ver = 0;//垂直的点数
            Map<Float, Integer> map = new HashMap<>();
            Point a = points[i];
            
            for(int j = 0; j < n; j++){
                if(i == j) 
                    continue;//相同点跳过
                Point b = points[j];
                if(a.x == b.x){
                    if(a.y == b.y)
                        dup ++;//重复点数+1
                    else
                        ver ++;//垂直点数+1
                }else{
                    float k = (float)(a.y - b.y) / (a.x - b.x);//计算斜率
                    if(map.containsKey(k)){
                        map.put(k, 1);//添加至haspmap
                    }else{
                        map.put(k, map.get(k) + 1);//更新hashmap
                    }
                }
            }
            int max = ver;
            for(float k : map.keySet()){
                max = Math.max(map.get(k), max);//取垂直点数或同斜率点数的最大值
            }
            ret = Math.max(ret, max + dup);//取之前保存的最大值和当前点的最大值
        }
        return ret;
    }
}