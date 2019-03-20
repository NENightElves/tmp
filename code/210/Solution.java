package Tessst;

import java.util.LinkedList;

public class Solution {

	boolean [][] graph;
	int[] results;
	int ww = 0;
	LinkedList<Integer> stack1;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		graph = new boolean[numCourses][numCourses];
		results = new int[numCourses];
		stack1 = new LinkedList<>();
//		stack2 = new LinkedList<>();
		for(int i = 0; i < prerequisites.length; i ++) {
			graph[prerequisites[i][0]][prerequisites[i][1]] = true;
		}
		for(int i = 0; i < numCourses; i ++) {
			for(int j = 0; j < i; j ++) {
				if(graph[i][j] == true && graph[j][i] == true) {
					return new int[0];
				}
			}
		}
		System.out.println(next(0, -1));
		dfs(0);
		return results;
	}

	
	private int next(int i, int j) {
		int n = graph.length;
		if(i >= 0 && i < n && i != j && j >= -1) {
			for(int k = j + 1; k < n; k ++)
				if(graph[i][k])
					return k;
		}
		return -1;
	}
	
	private void dfs(int i) {
		boolean [] visited = new boolean[graph.length];
		int j = i;
		do {
			if(!visited[j]) {
				dfs(j, visited);
			}
			j = (j + 1) % graph.length;
		}while(j != i);
	}
	
	private void dfs(int i, boolean[] visited) {
		int j = next(i, -1);
		if(j == -1) { //没有后记节点，访问成功
			visited[i] = true;
			results[ww ++] = i;
			for(int k = 0; k < graph.length; k ++) {
				graph[k][i] = false;
			}
			return;
		}
		if(stack1.contains(i)) {
			results = new int[0];
			ww = 0;
			return;
		}
		stack1.push(i);
		while(j != -1) {
			if(!visited[j])
				dfs(j, visited);
			j = next(i, j);
		}
	}
	
	public static void main(String[] args) {
		Solution a = new Solution();
		int []b = a.findOrder(3,new int[][]{
			{1,0},{0,2},{2,1}
		});
		for(int i = 0; i < b.length; i ++) {
			System.out.println(b[i]);
		}
	}
	

}
