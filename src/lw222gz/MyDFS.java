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
        return new ArrayList<Node<E>>(dfs(root, new LinkedHashSet<Node<E>>()));
    }

    private LinkedHashSet<Node<E>> dfs(Node<E> node, LinkedHashSet<Node<E>> list){
        //--ASSIGNMENT 3 DFS--
        //O(N + E) Where N is the amount of nodes that can be reached from @root by successors, E is the amount of edges
        //Motivation: the loop length is determined by the amount of nodes that can be reached through successors
        //And the edges found between those nodes
        //--ASSIGNMENT 3 DFS--
        list.add(node);
        node.num = list.size();

        Iterator<Node<E>> it = node.succsOf();
        while(it.hasNext()){
            Node<E> n = it.next();
            if(!list.contains(n)){
                dfs(n, list);
            }
        }

        return list;
    }


    //Returns a dfs list starting the search from Node @node
    //@node - Node that the search starts at
    /*private HashSet<Node<E>> non_recursive_dfs(Node<E> node){



        Stack<Node<E>> nodeStack = new Stack<Node<E>>();

        LinkedHashSet<Node<E>> nodeList = new LinkedHashSet<Node<E>>();

        nodeStack.push(node);
        //Non-recursive DFS
        while(!nodeStack.isEmpty()){
            //Pop the first item in the stack
            Node n = nodeStack.pop();
            //If this node has been visited skip this iteration
            if(nodeList.contains(n)){
                continue;
            }

            //Add the node to the list and set it's num value
            nodeList.add(n);
            n.num = count++;

            //Iterate over the successors and add them to the stack
            Iterator<Node<E>> succs = n.succsOf();
            while(succs.hasNext()){
                //adds the next node to the top of the stack
                nodeStack.push(succs.next());
            }
        }

        return nodeList;

    }*/


    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        LinkedHashSet<Node<E>> nodes = new LinkedHashSet<Node<E>>();
        count = 0;
        LinkedHashSet<Node<E>> list = new LinkedHashSet<Node<E>>();

        //If there exists heads in the current graph
        if(graph.headCount() > 0){
            Iterator<Node<E>> it = graph.heads();
            while(it.hasNext()){
                list.addAll(dfs(it.next(), list));
            }
        }
        //Else do a dfs on the top item.
        else{
            Node n = graph.getNodeFor(graph.allItems().get(0));
            if(n != null){
                list = dfs(n, list);
            }
        }

        return new ArrayList<Node<E>>(list);
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
    private LinkedHashSet<Node<E>> postOrder(Node<E> n, LinkedHashSet<Node<E>> list, HashSet<Node<E>> visited){

        //Mark as visited.
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

        return list;
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

        //If head nodes exists, iterate over those head nodes
        if(g.headCount() > 0){
            Iterator<Node<E>> it = g.heads();
            while(it.hasNext()){
                nodes.addAll(postOrder(it.next(), new LinkedHashSet<Node<E>>(), visited));
            }
        }
        //else get a node and do a search on it instead (If no head nodes exist then all nodes are connected through succs).
        else{
            Node n = g.getNodeFor(g.allItems().get(0));
            if(n != null){
                nodes = postOrder(n, new LinkedHashSet<Node<E>>(), visited);
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
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        if(g.headCount() > 0){
            Iterator<Node<E>> it = g.heads();

            while(it.hasNext()){
                if(attach_dfs_number){
                    nodes.addAll(dfs(it.next(), new LinkedHashSet<Node<E>>()));
                }
                else{
                    nodes.addAll(postOrder(it.next(), new LinkedHashSet<Node<E>>(), visited));
                }
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
            list.addAll(postOrder(it.next(), new LinkedHashSet<Node<E>>(), visited));
        }

        it = graph.iterator();
        Node a, b;

        while(it.hasNext()){

            a = it.next();
            Iterator<Node<E>> succs = a.succsOf();
            while(succs.hasNext()){
                b = succs.next();
                //If the node being iterated over (a) has a succsessor (b) with a bigger num value, then the graph is cyclic
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
            list.addAll(postOrder(it.next(), new LinkedHashSet<Node<E>>(), visited));
        }

        //topSort is a reversed post order
        ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>(list);
        Collections.reverse(nodeList);
        return nodeList;
    }
}
