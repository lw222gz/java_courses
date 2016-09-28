package lw222gz;

import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyNode<E> extends Node<E> {

    private Set<Node<E>> preds = new HashSet<Node<E>>();
    private Set<Node<E>> succs = new HashSet<Node<E>>();


    protected MyNode(E item) {
        super(item);
    }

    /**
     * Returns <tt>true</tt> if <tt>this</tt> node has <tt>node</tt> as successor,
     * otherwise <tt>false</tt>.
     * @param a possible successor node
     * @return boolean
     */
    @Override
    public boolean hasSucc(Node node){
        return succs.contains(node);
    }

    /**
     * Returns the number of successors (i.e. outgoing edges)
     * of this node.
     * @return node out-degree
     */
    @Override
    public int outDegree(){
        return succs.size();
    }

    /**
     * Returns an iterator over all successor nodes.
     * @return successor node iterator
     */
    @Override
    public Iterator<Node<E>> succsOf(){
        return succs.iterator();
    }

    /**
     * Returns <tt>true</tt> if <tt>this</tt> node has <tt>node</tt> as predecessor,
     * otherwise <tt>false</tt>.
     * @param a possible predecessor node
     * @return boolean
     */
    @Override
    public boolean hasPred(Node node){
        return preds.contains(node);
    }

    /**
     * Returns the number of predecessors  (i.e. incoming edges)
     * of this node.
     * @return node out-degree
     */
    public int inDegree(){
        return preds.size();
    }

    /**
     * Returns an iterator over all predecessor nodes.
     * @return predecessor node iterator
     */
    public Iterator<Node<E>> predsOf(){
        return preds.iterator();
    }


    @Override
    protected void addSucc(Node succ){
        succs.add(succ);
    }
    /**
     * Removes node <tt>succ</tt> as a successor to <tt>this</tt> node.
     */
    @Override
    protected void removeSucc(Node succ){
        succs.remove(succ);
    }
    /**
     * Adds node <tt>pred</tt> as a predecessor to <tt>this</tt> node.
     */
    @Override
    protected void addPred(Node pred){
        preds.add(pred);
    }
    /**
     * Removes node <tt>pred</tt> as a predecessor to <tt>this</tt> node.
     */
    @Override
    protected void removePred(Node pred){
        preds.remove(pred);
    }
    /**
     * Disconnects this node from all adjacent nodes. That is, removes all successor,
     * and predecessor, nodes to <tt>this</tt> node.
     */
    protected void disconnect(){
        //TODO: remove connections to this node.
        for(Node n : preds){
            MyNode node = (MyNode)n;
            node.removeSucc(this);
        }
        for(Node n : succs){
            MyNode node = (MyNode)n;
            node.removePred(this);
        }
        preds.clear();
        succs.clear();
    }
}
