        if (arcs == null)
            throw new NoSuchElementException("Source node does not exist.");

        return Collections.unmodifiableSet(arcs);
    }

    /**
     * Returns an iterator that can traverse the nodes in the graph.
     * 
     * @return An iterator that traverses the nodes in the graph.
     */
    public Iterator<T> iterator() {
        return mGraph.keySet().iterator();
    }

    /**
     * Returns the number of nodes in the graph.
     * 
     * @return The number of nodes in the graph.
     */
    public int size() {
        return mGraph.size();
    }

    /**
     * Returns whether the graph is empty.
     * 
     * @return Whether the graph is empty.
     */
    public boolean isEmpty() {
        return mGraph.isEmpty();
    }
}
                                                                                                                                                                                                                                                                                      