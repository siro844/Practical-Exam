import java.util.*;

package DAA.dynamic;

/**
 * multistage
 */
public class multistage {
        static int N=8;
        static int inf=Integer.MAX_VALUE;
        public static int shortestDistance(int[][] graph)
        {
            int dist[]=new int[N];
            for(int i=0;i<N;i++)
            {
                dist[i]=inf;
            }
            
            dist[N-1]=0;
            for(int i=N-2;i>=0;i--)
            {
                for(int j=i;j<N;j++)
                {
                    if(graph[i][j]==inf)continue;
                    dist[i]=Math.min(dist[i],dist[j]+graph[i][j]);
                }
            }
            return dist[0];
        }
        public static void main(String[] args) {
            shortestDistance(graph);
        }
    
}