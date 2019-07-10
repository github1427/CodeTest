
import java.util.*;

/**
 * @ Author     ：vain
 * @ Date       ：Created in 上午9:44 2018/9/28
 * @ Description：
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class sdfie {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        
        for (int i=1;i<=10;i++){
            maxHeap.add(i);
        }
        System.out.println(maxHeap.poll());
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(6);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(11);
        System.out.println(KthNode(root,1));
    }
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot!=null||k==0){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode tempNode=pRoot;
        int count=0;
        while(tempNode!=null||!stack.isEmpty()){
            while(tempNode!=null){
                stack.push(tempNode);
                tempNode=tempNode.left;
            }
            tempNode=stack.pop();
            count++;
            if(count==k){
                break;
            }
            tempNode=tempNode.right;
        }
        return tempNode;
    }
}
