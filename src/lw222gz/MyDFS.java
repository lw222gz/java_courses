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
        return dfs(root, new HashSet<Node<E>>());
    }

    //Recursive DFS
    //@node is the node currently being searched
    //@list is the result list of the DFS
    /*private List<Node<E>> dfs(Node<E> node, List<Node<E>> list, HashSet<Node<E>> visited){

        list.add(node);
        visited.add(node);
        node.num = list.size();

        Iterator<Node<E>> it = node.succsOf();
        while(it.hasNext()){
            Node<E> n = it.next();
            if(!visited.contains(n)){
                dfs(n, list, visited);
            }
        }

        return list;
    }*/


    //Overload method for the non-recursive dfs when an existing list wants to be used
    private ArrayList<Node<E>> dfs(Node<E> node, HashSet<Node<E>> visited){
        return dfs(node, visited, new ArrayList<Node<E>>());
    }

    //Returns a dfs list starting the search from Node @node
    //@node - Node that the search starts at
    private ArrayList<Node<E>> dfs(Node<E> node, HashSet<Node<E>> visited, ArrayList<Node<E>> list){
        Stack<Node<E>> nodeStack = new Stack<Node<E>>();
        //LinkedHashSet<Node<E>> nodeQueue = new LinkedHashSet<Node<E>>();
        //http://stackoverflow.com/questions/559839/big-o-summary-for-java-collections-framework-implementations
        //ArrayList<Node<E>> list = list;

        nodeStack.push(node);
        //Non-recursive DFS
        while(!nodeStack.isEmpty()){
            //Pop the first item in the stack
            Node n = nodeStack.pop();
            //If this node has been visited skip this iteration
            if(visited.contains(n)){
                continue;
            }

            //Add the node to the list and set it's num value
            visited.add(n);
            list.add(n);
            n.num = count++;

            //Iterate over the successors and add them to the stack
            Iterator<Node<E>> succs = n.succsOf();
            while(succs.hasNext()){
                //adds the next node to the top of the stack
                nodeStack.push(succs.next());
            }
        }

        return list;
    }


    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();

        //If there exists heads in the current graph
        if(graph.headCount() > 0){
            Iterator<Node<E>> it = graph.heads();
            while(it.hasNext()){
                list = dfs(it.next(), visited, list);
            }
        }
        //Else do a dfs on the top item.
        else{
            Node n = graph.getNodeFor(graph.allItems().get(0));
            if(n != null){
                return dfs(n, visited);
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
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        return postOrder(root, list, visited);
    }

    //Post order algorithm
    //@n, node to search from
    //@list, list value that will get the nodes added to the @list param
    private ArrayList<Node<E>> postOrder(Node<E> n, ArrayList<Node<E>> list, HashSet<Node<E>> visited){

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
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        //If head nodes exists, iterate over those head nodes
        if(g.headCount() > 0){
            Iterator<Node<E>> it = g.heads();
            while(it.hasNext()){
                list = postOrder(it.next(), list, visited);
            }
        }
        //else get a node and do a search on it instead (If no head nodes exist then all nodes are connected through succs).
        else{
            Node n = g.getNodeFor(g.allItems().get(0));
            if(n != null){
                return postOrder(n, list, visited);
            }
        }

        return list;
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
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        if(g.headCount() > 0){
            Iterator<Node<E>> it = g.heads();

            while(it.hasNext()){
                if(attach_dfs_number){
                    list = dfs(it.next(), visited, list);
                }
                else{
                    list = postOrder(it.next(), list, visited);
                }
            }
        }


        return list;
    }

    /**
     * Returns <tt>true</tt> if the graph contains one or more cycles,
     * otherwise <tt>false</tt>
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {

        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        Iterator<Node<E>> it = graph.heads();
        while(it.hasNext()){
            list = postOrder(it.next(), list, visited);
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
        ArrayList<Node<E>> list = new ArrayList<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        count = 0;

        Iterator<Node<E>> it = graph.heads();

        while(it.hasNext()){
            list = postOrder(it.next(), list, visited);
        }

        //topSort is a reversed post order
        Collections.reverse(list);
        return list;
    }
}
