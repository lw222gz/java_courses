package lw222gz;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyGML<E> extends GML<E> {


    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        String str = "graph [\n";

        Iterator<Node<E>> it = graph.iterator();

        //Map<Integer, Integer> edges = new LinkedHashMap<Integer, Integer>();

        int id = 0;

        //Node display
        while(it.hasNext()){
            Node n = it.next();

            str += "\n\tnode [";
            str += "\n\t\tid " + id++;
            str += "\n\t\tlabel \"node " + n + "\"";
            str += "\n\t]";
        }

        //Edge display
        it = graph.iterator();

        while(it.hasNext()){
            Node n = it.next();

            Iterator<Node<E>> succsIt = n.succsOf();
            while(succsIt.hasNext()){
                Node succN = succsIt.next();

                str += "\n\tedge [";
                str += "\n\t\tsource " + n;
                str += "\n\t\ttarget " + succN;
                str += "\n\t]";
            }
        }

        str += "\n]";


        return str;
    }
}
