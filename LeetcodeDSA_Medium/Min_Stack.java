class MinStack {
    Stack<Long> st;
    Long min=Long.MAX_VALUE;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(st.isEmpty())
        {
            min=value;
            st.push(value);
        }
        else
        {
            if(value<min)
            {
                st.push(2*value-min);
                min=value;

            }
            else
            {
                st.push(value);
            }
        }
    }
    
    public void pop() {
       if(st.peek()<min)
       {
           min=(2*min)-st.peek();
       }
       st.pop();
    }
    
    public int top() {
        if(st.peek()<min)
        {
            return min.intValue();
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
