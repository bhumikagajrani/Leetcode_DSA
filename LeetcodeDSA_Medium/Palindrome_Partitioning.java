class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList();
        Partition(0,s,res,new ArrayList());
        return res;
    }
    void Partition(int index, String str, List<List<String>> res, List<String> list)
    {
        if(index==str.length())
        {
            res.add(new ArrayList<>(list));
        }

        for(int i=index;i<str.length();i++)
        {
            if(isPalindrome(str,index,i))
            {
                list.add(str.substring(index,i+1));
                Partition(i+1,str,res,list);
                list.remove(list.size()-1);
            }
        }
    }

    boolean isPalindrome(String str, int start, int end)
    {
        while(start<=end)
        {
            if(str.charAt(start++) != str.charAt(end--))
            return false;
        }
        return true;
    }
}