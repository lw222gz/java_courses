package lw222gz;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyBFS<E> implements BFS<E> {

    private final int startCount = 0;
    private int count;




    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        LinkedHashSet<Node<E>> init = new LinkedHashSet<Node<E>>();
        ArrayList<Node<E>> marked = new ArrayList<Node<E>>();

        init.add(root);
        count = startCount;
        marked.add(root);
        root.num = count++;
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        bfs(init, list, marked);

        return list;
    }


    //Algorithm for breadth-first search
    //@nodeSet is the set of nodes of the current level of the graph
    //@list is the list the nodes are being added into
    //@marked is the list containing all of the marked nodes.
    private void bfs(LinkedHashSet<Node<E>> nodeSet, ArrayList<Node<E>> list, ArrayList<Node<E>> marked){
        Iterator it = nodeSet.iterator();

        LinkedHashSet<Node<E>> set = new LinkedHashSet<Node<E>>();


        while(it.hasNext()){
            Node n = (Node)it.next();
            list.add(n);

            Iterator succIt = n.succsOf();
            while(succIt.hasNext()){

                Node node = (Node)succIt.next();

                if(!marked.contains(node)){
                    marked.add(node);
                    node.num = count++;
                    set.add(node);
                }
            }
        }

        if(set.size() == 0){
            return;
        }
        bfs(set, list, marked);

    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        LinkedHashSet<Node<E>> init = new LinkedHashSet<Node<E>>();
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        ArrayList<Node<E>> marked = new ArrayList<Node<E>>();
        count = startCount;

        Iterator it = graph.heads();

        while(it.hasNext()){
            Node n = (Node)it.next();

            marked.add(n);
            n.num = count++;
            init.add(n);

            bfs(init, list, marked);

            init = new LinkedHashSet<Node<E>>();
        }

        return list;
    }
}
