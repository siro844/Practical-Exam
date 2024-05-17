/**
 * fibonacci
 */
public class fibonacci {
    public static boolean isFibo(int f)
    {
        int a=0;
        int b=1;
        int ans=a;
        while(ans<f)
        {
            ans=a+b;
            a=b;
            b=ans;
        }
        if(ans==f)return true;
        return false;
    }
    public static void main(String[] args) {
        int f=4;
        if(isFibo(f))System.out.println("The number is a fibonacci");
        else System.out.println("The number is not fibonacci");
    }
}