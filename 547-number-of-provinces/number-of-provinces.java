class Solution {
    public int findCircleNum(int[][] isConnected) {
        // isConnected[i][j] = 1 // connection between i and j city
        // isConnected[i][j] = 0 // no connection
        int numberOfCities = isConnected.length; // number of cities
        boolean[] visited = new boolean[numberOfCities]; // all filled with false
        int count = 0; // for number of provinces

        for (int i = 0; i < numberOfCities; i++) {
            if (!visited[i]) { // if city not visited
                dfs(i, isConnected, visited);
                // backtrack
                count++;
            }
        }
        return count;
    }

    void dfs(int currentCity, int[][] isConnected, boolean[] visited) {
        visited[currentCity] = true; // this city is marked visited
        // current city neighbour city
        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
            if (isConnected[currentCity][neighbour] == 1 && !visited[neighbour]) {
                dfs(neighbour, isConnected, visited);
            }
        }
    }
}
