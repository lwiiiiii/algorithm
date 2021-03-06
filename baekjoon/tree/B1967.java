package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge2{
	int vertex;
	int d;

	public Edge2(int v, int d) {
		this.vertex = v;
		this.d = d;
	}
}

public class B1967 {

	static int[] bfs(int v, List<Edge2>[] list, int start) {
		boolean[] check = new boolean[v+1];
		int[] d = new int[v+1];
		Queue<Integer> q = new LinkedList<>();

		check[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int x = q.remove();
			for (Edge2 e : list[x]) {
				int y = e.vertex;
				int cost = e.d;
				if (check[y] == false) {
					d[y] = d[x] + cost;
					q.add(y);
					check[y] = true;
				}
			}
		}
		return d;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int v = Integer.parseInt(br.readLine());

		List<Edge2>[] list = new ArrayList[v+1];
		for(int i = 1; i <= v; ++i)
			list[i] = new ArrayList<Edge2>();

		for(int i = 1;  i < v; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[vertex].add(new Edge2(x, y));
			list[x].add(new Edge2(vertex, y));

		}

		int[] distance = bfs(v, list, 1);
		int start = 1;
		for (int i = 2; i <= v; i++) { // 루트에서부터 가장 먼 정점을 찾는다
			if (distance[i] > distance[start]) {
				start = i;
			}
		}

		distance = bfs(v, list, start);
		int answer = distance[1];
		for (int i = 2; i <= v; i++) { // 찾은 정점에서 가장 먼 정점의 길이가 트리의 지름
			if (answer < distance[i]) {
				answer = distance[i];
			}
		}

		System.out.println(answer);

		br.close();
	}
}
