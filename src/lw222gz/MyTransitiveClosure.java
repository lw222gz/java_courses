package lw222gz;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

    private MyDFS<E> dfs = new MyDFS<E>();


    //Returns a Map containing a node as key and a Collection<Node<E>> as value,
    //the collection is all the connected nodes to the key node value
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        HashMap<Node<E>, Collection<Node<E>>> map = new HashMap<Node<E>, Collection<Node<E>>>();

        //Iterates over all the nodes
        dg.iterator().forEachRemaining(nextNode -> { //O(N)
            map.put(nextNode, dfs.dfs(dg, nextNode)); //O(N+E) (this is for the dfs call)
        });

        return map;
    }

}
