package lw222gz;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {




    //Returns a Map containing a node as key and a Collection<Node<E>> as value,
    //the collection is all the connected nodes to the key node value
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        HashMap<Node<E>, Collection<Node<E>>> map = new HashMap<Node<E>, Collection<Node<E>>>();

        MyDFS<E> dfs = new MyDFS<E>();

        Iterator<Node<E>> it = dg.iterator();

        //Iterates over all the
        while(it.hasNext()){
            Node n = it.next();
            map.put(n, dfs.dfs(dg, n));
        }
        return map;
    }

}
