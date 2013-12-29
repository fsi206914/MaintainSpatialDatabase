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


public class Vertex{

    private int name;
    private Vertex prev;
    private int dist;

    public Vertex(int name, Vertex prev, int dist) {
        this.name = name;
        this.prev = prev;
        this.dist = dist;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getName() {
        return name;
    }

    public Vertex getVertex() {
        return prev;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(Number distance) {
        dist = distance.intValue();
    }

    @Override
    public String toString() {
        if (dist == Integer.MAX_VALUE) {
            return name + ":**";
        } else {
            return name + ":" + dist;
        }
    }
}
