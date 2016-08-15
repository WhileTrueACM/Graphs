	static ArrayList<Integer> adjList[];
	static long adjMat [][]; // Initialize with Edge weights and if no Edge -> INF
	static int V;
	public static void floyd_warshall()
	{
		p = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				p[i][j] = i;
			
		for(int k = 0 ; k < V ; ++k)
			for(int i = 0 ; i < V ; ++i)
				for(int j = 0 ; j < V ; ++j)
					 if (adjMat[i][k] + adjMat[k][j] < adjMat[i][j]) {
                        adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                        p[i][j] = p[k][j];
                    }
	}

	static void print(int i, int j)
	{
		if(i != j) print(i, p[i][j]);
		out.add(j);
	}