class Node
{
    String url;
    Node prev,next;
    Node(String url)
    {
        prev=null;
        next=null;
        this.url=url;
    }
}

class BrowserHistory {

    Node curr;
    public BrowserHistory(String homepage) {
        Node head=new Node(homepage);
        curr=head;
    }
    
    public void visit(String url) {
        Node temp=new Node(url);
            temp.prev=curr;
            curr.next=temp;
            curr=curr.next;
        
        
    }
    
    public String back(int steps) {
        while(steps>0 && curr.prev!=null)
        {
            curr=curr.prev;
            steps--;
        }
        return curr.url;
        
    }
    
    public String forward(int steps) {
       
       while(steps>0 && curr.next!=null)
       {
           curr=curr.next;
           steps--;
       }
       return curr.url;
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
