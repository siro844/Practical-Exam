import java.util.*;

class Knapsack{
    public static int Knapsack(int n,int W,int[]p,int[]wt)
    {
        int[][] grid=new int[n+1][W+1];
        for(int i=0;i<=n;i++)
        {
            for(int w=0;w<=W;w++)
            {
                if(i==0||w==0)grid[i][w]=0;
                else if(wt[i-1]<=w)
                {
                    grid[i][w]=Math.max(p[i-1]+grid[i-1][w-wt[i-1]],grid[i-1][w]);
                }
                else
                {
                    grid[i][w]=grid[i-1][w];
                }
            }
        }
        System.out.println("Answer is: "+grid[n][W]);
        int ans=grid[n][W];
        int i=n;
        int w=W;
        while(i>0||ans>0)
        {
            if(ans==grid[i-1][w])
            {
                i--;
            }
            else{
                System.out.println(wt[i-1]+" ");
                ans-=p[i-1];
                w-=wt[i-1];
                i--;
            }
        }
    }
    public static void main(String[] args) {
        int[] profit= {60,100,120};
        int[] weight={10,20,30};
        int W=50;
        int n=profit.length;
        System.out.println(Knapsack(n,W,profit,weight));
    }
}