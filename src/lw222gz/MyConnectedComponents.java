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
        MyDFS dfs = new MyDFS(); //O(1)

        Collection<Collection<Node<Integer>>> collection = new ArrayList<Collection<Node<Integer>>>();
        LinkedHashSet<Node<Integer>> currentCollection;
        LinkedHashSet<Node<Integer>> linkedSet = new LinkedHashSet<Node<Integer>>();

        //Visited map that contains the visited nodes and points to the collection of that node.
        HashMap<Node<Integer>, LinkedHashSet<Node<Integer>>> visited = new HashMap<Node<Integer>, LinkedHashSet<Node<Integer>>>();

        //Boolean that is set to true when a connection has been found.
        boolean connectionFound;

        Iterator<Node<Integer>> it = dg.iterator();

        while(it.hasNext()){ //O(N) Where N is the amount of nodes
            Node n = it.next();

            //Resets the current collection for the new iteartion
            currentCollection = new LinkedHashSet<Node<Integer>>();

            if(!visited.containsKey(n)){ //O(1) src: http://docs.oracle.com/javase/6/docs/api/java/util/HashMap.html
                connectionFound = false;

                visited.put(n, currentCollection); //O(1) src: http://docs.oracle.com/javase/6/docs/api/java/util/HashMap.html

                //do a dfs search on the current node and save all the nodes found in the current collection
                currentCollection = new LinkedHashSet<Node<Integer>>(dfs.dfs(dg, n)); //O(N+E)
                for(Node node : currentCollection){ //O(N)
                    //Checks if the node has been added to the marked list, if not then it's added
                    if(!visited.containsKey(node)){ //O(1)
                        visited.put(node, currentCollection); //O(1)
                    }
                    else if(node != n){
                        //Give linkedSet the value to the Set the connected node is in
                        linkedSet = visited.get(node); //O(1)
                        connectionFound = true;
                    }
                }

                //If a connection was not found then the collection will be added as a new collection
                if(!connectionFound){
                    collection.add(currentCollection); //O(1)
                }
                //else if a connection was found the nodes are added to that collection
                else{
                    linkedSet.addAll(currentCollection); //O(N)
                }
            }
        }

        return collection;
    }

}
