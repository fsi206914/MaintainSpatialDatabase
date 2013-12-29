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

package algorithm;

import java.util.Comparator;

public class QueueComparator implements Comparator<Vertex>{

    @Override
    public int compare(Vertex v1, Vertex v2) {
        if(v1.getDist()>v2.getDist()){
            return 1;
        }
        else if(v1.getDist()<v2.getDist()){
            return -1;
        }
        else{
            if(v1.getName()>v2.getName()){
                return 1;
            }
            else if(v1.getName()<v2.getName()){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}