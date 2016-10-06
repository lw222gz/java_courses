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
        HashSet<Node<Integer>> collectionOfConnectedNodes = new HashSet<Node<Integer>>();
        HashSet<Node<T>> visited = new HashSet<Node<T>>();


        boolean newConnFound;
        Node link = null;
        Iterator<Node<Integer>> it = dg.iterator();

        while(it.hasNext()){
            Node n = it.next();

            if(!visited.contains(n)){
                newConnFound = false;

                visited.add(n);
                collectionOfConnectedNodes = new HashSet<Node<Integer>>(dfs.dfs(dg, n));
                for(Node node : collectionOfConnectedNodes){
                    //Checks if the node has been added to the marked list, if not then it's added
                    if(!visited.contains(node)){
                        visited.add(node);
                    }
                    //else if check if this node is equal to the current node being iterated over
                    //(to check for a cyclic connection to itself, if so no new connection has been found)
                    //If it's not equal to the current node being iterated over a new connection has been found.
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
                            //c.addAll(collectionOfConnectedNodes);
                            for(Node node : collectionOfConnectedNodes){
                                //if(!c.contains(node)){
                                    c.add(node);
                                //}
                            }
                        }
                    }
                }

            }

        }


        return collection;
    }

    /*@Override
    public Collection<Collection<Node<Integer>>> computeComponents(DirectedGraph<Integer> dg) {
        Collection<Collection<Node<Integer>>> collection = new ArrayList<Collection<Node<Integer>>>();
        Collection<Node<Integer>> collectionOfConnectedNodes = new ArrayList<Node<Integer>>();
        HashSet<Node<T>> visited = new HashSet<Node<T>>();
        boolean isNewConn = false;

        Iterator<Node<Integer>> it = dg.iterator();

        mainLoop:
        while(it.hasNext()){
            Node n = it.next();

            if(!visited.contains(n)){
                isNewConn = false;
                Stack<Node<Integer>> nodeStack = new Stack<Node<Integer>>();

                HashSet<Node<Integer>> nodeList = new HashSet<Node<Integer>>();

                nodeStack.push(n);

                while(!nodeStack.isEmpty()){
                    Node node = nodeStack.pop();
                    if(visited.contains(node)){
                        if(node != n){
                            //new connection found
                            for(Collection c : collection){
                                //If found then the current itearation node gets added to it's connection collection
                                //and a continue is used on the main loop.
                                if(c.contains(node)){
                                    c.add(n);
                                    continue mainLoop;
                                }
                            }
                        }
                        continue;
                    }
                    visited.add(node);
                    nodeList.add(node);

                    Iterator<Node<Integer>> succs = node.succsOf();
                    while(succs.hasNext()){
                        nodeStack.push(succs.next());
                    }
                }

                collection.add(nodeList);
            }
        }

        return collection;
    }*/

}
