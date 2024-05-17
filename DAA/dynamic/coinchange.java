import java.util.Arrays;
public class coinchange {
    public static int coinChange(int [] d,int t)
    {
        int n=d.length;
        int[] mat=new int[t+1];
        int[] took=new int[t+1];
        Arrays.fill(took,-1);
        Arrays.fill(mat,100);//Took 100 coz overflow was occuring on taking Integer.MAX_VALUE
        mat[0]=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=t;j++)
            {
                if(d[i]<=j)
                {
                    if(mat[j-d[i]]+1<mat[j])
                    {
                        mat[j]=mat[j-d[i]]+1;
                        took[j]=d[i];
                    }
                }
            }
            // for(int k:mat)System.out.print(k+" ");
            // System.out.println();
        }
        if(mat[t]!=100)
        {
            int a=t;
            System.out.println("The coins took are: ");
        while(a>0)
        {
            System.out.print(took[a]+" ");
            a-=took[a];
        }
        System.out.println("The min coins required are");
        return mat[t];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] den=new int[]{1,3,4,6};
        int tgt=13;
        System.out.println(coinChange(den,tgt));
    }
}