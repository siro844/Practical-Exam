/**
 * optimalbst
 */
public class optimalbst {
    public static int minSum(int[]freq,int i,int j)
    {
        int s=0;
        for(int k=i;k<=j;k++)
        {
            if(k>=freq.length)continue;
            s+=freq[k];
        }
        return s;
    }
    public static int optimalBst(int[] keys,int[] freq)
    {
        int n=keys.length;
        int[][] mat=new int[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            mat[i][i]=freq[i];
        }
        for(int L=2;L<=n;L++)
        {
            for(int i=0;i<=n-L+1;i++)
            {
                int j=i+L-1;
                mat[i][j]=Integer.MAX_VALUE;
                int sum =minSum(freq,i,j);
                for(int r=i;r<=j;r++)
                {
                    int c=(r>i?mat[i][r-1]:0)+(r<j?mat[r+1][j]:0)+sum;
                    mat[i][j]=Math.min(mat[i][j],c);
                }
            }
        }
        return mat[0][n-1];
    }
    public static void main(String[] args) {
        int keys[] = {10,12,20};
        int freq[] = {34,8,50};
        System.out.println("Const of optimal BST is : "+ optimalBst(keys,freq));
    }
}