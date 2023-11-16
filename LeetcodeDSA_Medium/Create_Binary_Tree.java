/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
import java.util.*;
public class Solution {
    public static Node createTree(int []arr){
        // Write your code here.
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.offer(root);
        int i=0;
        while(!q.isEmpty() && i<3)
        {
            Node temp=q.peek();
            q.poll();
            Node left = new Node(arr[2*i+1]);
            temp.left=left;
            q.offer(left);
            Node right = new Node(arr[2*i+2]);
            temp.right=right;
            q.offer(right);
            i++;
        }
        return root;
    }
}
