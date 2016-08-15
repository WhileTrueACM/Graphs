// O (V + E)

static ArrayList<Integer> [] adjList;
    static int V ;
    static boolean visited [];
    static Stack<Integer> ts = new Stack<>();
    public static void dfs (int u)
    {
        visited[u] = true;
        for (int v : adjList[u])
            if (!visited[v])
                dfs(v);
        ts.push(u);
    }


    // in Main

    for (int i = 0 ; i < V ; ++i)
            if (!visited[i])
                dfs (i);
        while (!ts.isEmpty()) System.out.println(ts.pop());