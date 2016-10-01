package lw222gz;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyConnectedComponents<T> implements ConnectedComponents<Integer> {

    /**
     * Two nodes a and b are directly connected if their exist an edge (a,b)
     * or an edge (b,a). Two nodes a and k are connected if there exist a sequence
     * of nodes [a,b,c,d, ... j,k] such that [a,b], [b,c], [c,d], [d,e], ..., [j,k]
     * are all directly connected.
     * <p/>
     * Problem: find a partitioning of the graph nodes such that two nodes belongs to the
     * same partitioning if and only if they are connected.
     * </p>
     * The result is a collection of node collections.
     *
     * @author jonasl
     *
     */
    @Override
    public Collection<Collection<Node<Integer>>> computeComponents(DirectedGraph<Integer> dg) {

        MyDFS dfs = new MyDFS();

        Collection<Collection<Node<Integer>>> collection = new ArrayList<Collection<Node<Integer>>>();
        Collection<Node<Integer>> collectionOfConnectedNodes = new ArrayList<Node<Integer>>();
        List<Node<T>> visited = new ArrayList<Node<T>>();


        boolean newConnFound = false;
        Node link = null;
        Iterator it = dg.iterator();

        while(it.hasNext()){
            Node n = (Node)it.next();

            if(!visited.contains(n)){
                newConnFound = false;

                visited.add(n);
                collectionOfConnectedNodes = dfs.dfs(dg, n);
                for(Node node : collectionOfConnectedNodes){
                    if(!visited.contains(node)){
                        visited.add(node);
                    }
                    //IF it already contains node, a new connection has been found
                    //TODO: OPTIMIZE/ FIX SHIT CODE
                    else if(node != n){
                        newConnFound = true;
                        link = node;
                    }


                }

                if(!newConnFound){
                    collection.add(collectionOfConnectedNodes);
                }
                else{
                    //Some shit ugly code, but it works
                    for(Collection<Node<Integer>> c : collection){
                        if(c.contains(link)){
                            for(Node node : collectionOfConnectedNodes){
                                if(!c.contains(node)){
                                    c.add(node);
                                }
                            }
                        }
                    }
                }

            }

        }


        return collection;
    }
}
