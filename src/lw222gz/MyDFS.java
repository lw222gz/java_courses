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
    /**
     * Returns the nodes visited by a depth first search starting from
     * the given root node. Each visited node is also attached with
     * a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {

        count = 0;
        return dfs(root);
    }


    //Returns a dfs list starting the search from Node @node
    //@node - Node that the search starts at
    private List<Node<E>> dfs(Node<E> node){
        Stack<Node<E>> nodeStack = new Stack<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();

        ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>();

        nodeStack.push(node);

        while(!nodeStack.isEmpty()){
            Node n = nodeStack.pop();
            if(visited.contains(n)){
                continue;
            }
            visited.add(n);
            n.num = count++;
            nodeList.add(n);

            Iterator<Node<E>> succs = n.succsOf();
            while(succs.hasNext()){
                nodeStack.push(succs.next());
            }
        }

        return nodeList;

    }


    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        LinkedHashSet<Node<E>> nodes = new LinkedHashSet<Node<E>>();
        count = 0;
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();

        //If there exists heads in the current graph
        if(graph.headCount() > 0){
            Iterator<Node<E>> it = graph.heads();
            while(it.hasNext()){
                list.addAll(dfs(it.next()));
            }
        }
        //Else do a dfs on the top item.
        else{
            Node n = graph.getNodeFor(graph.allItems().get(0));
            if(n != null){
                return (dfs(n));
            }
        }

        return list;
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
        LinkedHashSet<Node<E>> nodes = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;
        postOrder(root, nodes, visited);

        return new ArrayList<Node<E>>(nodes);
    }

    //Post order algorithm
    //@n, node to search from
    //@list, list value that will get the nodes added to the @list param
    private void postOrder(Node<E> n, LinkedHashSet<Node<E>> list, HashSet<Node<E>> visited){

        //Mark as visited. (The num value gets a value that it otherwise cannot get.)
        //n.num = -1;
        visited.add(n);
        Iterator<Node<E>> it = n.succsOf();

        while(it.hasNext()){

            Node node = it.next();

            if(!visited.contains(node) && !list.contains(node)){
                postOrder(node, list, visited);
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
        LinkedHashSet<Node<E>> nodes = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        if(g.headCount() >0){
            Iterator<Node<E>> it = g.heads();
            while(it.hasNext()){
                postOrder(it.next(), nodes, visited);
            }
        }
        else{
            Node n = g.getNodeFor(g.allItems().get(0));
            if(n != null){
                postOrder(n, nodes, visited);
            }
        }


        return new ArrayList<Node<E>>(nodes);
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
        LinkedHashSet<Node<E>> nodes = new LinkedHashSet<Node<E>>();
        //ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        Iterator<Node<E>> it = g.heads();

        while(it.hasNext()){
            if(attach_dfs_number){
                nodes.addAll(dfs(it.next()));
            }
            else{
                postOrder(it.next(), nodes, visited);
            }
        }

        return new ArrayList<Node<E>>(nodes);
    }

    /**
     * Returns <tt>true</tt> if the graph contains one or more cycles,
     * otherwise <tt>false</tt>
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {

        LinkedHashSet<Node<E>> list = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        Iterator<Node<E>> it = graph.heads();
        while(it.hasNext()){
            postOrder(it.next(), list, visited);
        }

        it = graph.iterator();
        Node a, b;

        while(it.hasNext()){

            a = it.next();
            Iterator<Node<E>> currIt = a.succsOf();
            while(currIt.hasNext()){
                b = currIt.next();

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
        LinkedHashSet<Node<E>> list = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        Iterator<Node<E>> it = graph.heads();

        while(it.hasNext()){
            Node node = it.next();
            postOrder(node, list, visited);
        }

        //Collections.reverse(list);
        ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>(list);
        Collections.reverse(nodeList);
        return nodeList;
    }
}
