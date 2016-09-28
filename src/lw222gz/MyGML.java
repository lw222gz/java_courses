package lw222gz;

import graphs.DirectedGraph;
import graphs.GML;

/**
 * Created by Lucas on 2016-09-28.
 */
public class MyGML<E> extends GML<E> {


    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        return null;
    }
}
