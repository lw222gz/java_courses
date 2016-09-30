package lw222gz;

import graphs.DirectedGraph;
import graphs.Node;


import java.util.*;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyGraph<E> implements DirectedGraph<E> {

    private Map<E, MyNode<E>> item2node;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;


    public MyGraph(){
        item2node = new HashMap<E, MyNode<E>>();
        heads = new HashSet<Node<E>>();
        tails = new HashSet<Node<E>>();
    }


    //Creates and returnes a node with @item as value
    //if @item is null an exception is thrown
    //returns the node created that represents value @item.
    @Override
    public MyNode<E> addNodeFor(E item) {
        if(item == null){
            throw new NullPointerException("Received null as value.");
        }

        //if the node exists, return the existing node
        if(containsNodeFor(item)){
            return item2node.get(item);
        }
        //Else it will be added
        MyNode n = new MyNode(item);
        item2node.put(item, n);
        heads.add(n);
        tails.add(n);
        return n;
    }

    //returns a node based on @item value
    //If @item is null an error is thrown
    //If item is not found an exception is thrown
    @Override
    public MyNode<E> getNodeFor(E item) {
        if(item == null){
            throw new NullPointerException("Received null as value.");
        }

        if(item2node.containsKey(item)){
            return item2node.get(item);
        }
        else{
            throw new NoSuchElementException("Element not found.");
        }
    }

    //Adds an edge between @from and @to
    //If either values are null an exception is thrown
    //returns true if the edge is created, otherwise false.
    @Override
    public boolean addEdgeFor(E from, E to) {
        if(from == null || to == null){
            throw new NullPointerException("Received null as value.");
        }

        MyNode src = addNodeFor(from);
        MyNode tgt = addNodeFor(to);

        if(src.hasSucc(tgt)){
            return false;
        }

        src.addSucc(tgt);
        tgt.addPred(src);

        tails.remove(src);
        heads.remove(tgt);

        return true;
    }

    //TODO: are we supposed to use .equals / .hashcode to check
    @Override
    public boolean containsNodeFor(E item) {
        if(item == null){
            throw new NullPointerException("Received null as value.");
        }
        return item2node.containsKey(item);
    }

    //Returns amount of current nodes
    @Override
    public int nodeCount() {
        return item2node.size();
    }

    //Returns an iterator of the nodes
    @Override
    public Iterator<Node<E>> iterator() {
        return new ArrayList<Node<E>>(item2node.values()).iterator();
    }


    //Returns an iterator for the heads
    @Override
    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    //Returns amount of heads
    @Override
    public int headCount() {
        return heads.size();
    }

    //Returns tails iterator
    @Override
    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    //Returns amount of tails
    @Override
    public int tailCount() {
        return tails.size();
    }

    //Returns a list of all values
    @Override
    public List<E> allItems() {
        return new ArrayList(item2node.keySet());
    }


    //Returns an integer representing the amount of edges in the graph
    @Override
    public int edgeCount() {
        int count = 0;

        for(MyNode n : item2node.values()){
            count += n.inDegree();
        }

        return count;
    }

    //Removes a node from the graph with the value of @item
    @Override
    public void removeNodeFor(E item) {
        if(item == null || !containsNodeFor(item)){
            throw new RuntimeException("Given value was null or not found.");
        }

        //Removes the node and all of its connections
        MyNode n = item2node.get(item);
        n.disconnect();
        if(n.isHead()){
            heads.remove(n);
        }
        if(n.isTail()){
            tails.remove(n);
        }

        item2node.remove(item);
    }

    //Checks if there is an edge between @from and @to,
    //if either values are null an exception is thrown.
    //If an edge between the 2 values is found true is returned, otherwise false.
    @Override
    public boolean containsEdgeFor(E from, E to) {
        if(from == null || to == null){
            throw new NullPointerException("Given was null.");
        }

        if(containsNodeFor(from) && containsNodeFor(to)){
            MyNode src = getNodeFor(from);
            MyNode tgt = getNodeFor(to);

            return src.hasSucc(tgt);
        }

        return false;
    }


    //Removes an edge that goes @from -> @to
    //If the edge is not found
    @Override
    public boolean removeEdgeFor(E from, E to) {
        if(from == null || to == null){
            throw new NullPointerException("Received null as value.");
        }
        else if(!containsNodeFor(from) || !containsNodeFor(to)){
            return false;
        }


        MyNode src = getNodeFor(from);
        MyNode tgt = getNodeFor(to);

        if(src.hasSucc(tgt)){
            src.removeSucc(tgt);
            tgt.removePred(src);

            //If src has no more outgoing it's a tail
            if(src.outDegree() == 0){
                tails.add(src);
            }
            //If the tgt has no more incoming edges it's a head
            if(tgt.inDegree() == 0){
                heads.add(tgt);
            }

            return true;
        }
        return false;

    }

    //Returns a string representation of the graph
    @Override
    public String toString() {
        String str = "graph [\n";

        Iterator it = iterator();

        //Node display
        while(it.hasNext()){
            Node n = (Node)it.next();

            str += "\n\tnode [";
            str += "\n\t\tid " + n;
            //str += "\n\t\tlabel node_" + n;
            str += "\n\t]";
        }

        //Edge display

        it = iterator();

        while(it.hasNext()){
            Node n = (Node)it.next();

            Iterator succsIt = n.succsOf();
            while(succsIt.hasNext()){
                Node succN = (Node)succsIt.next();

                str += "\n\tedge [";
                str += "\n\t\tsource " + n;
                str += "\n\t\ttarget " + succN;
                str += "\n\t\tlabel \"Edge from node " + n + " to node " + succN + " \"";
                str += "\n\t]";
            }
        }

        str += "\n]";

        return str;
    }
}
