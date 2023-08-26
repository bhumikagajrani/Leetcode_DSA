class BrowserHistory {

    Stack<String> back_hist;
    Stack<String> forw_hist;
    public BrowserHistory(String homepage) {
        
        back_hist=new Stack<String>();
        forw_hist=new Stack<String>();
        back_hist.push(homepage);
    }
    
    public void visit(String url) {
        while(forw_hist.size()!=0)
        {
            forw_hist.pop();
        }
        back_hist.push(url);
        
    }
    
    public String back(int steps) {
        while(steps>0 && back_hist.size()>1)
        {
            forw_hist.push(back_hist.pop());
            steps--;
        }
        return back_hist.peek(); 
        
    }
    
    public String forward(int steps) {
        while(steps>0 && !forw_hist.isEmpty())
        {
            back_hist.push(forw_hist.pop());
            steps--;
        }
        return back_hist.peek();
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
