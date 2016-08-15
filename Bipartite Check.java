static ArrayList<Integer> [] adjList;
    static int V ;
    static final int UNCOLORED = 2 ;
    public static boolean isBipartite ()
    {
        boolean isBipartite = true;
        Queue<Integer> queue = new LinkedList<>();
        int colors [] = new int[V];
        Arrays.fill(colors , UNCOLORED);
        queue.add(0);
        colors[0] = 1;
        while (!queue.isEmpty())
        {
            int u = queue.poll();
            for (int v : adjList[u])
                if (colors[v] == UNCOLORED)
                {
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                }
                else if (colors[v] == colors[u]) isBipartite = false;
        }
        return isBipartite;
    }