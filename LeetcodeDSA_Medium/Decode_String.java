class Solution {
    public String decodeString(String s) {

       Stack<Character> st = new Stack<>();
       for(char c:s.toCharArray())
       {
           if(c!=']')
           {
               st.push(c);
           }
           else
           {
               String temp="";
               while(!st.isEmpty() && st.peek()!='[')
               {
                   temp=st.pop()+temp;
               }
               st.pop();
               String num="";
               while(!st.isEmpty() && Character.isDigit(st.peek()))
               {
                   num=st.pop()+num;
               }
               int number = Integer.parseInt(num);
               String repeat="";
               for(int i=0;i<number;i++)
               {
                   repeat=repeat+temp;
               }
               for(char d:repeat.toCharArray())
               {
                   st.push(d);
               }
           }
       }
           String res="";
           while(!st.isEmpty())
           {
               res=st.pop()+res;
           }
       return res;
       
    }
}
