for (int k = 0 ; k <  V ; ++k)
            for (int i = 0 ; i < V ; ++i)
                for (int j = 0 ; j < V ; ++j)
                    adjMat[i][j] = Math.min(adjMat[i][j] , Math.max (adjMat[i][k] , adjMat[k][j]));