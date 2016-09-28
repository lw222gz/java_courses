package lw222gz;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        return null;
    }
}
