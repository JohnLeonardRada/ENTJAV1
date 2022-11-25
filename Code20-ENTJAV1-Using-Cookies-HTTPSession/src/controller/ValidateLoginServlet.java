package com.opensymphony.xwork2.config.providers;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class DirectedGraph<T> implements Iterable<T> {
    private final Map<T, Set<T>> mGraph = new HashMap<T, Set<T>>();

    /**
     * Adds a new node to the graph. If the node already exists, this function is a no-op.
     * 
     * @param node
     *            The node to add.
     * @return Whether or not the node was added.
     */
    public boolean addNode(T node) {
        /* If the node already exists, don't do anything. */
        if (mGraph.containsKey(node))
            return false;

        /* Otherwise, add the node with an empty set of outgoing edges. */
        mGraph.put(node, new HashSet<T>());
        return true;
    }

    /**
     * Given a start node, and a destination, adds an arc from the start node to the destination. If an arc already exists, this operation is a no-op.
     * If either endpoint does not exist in the graph, throws a NoSuchElementException.
     * 
     * @param start
     *            The start node.
     * @param dest
     *            The destination node.
     * @throws NoSuchElementException
     *             If either the start or destination nodes do not exist.
     */
    public void addEdge(T start, T dest) {
        /* Confirm both endpoints exist. */
        if (!mGraph.containsKey(start)) {
            throw new NoSuchElementException("The start node does not exist in the graph.");
        } else if (!mGraph.containsKey(dest)) {
            throw new NoSuchElementException("The destination node does not exist in the graph.");
        }

        /* Add the edge. */
        mGraph.get(start).add(dest);
    }

    /**
     * Removes the edge from start to dest from the graph. If the edge does not exist, this operation is a no-op. If either endpoint does not exist,
     * this throws a NoSuchElementException.
     * 
     * @param start
     *            The start node.
     * @param dest
     *            The destination node.
     * @throws NoSuchElementException
   