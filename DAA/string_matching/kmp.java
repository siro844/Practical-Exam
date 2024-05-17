
public class kmp {
    public static void fillArr(int[] arr,String text)
    {
        int lis=0;
        char[] tarr=text.toCharArray();
        int i=1;
        arr[0]=0;
        int len=text.length();
        while(i<len)
        {
            if(tarr[i]==tarr[lis])
            {
                lis++;
                arr[i]=lis;
                i++;
            }
            else
            {
                if(lis>0)
                {
                    lis=arr[lis-1]; //backtrack to the last lis value
                }
                else
                {
                    arr[i]=lis; //lis is 0 here
                    i++;
                }
            }
        }
    }
    public static void kmpSearch(String text,String pattern)
    {
        int arr[]=new int[pattern.length()];
        fillArr(arr,pattern);
        
        int p=pattern.length();
        int t=text.length();
        int i=0,j=0;
        while(i<t&&j<p)
        {
            if(text.charAt(i)==pattern.charAt(j))
            {
                i++;
                j++;
            }
            if(j==p)
            {
                System.out.println("Pattern found at index:"+(i-j));
                j=arr[j-1];
            }
            else if(i<t&&text.charAt(i)!=pattern.charAt(j))
            {
                if(j!=0)
                {
                    j=arr[j-1];
                }
                else i++;
            }
        }

    }
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "BACD";
        kmpSearch(text, pattern);
    }
}