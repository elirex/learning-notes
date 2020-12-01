package com.elirex.algorithm

/**
 * The Bag class represents a multiset of generic items.
 *
 * References
 * <a href="https://en.wikipedia.org/wiki/Multiset">Multiset</a>
 * <a href="https://www.quora.com/What-are-bags-in-a-data-structure">What are bags in a data structure?</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/26.
 */
class Bag<Item> : Iterable<Item> {
    // Beginning of bag
    private var head: Node<Item>? = null

    // The number of elements in this bag
    private var _size: Int = 0

    /**
     * Returns true if this bag is empty.
     *
     * @return true if this bag is empty; false otherwise
     */
    val isEmpty: Boolean
        get() = head == null

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    val size: Int
        get() = _size

    /**
     * Adds the item to this bag.
     *
     * @param item to add to this bag
     */
    fun add(item: Item) {
        head = Node(item, head)
        _size++
    }

    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    override fun iterator(): Iterator<Item> = LinkedIterator(head)


    // Internal linked list class
    private data class Node<Item>(var item: Item, var next: Node<Item>? = null)

    // Internal linked list iterator
    private class LinkedIterator<Item>(private var current: Node<Item>?) : Iterator<Item> {

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): Item {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val item = current!!.item
            current = current!!.next
            return item
        }
    }
}

fun main(args: Array<String>) {
    val bag: Bag<String> = Bag()

    val items = "ABCEDFGHIJKLMNOPQRSTUVWXYZ"
    items.toCharArray().forEach {
        bag.add(it.toString())
    }

    println("Bag size = ${bag.size}")
    bag.forEach {
        println(it)
    }
}
