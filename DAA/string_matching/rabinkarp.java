public class RabinKarp {
    public static int getPattern(int code,String text,int t,int i)
    {
        
        if(code==0)    //Initial Hashing Time Complexity (m)
        {           
        for(int k=0;k<t;k++)
        {
            int z=(text.charAt(k)-'A'+1)*(int)Math.pow(26,t-k-1);
            // using a stong Hash function to avoid collisions
               code+=z;
        }
        }
        else
        {
            int z=(text.charAt(t+i-1)-'A'+1);   //get the next char in the string
            int ch=text.charAt(i-1)-'A'+1;      //get the first char of the current code
            code=code-(int)(Math.pow(26,t-1)*ch);   //Remove the weight of first char
            code=code*26+z; //Shift others by 1 and add the next char
            //EG: if i=1  AABA = AABA-A...= ABA*26 = ABA.+C = ABAC
        }
        return code;
    }
    public static void rabinKarpSearch(String text,String pattern)
    {
        int t=text.length();
        int p=pattern.length();
        int i=0;
        int pcode=0;
        pcode=getPattern(pcode,pattern,p,i);
        int tcode=0;
        for(i=0;i<t-p+1;i++) //Main Loop time complexity n
        {
            tcode=getPattern(tcode,text,p,i);
            if(pcode==tcode)System.out.println("String found at index: "+ i);
        }
    }
    public static void main(String[] args) {
        String text = "AABACAADAABAABA";
        String pattern = "AABA";
        rabinKarpSearch(text, pattern);
    }
}