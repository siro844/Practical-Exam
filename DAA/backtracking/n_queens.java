
public class Main{
    public static void solveNQueens(int n) {
        int mat[][]=new int[n][n];
        int row[]=new int[n]; //Hash fxn i
        int ldig[]=new int[n*2-1]; //Hash fxn i+j
        int rdig[]=new int[n*2-1]; //Hash fxn n-1-i+j
        //For hashing the diagonal and decreasing time complexity
        fillQueen(0,n,mat,row,ldig,rdig);
        return;
    }
    public static void fillQueen(int j,int n,int[][]mat,
    int row[],int ldig[],int rdig[])
    {
        if(j==n)// Reached the last column
        {
            for(int i=0;i<n;i++)
            {
                for(int f=0;f<n;f++)
                {
                    System.out.print(mat[i][f]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(row[i]!=1&&ldig[i+j]!=1&&rdig[n-i+j-1]!=1)
            {
                //Action phase
                mat[i][j]=1;
                row[i]=1;
                ldig[i+j]=1;
                rdig[n-i+j-1]=1;
                fillQueen(j+1,n,mat,row,ldig,rdig); //Recursion
                //Undo Phase
                mat[i][j]=0;
                row[i]=0;
                ldig[i+j]=0;
                rdig[n-i+j-1]=0;
            }
        }
    }
public static void main (String args[])
{
    solveNQueens(4);
}
}
