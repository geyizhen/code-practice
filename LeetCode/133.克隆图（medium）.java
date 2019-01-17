/*
** Data     ：2019-1-17 10:34:53
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
克隆一张无向图，图中的每个节点包含一个 label （标签）和一个 neighbors （邻接点）列表 。

OJ的无向图序列化：

节点被唯一标记。

我们用 # 作为每个节点的分隔符，用 , 作为节点标签和邻接点的分隔符。

例如，序列化无向图 {0,1,2#1,2#2,2}。

该图总共有三个节点, 被两个分隔符  # 分为三部分。 

第一个节点的标签为 0，存在从节点 0 到节点 1 和节点 2 的两条边。
第二个节点的标签为 1，存在从节点 1 到节点 2 的一条边。
第三个节点的标签为 2，存在从节点 2 到节点 2 (本身) 的一条边，从而形成自环。
我们将图形可视化如下：

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
//递归实现  //这道题我没看懂题意 copy了一下答案
import java.util.*;
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    private UndirectedGraphNode clone(UndirectedGraphNode node){
        if(node == null)
            return node;
        if(map.containsKey(node.label))
            return map.get(node.label);
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for(UndirectedGraphNode neighbor : node.neighbors){
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}