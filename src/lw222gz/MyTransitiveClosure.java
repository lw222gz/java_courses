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
        Collection<Node<E>> nodes;
        MyDFS<E> dfs = new MyDFS<E>();


        Iterator<Node<E>> it = dg.iterator();

        while(it.hasNext()){
            Node n = it.next();
            nodes = dfs.dfs(dg, n);

            map.put(n, nodes);
        }
        return map;
    }


    //iteartor version
    /*@Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        HashMap<Node<E>, Collection<Node<E>>> map = new HashMap<Node<E>, Collection<Node<E>>>();
        HashSet<Node<E>> connectedNodes = new HashSet<Node<E>>();

        Collection<Node<E>> nodes;
        Stack<Node<E>> nodeQueue = new Stack<Node<E>>();

        Iterator<Node<E>> it = dg.iterator();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();

        while(it.hasNext()){
            Node n = it.next();



            Iterator<Node<E>> succs = n.succsOf();

            while(succs.hasNext()){

                nodeQueue.push(succs.next());
            }

            while(!nodeQueue.isEmpty()){
                Node node = nodeQueue.pop();
                if(!visited.contains(node)){
                    visited.add(node);
                    nodeQueue.push(node);
                }
            }

            map.put(n, connectedNodes);
            //clears the visited set for the comming iteration
            visited.clear();

        }

    }*/
}
