//RabinKarp approach
class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        StringBuilder sb = new StringBuilder();

        int ans=0;
        while(sb.length()<b.length())
        {
            sb.append(a);
            ans++;
        }

        if(rabinkarp(sb.toString(),b))
        {
            return ans;
        }
        else if(rabinkarp(sb.toString()+a,b))
        {
            return ans+1;
        }
        else
        {
            return -1;
        }  
    }

    private boolean rabinkarp(String s1, String s2)
    {
        long p=31;
        long pow=1;
        long hashv=0;
        long mod=1000000007;

        for(int i=0;i<s2.length();i++)
        {
            hashv=(hashv+(s2.charAt(i)-'a'+1)*pow)%mod;
            pow=(pow*p)%mod;
        }

        long[] hasharr = new long[s1.length()];
        long[] powarr = new long[s1.length()];

        hasharr[0]=s1.charAt(0)-'a'+1;
        powarr[0]=1;
        pow=p;

        for(int i=1;i<s1.length();i++)
        {
            hasharr[i]=(hasharr[i-1] + (s1.charAt(i)-'a'+1)*pow)%mod;
            powarr[i]=pow;
            pow=(pow*p)%mod;
        }

        int substrind=0;
        int len2=s2.length()-1;
        while(len2<s1.length())
        {
            long substrhash=hasharr[len2];

            if(substrind>0)
            {
                substrhash=(substrhash-hasharr[substrind-1]+mod)%mod;
            }

            if((hashv*powarr[substrind])%mod==substrhash)
            {
                return true;
            }

            substrind++;
            len2++;
        }
        return false;


    }
}
