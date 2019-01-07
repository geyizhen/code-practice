/*https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7
大致思路为：
第一步：将第一个字符与后续所有字符交换
第二步：固定第一个字符，递归第一步，把剩余部分的第一个字符与后续所有字符交换
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        /*此处使用Arraylist进行声明也可以，
        使用List是因为ArrayList是他的一个实现类/继承类，在进行代码重构时比较方便*/
        if (str.length() > 0 && str != null){
            char[] cs = str.toCharArray();
            Per (cs, 0, res);
            Collections.sort(res);//进行字典排序
        }
        return (ArrayList)res;
    }
        public void Per(char[] cs, int i, List<String> list){
            if (i == cs.length - 1){//此处判断是否扫描到了最后一个字符
                if(!list.contains(new String(cs)))//判断是否重复
                    list.add(new String(cs));//若不重复则添加到字符串数组中
                }else{
                    for(int j = i; j <= cs.length -1; j++){
                        swap(cs, i, j);//交换字符
                        Per(cs, i + 1, list);//进行递归
                        swap(cs, i, j);//复位
                    }
                }
            }
        public void swap(char[] cs, int i, int j){
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
}
//运行结果：[abc, acb, bac, bca, cba, cab]
//[abcd, abdc, acbd, acdb, adcb, adbc, bacd, badc, bcad, bcda, bdca, bdac, 
// cbad, cbda, cabd, cadb, cdab, cdba, dbca, dbac, dcba, dcab, dacb, dabc]