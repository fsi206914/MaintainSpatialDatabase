/* Copyright (C) 2013 Georgios Panos Zografos
* 
* Permission is hereby granted, free of charge,
* to any person obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without restriction,
* including without limitation the rights to use, copy, modify, merge, publish,
* distribute, sublicense, and/or sell copies of the Software,
* and to permit persons to whom the Software is furnished to do so,
* subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
* DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
* OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
* OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/


import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Dijkstra {

    private UndirectedSparseGraph<Vertex, Edge> graph;
    private PriorityQueue<Vertex> pq;
    private Vertex source;

    public Dijkstra(UndirectedSparseGraph<Vertex, Edge> graph, Vertex source) {
        this.graph = graph;
        this.source = source;
        pq = null;
    }

    public void setUnlimited() {
        for (Vertex v : graph.getVertices()) {
            v.setDist(Integer.MAX_VALUE);
            v.setPrev(null);
        }
    }

    public void setDist(int name, int dist) {
        Vertex v = findVertex(name);
        v.setDist(dist);
    }
    public Vertex getSource(){
        return source;
    }
    public void setSourceDist() {
        source.setDist(0);
    }

    public void makeQueue() {
        pq = new PriorityQueue<>(graph.getVertexCount(), new QueueComparator());
        for (Vertex v : graph.getVertices()) {
            pq.add(v);
        }
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public Vertex deletemin() {
        return pq.poll();
    }

    public void decreaseKey(Vertex w) {
        PriorityQueue<Vertex> tempQueue = new PriorityQueue<>(graph.getVertexCount(),new QueueComparator());
        while (!pq.isEmpty()) {
            Vertex temp = pq.poll();
            if (w.getName() == temp.getName()) {
                continue;
            }
            tempQueue.add(temp);
        }
        while (!tempQueue.isEmpty()) {
            pq.add(tempQueue.poll());
        }
        pq.add(w);
    }

    private Vertex findVertex(int name) {
        Vertex v;
        Collection<Vertex> col = graph.getVertices();
        Iterator<Vertex> it = col.iterator();
        while (it.hasNext()) {
            v = it.next();
            if (v.getName() == name) {
                return v;
            }
        }
        return null;
    }
}
