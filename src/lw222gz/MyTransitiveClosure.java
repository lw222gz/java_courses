package lw222gz;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {




    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        HashMap<Node<E>, Collection<Node<E>>> map = new HashMap<Node<E>, Collection<Node<E>>>();
        Collection<Node<E>> nodes;
        MyDFS<E> dfs = new MyDFS<E>();

        Iterator it = dg.iterator();

        while(it.hasNext()){
            Node n = (Node)it.next();
            nodes = dfs.dfs(dg, n);

            map.put(n, nodes);
        }
        return map;
    }
}
