static int V ;
    static boolean adjMat [][];
    public static boolean floyd (int first , int second )
    {
        for (int k = 0 ; k <  V ; ++k)
            for (int i = 0 ; i < V ; ++i)
                for (int j = 0 ; j < V ; ++j)
                    adjMat[i][j] |= (adjMat[i][k] & adjMat[k][j]);

        return adjMat[first][second];
    }