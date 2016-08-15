static ArrayList<Integer> adjList [];
    static int [] dfs_num , dfs_low , visited;
    static int dfsNumberCounter , numSCC;
    static Stack <Integer> S;
    static int UNVISITED = 0;
    static int V;
    public static void tarjanSCC(int u)
    {
        dfs_low[u] = dfs_num[u] = ++dfsNumberCounter;
        S.push(u);
        visited[u] = 1;
        for (int v : adjList[u])
        {
            if (dfs_num[v] == UNVISITED)
                tarjanSCC(v);
            if (visited[v] == 1)
                dfs_low[u] = Math.min(dfs_low[u] , dfs_low[v]);
        }

        if (dfs_low[u] == dfs_num[u])
        {
            System.out.println("SCC " + ++numSCC);
            while (true)
            {
                int v = S.pop();
                visited[v] = UNVISITED;
                System.out.println(" " + v);
                if (u == v) break;
                System.out.println("\n");
            }
        }
    }
    
    public static void tarjanSCC ()
    {
        dfs_low = new int[V];
        dfs_num = new int[V];
        visited = new int[V];
        S = new Stack<>();
        dfsNumberCounter = 0;
        numSCC = 0;
        for (int i = 0 ; i < V ; ++i)
            if (dfs_num[i] == UNVISITED)
                tarjanSCC(i);
    }