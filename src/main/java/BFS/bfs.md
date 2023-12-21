# 🌐 너비 우선 탐색 (BFS)

## 그래프 탐색이란?

하나의 정점에서 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것입니다. 예를 들어, 특정 도시에서 다른 도시로 갈 수 있는 경로가 있는지, 전자 회로에서 특정 단자들이 서로 연결되어 있는지 확인하는 데 사용됩니다.

## 🏊‍♂️ 너비 우선 탐색이란?

루트 노드(혹은 다른 임의의 노드)에서 시작하여 인접한 노드를 먼저 탐색하는 방법입니다. 즉, 깊게(deep) 탐색하기 전에 넓게(breadth) 탐색합니다.

### 언제 사용하나요?

- 두 노드 사이의 최단 경로를 찾을 때, 특히 모든 간선의 비용이 동일할 때 BFS를 사용합니다.
- BFS는 모든 간선의 비용이 동일할 때 그래프에서 최단 거리를 효과적으로 찾는 알고리즘입니다. 미로에서 출구까지의 최단 경로를 찾는 문제에도 효과적으로 활용됩니다.

### 예시 사용 경우

지구상의 모든 친구 관계를 그래프로 표현했을 때 승우와 승민 사이에 존재하는 경로를 찾는 경우를 생각해 보세요. 깊이 우선 탐색(DFS)은 모든 친구 관계를 살펴봐야 할 수도 있지만, 너비 우선 탐색(BFS)은 승우와 가까운 관계부터 탐색을 시작합니다.

### BFS의 특징

BFS는 때때로 다른 탐색 방법에 비해 더 복잡하고 직관적이지 않을 수 있습니다.

## BFS 탐색 과정

![BFS 과정](이미지-URL-여기에-추가)
*이미지 출처: [gmlwjd9405.github.io](https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html)*

### BFS 자바 구현 예제

```java
package org.example.BFS.implement;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V; // 노드의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트

    // 생성자
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // 노드를 연결 v->w
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // s를 시작 노드로 한 BFS 탐색하면서 탐색된 노드를 출력
    void BFS(int s) {
        boolean visited[] = new boolean[V]; // 노드의 방문 여부 판단
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

package org.example.BFS.implement;

public class main {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("노드 2부터 BFS 탐색 시작:");
        g.BFS(2);
    }
}