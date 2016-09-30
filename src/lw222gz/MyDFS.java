package lw222gz;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyDFS<E> implements DFS<E> {

    //private List<Node<E>> nodes;
    private int count;
    private final int startCount = 0;
    /**
     * Returns the nodes visited by a depth first search starting from
     * the given root node. Each visited node is also attached with
     * a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
        count = 0;
        dfs(root, nodes);

        return nodes;
    }


    //DFS algorithm
    //@n, node to search from
    //@list, list value that will get the nodes added to the @list param
    private void dfs (Node<E> n, ArrayList<Node<E>> list){

        Iterator it = n.succsOf();

        n.num = count++;
        list.add(n);

        while(it.hasNext()){
            Node node = (Node)it.next();
            if(!list.contains(node)){
                dfs(node, list);
            }
        }
    }

    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
        count = startCount;

        Iterator it = graph.heads();
        while(it.hasNext()){
            dfs((Node)it.next(), nodes);
        }

        return nodes;
    }


    /**
     * Returns a list of nodes ordered as
     * post-order of the depth first tree resulting from a
     * depth first search starting at the given root node.
     * Notice, it only visits nodes reachable from given
     * root node.
     * </p>
     * The algorithm also attaches a post-order number
     * to each visited node.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
        count = startCount;
        postOrder(root, nodes);

        return nodes;
    }

    //Post order algorithm
    //@n, node to search from
    //@list, list value that will get the nodes added to the @list param
    private void postOrder(Node<E> n, ArrayList<Node<E>> list){

        //Mark as visited. (The num value gets a value that it otherwise cannot get.)
        n.num = startCount-1;
        Iterator it = n.succsOf();

        while(it.hasNext()){
            Node node = (Node)it.next();
            if(node.num != startCount-1 && !list.contains(node)){
                postOrder(node, list);
            }
        }

        n.num = count++;
        list.add(n);
    }


    /**
     * Returns a list of ALL nodes in the graph ordered as
     * post-order of the depth first forest resulting from
     * depth first search starting at arbitrary start nodes.
     * </p>
     * The algorithm also attaches a post-order number
     * to each visited node.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
        count = startCount;

        Iterator it = g.heads();
        while(it.hasNext()){
            postOrder((Node)it.next(), nodes);
        }

        return nodes;
    }


    /**
     * Returns a list of ALL nodes in the graph ordered as
     * post-order of the depth first forest resulting from
     * depth first search starting at arbitrary start nodes.
     * </p>
     * The algorithm attaches a depth-first number if <tt>attach_dfs_number</tt>
     * is <tt>true</tt>, otherwise it attaches a post-order number.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
        count = startCount;

        Iterator it = g.heads();

        while(it.hasNext()){
            if(attach_dfs_number){
                dfs((Node)it.next(), nodes);
            }
            else{
                postOrder((Node)it.next(), nodes);
            }
        }

        return nodes;
    }

    /**
     * Returns <tt>true</tt> if the graph contains one or more cycles,
     * otherwise <tt>false</tt>
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {

        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        count = startCount;

        Iterator it = graph.heads();
        while(it.hasNext()){
            postOrder((Node)it.next(), list);
        }

        it = graph.iterator();
        Node a, b;

        while(it.hasNext()){

            a = (Node)it.next();
            Iterator currIt = a.succsOf();
            while(currIt.hasNext()){
                b = (Node)currIt.next();

                if(a.num <= b.num){
                    return true;
                }
            }
        }

        return false;
    }



    /**
     * Returns a list of all nodes in the graph ordered topological.
     * The algorithm assumes that the graph is acyclic. The result for
     * graphs with cycles are undefined.
     */
    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        count = startCount;

        Iterator it = graph.heads();

        while(it.hasNext()){
            Node node = (Node)it.next();
            postOrder(node, list);
        }

        Collections.reverse(list);
        return list;
    }
}
