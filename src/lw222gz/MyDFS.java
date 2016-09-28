package lw222gz;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.List;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyDFS<E> implements DFS<E> {

    public MyDFS(){

    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        return null;
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        return null;
    }
}
