package DAA.backtracking;

import java.util.*;
public class hamiltonian{
    public static void addNode(int[][] graph, int x,int y)
    {
        graph[x][y]=1;
        graph[y][x]=1;
    }
    public static boolean isSafe(int x,int i,int[][] graph,int[] visit)
    {
        if(graph[visit[x-1]][i]==0)return false;
        for(int j:visit)
        {
            if(j==i)return false;
        }
        return true;
    }
    public static boolean hamiltonCycle(int x,int[][] graph,int[] visit,int n)
    {
        if(x==n)
        {
            if(graph[visit[x-1]][visit[0]]==1)return true;
            return false;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(x,i,graph,visit))
            {
                visit[x]=i;
                if(hamiltonCycle(x+1,graph,visit,n))return true;
                visit[x]=-1;
            }
        }
        return false;
    }
    
public static void main (String args[])
{
    int[][] graph=new int[5][5];
    
    addNode(graph,0,1);
    addNode(graph,0,3);
    addNode(graph,1,2);
    addNode(graph,1,3);
    addNode(graph,1,4);
    addNode(graph,2,4);
    addNode(graph,3,4);

    //Dont populate diagonals
    int[] visit=new int[5];
    Arrays.fill(visit,-1);
    visit[0]=0;
    boolean ans=hamiltonCycle(1,graph,visit,5);
    if(!ans)System.out.println("No there is no path");
    else {
        System.out.println("Yes we can iterate a path as:");
        for(int i:visit)
        {
            System.out.print(i+" ");
        }
        System.out.print(visit[0]);
    }
}
}
