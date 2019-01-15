/*
** Data     ：2019-1-15 21:31:45
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99
*/
/*
Single Number的本质，就是用一个数记录每个bit出现的次数，如果一个bit出现两次就归0，
这种运算采用二进制底下的位操作^是很自然的。Single Number II中，
如果能定义三进制底下的某种位操作，也可以达到相同的效果，
Single Number II中想要记录每个bit出现的次数，一个数搞不定就加两个数，
用ones来记录只出现过一次的bits，用twos来记录只出现过两次的bits，
ones&twos实际上就记录了出现过三次的bits，这时候我们来模拟进行出现3次就抵消为0的操作，
抹去ones和twos中都为1的bits。
*/
public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0;//记录只出现一次的数
        int twos = 0;//记录只出现两次的数
        int threes = 0;//记录只出现三次的数
        for(int i = 0; i < A.length; i++){
            int t = A[i];
            twos |= ones & t;//在更新ones前保存twos
            ones ^= t;//更新ones
            threes = twos & ones;;
            ones &= ~threes;//删除出现三次的数
            twos &= ~threes;
        }
        return ones;
    }
}