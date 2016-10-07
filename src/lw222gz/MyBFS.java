package lw222gz;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyBFS<E> implements BFS<E> {

    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        LinkedHashSet<Node<E>> init = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> marked = new HashSet<Node<E>>();
        LinkedHashSet<Node<E>> list = new LinkedHashSet<Node<E>>();

        //Marks and sets num value for the first root node.
        init.add(root);
        marked.add(root);
        root.num = marked.size();

        return new ArrayList<Node<E>>(bfs(init, new LinkedHashSet<Node<E>>(), marked));
    }





    //Algorithm for breadth-first search
    //@nodeSet is the set of nodes of the current level of the graph
    //@list should be a newly initiated list that will later be returned with the wanted values
    //@marked is the list containing all of the marked nodes.
    private LinkedHashSet<Node<E>> bfs(LinkedHashSet<Node<E>> nodeSet, LinkedHashSet<Node<E>> list, HashSet<Node<E>> marked){
        Iterator<Node<E>> it = nodeSet.iterator();

        LinkedHashSet<Node<E>> set = new LinkedHashSet<Node<E>>();

        while(it.hasNext()){
            Node n = it.next();
            list.add(n);

            Iterator<Node<E>> succIt = n.succsOf();
            while(succIt.hasNext()){

                Node node = succIt.next();

                if(!marked.contains(node)){
                    marked.add(node);
                    node.num = marked.size();
                    set.add(node);
                }
            }
        }
        //If the next set size is 0 then there is no deeper level of the graph
        if(set.size() == 0){
            return list;
        }
        bfs(set, list, marked);

        return list;
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        LinkedHashSet<Node<E>> init = new LinkedHashSet<Node<E>>();
        LinkedHashSet<Node<E>> list = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> marked = new HashSet<Node<E>>();

        //If head nodes are found, iterate over them to find all nodes.
        if(graph.headCount() > 0){
            Iterator<Node<E>> it = graph.heads();

            while(it.hasNext()){
                Node n = it.next();

                marked.add(n);
                n.num = marked.size();
                init.add(n);

                list.addAll(bfs(init, new LinkedHashSet<Node<E>>(), marked));

                init = new LinkedHashSet<Node<E>>();
            }
        }
        //Else go for the first node in the list
        else{
            Node n = graph.getNodeFor(graph.allItems().get(0));
            if(n != null){
                init.add(n);
                marked.add(n);
                n.num = marked.size();
                list = (bfs(init, new LinkedHashSet<Node<E>>(), marked));
            }

        }

        return new ArrayList<Node<E>>(list);
    }
}
