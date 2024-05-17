package DAA.Greedy;

import java.util.*;
class Graph
    {
        private int V;
        private List<List<Couple>>arr;
        Graph(int V)
        {
            this.V=V;
            arr = new ArrayList<>();
            for(int i=0;i<V;i++)
            {
                ArrayList<Couple> car = new ArrayList<>();
                arr.add(car);
            }
        }
        void addEdge(int u,int v,int w)
        {
            arr.get(u).add(new Couple(v,w));
            arr.get(v).add(new Couple(u,w));
        }
        void findShort(int src)
        {
            PriorityQueue<Couple> pq=new PriorityQueue<>(Comparator.comparingInt(c->c.him));
            int[] dist=new int[V];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[src]=0;
            pq.add(new Couple(0,src)); //PUT DISTANCE FIRST THEN THE NODE
            while(!pq.isEmpty())
            {
                int u=pq.poll().her;
                for(Couple v:arr.get(u))    //In arraylist 1st is distination 2nd is weight
                {
                    if(dist[v.him]>dist[u]+v.her)
                    {
                        dist[v.him]=dist[u]+v.her;
                        pq.add(new Couple(dist[v.him],v.him));
                    }
                }
            }
            for(int i:dist)
            {
                int k=0;
                System.out.println("For Node "+k+"=:"+i);
            }
        }
    }
    class Couple
    {
        int him;
        int her;
        Couple(int him,int her)
        {
            this.him=him;
            this.her=her;
        }
    }
    
public class djikstra
{
	public static void main(String[] args) {
		int V=9;
		Graph g= new Graph(V);
		g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
		g.findShort(0);
	}
}
