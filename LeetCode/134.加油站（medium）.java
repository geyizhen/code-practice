/*
** Data     ：2018-12-25 16:43:06
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
There are N gas stations along a circular route, where the amount of gas at station i isgas[i].

You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] rest = new int [gas.length];
        int res = 0;
        for (int i = 0; i < gas.length; i++){
            rest[i] = gas[i] - cost[i];
            res += rest[i];
        }
        if (res < 0)
            return -1;//若所有值之和小于0则返回-1；
        int len = gas.length;
        for (int i = 0; i < len; i++){
            int start = i;
            int end = (i - 1) % len;
            int total = rest[i];
            if (total < 0)
                continue;
            while (start != end){
                start = (start + 1) % len;
                total += rest[start];
                if (total < 0)
                    break;//若过程中total值小于0则跳出当前while循环
            }
            if (total >= 0)
                return i;//若循环走完total值大于0，则返回i的值为正确的起始点
        }
        return -1;
    }
}