
import java.util.Arrays;

public class Main {

    static Edge[] edgeList;
    static int V;

    static int kruskal()		//O(E log E)
    {
        int mst = 0;
        shuffle(edgeList);
        Arrays.sort(edgeList);
        UnionFind uf = new UnionFind(V);

        for(int i = 0 ; i < edgeList.length && uf.numSets > 1; ++i) {
            Edge e = edgeList[i];
            if (!uf.isSameSet(e.from, e.to)) {
                mst += e.cost;
                uf.unionSet(e.from, e.to);
            }
        }

        return mst;
    }

    static class Edge implements Comparable<Edge>
    {
        int from, to, cost;

        Edge(int a, int b, int c)
        {
            from = a; to = b; cost = c;
        }

        public int compareTo(Edge e)
        {
            if(cost != e.cost)
                return cost - e.cost;
            if(from != e.from)
                return from - e.from;
            return to - e.to;
        }
    }

    static class UnionFind {
        int[] p, rank, setSize;
        int numSets;

        public UnionFind(int N)
        {
            p = new int[N];
            rank = new int[N];
            setSize = new int[N];
            numSets = N;
            for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
        }

        public int findSet(int i)
        {
            if (p[i] == i) return i;
            else return p[i] = findSet(p[i]);
        }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j)
        {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
            else
            {	p[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() { return numSets; }

        public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }

    
    public static void shuffle(Edge[] a)
    {
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            int r = i + (int)(Math.random() * (n - i));
            Edge tmp = new Edge(a[i].from , a[i].to , a[i].cost);
            a[i] = new Edge(a[r].from , a[r].to , a[r].cost);
            a[r] = tmp;
        }
    }
}
