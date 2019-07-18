package com.company.collectionExamples;

import java.util.*;

/**
 * @author Wes Lanning
 * @version 2019-07-11
 */
public class Queues
{
    private PriorityQueue<String> priorityQueue    = new PriorityQueue<>();
    private Queue<String>         queue            = new LinkedList<>();
    private LinkedList<String>    linkedList       = new LinkedList<>();
    private Deque<String>    doubleEndedQueue = new ArrayDeque<>();
    private Stack<String>         stack            = new Stack<>();

    /**
     * A queue is just like a line of people at a drive through. The person at the front of the drive through was there first
     * and they are the next to be served. Anyone else must line up behind the person/item/etc at the front.
     *
     * ex (imagine this is a queue where | | contains an item and x,y,z are items): |x|-|y|
     * (queue.add(z)): |x|-|y|-|z| (we added z to the back of the queue)
     * (queue.remove()): |y|-|z| (we removed x from the front of the queue)
     */
    public void regularQueue()
    {
        // the next item added to the queue goes to the back of the line
        queue.add("willy");
        queue.add("butters");
        queue.add("dottie");
        queue.add("kitty");

        // peek checks to see if there is an item at the front of the queue. It does not remove it though, just returns the item.
        if (queue.peek() != null) {
            // removes the first item at the front of the line (like a line of people)
            String willy = queue.remove();
        }


        // poll() is the same as remove(), except that remove() will throw an exception if the queue is empty
        String butters = queue.poll();
        String dottie = queue.remove();
    }

    /**
     * Linked list isn't quite a queue and it's not quite a list. It sort of has properties of both.
     * One can access any element at any item, but to get an element in the middle of the list, it has to iterate to that index
     * instead of just grabbing it right away like an ArrayList or an Array.
     *
     * The advantage of this is that you can remove any element without having to resize the LinkedList (something you have to do for ArrayLists or Arrays)
     *
     * One way to implement a queue is to use a LinkedList (like we did above). A queue is just a special type of linked list
     * where you can only add to the end and remove from the front.
     *
     * Linked lists are really just a bunch of items with one pointing to the next like so:
     * ex: |1|<->|2|<->|3|<->|4|
     *      <----------------->
     * 1 also points to 4 and 4 points to 1
     *
     * Although it's not specified, a linked list in java is a double linked list (current element points to the next, next points to the previous and the next after next)
     */
    public void linkedList()
    {
        linkedList.add("willy");
        linkedList.add("butters");
        linkedList.add("dottie");
        linkedList.add("kitty");

        // under the hood, this will iterate to the index that butters is located
        // then it will remove that node and point the previous node (willy) to the node after butters (dottie)
        // thus, no resizing required, but it does have to loop/iterate over the elements to find them
        linkedList.remove("butters");
        // since we removed butters, position 1 is now dottie
        String dottie = linkedList.get(1);
        linkedList.addLast("doggie");
    }

    /**
     * Deque is a double ended queue (first element points to the next, but the first element also points to the end and the end points to the first)
     * Thus, you can remove from both sides of the queue at once.
     * Since this was implemented as an ArrayDeque, it will grow/shrink by copying elements to a larger/smaller array in a way similar to an ArrayList does.
     *
     * You could also implement this as a LinkedList and will act like a linked list when it comes to growing/shrinking (it won't need to copy elements to a new array, just add/remove an element and re-point to the previous or next node. Which should you use? It depends on whether you need it to act more like an array or more like a linked list.
     *
     * ex: |1|->|2|->|3|->|4|
     *      <----------------->
     * 1 also points to 4 and 4 points to 1
     */
    public void deque()
    {
        doubleEndedQueue.add("willy");
        doubleEndedQueue.add("butters");
        doubleEndedQueue.add("dottie");
        doubleEndedQueue.add("kitty");

        // we can remove from the front or the back in this type of queue
        String willy = doubleEndedQueue.removeFirst();
        String kitty = doubleEndedQueue.removeLast();

        // change the implementation to a linked list instead of an ArrayDeque
        doubleEndedQueue = new LinkedList<>();
        // re add all the elements
        doubleEndedQueue.add("willy");
        doubleEndedQueue.add("butters");
        doubleEndedQueue.add("dottie");
        doubleEndedQueue.add("kitty");

        // works just the same as it did using ArrayDeque
        willy = doubleEndedQueue.removeFirst();
        kitty = doubleEndedQueue.removeLast();
    }

    /**
     * Stacks work just like a stack of dishes
     *
     * The item you last put on top the stack is the next item off the stack.
     * Just like a stack of dishes, right?
     */
    public void stack()
    {
        stack.push("willy");
        stack.push("butters");
        stack.push("dottie");
        stack.push("kitty");

        // removes the last item added
        String kitty = stack.pop();
        String dottie = stack.pop();
    }

    /**
     * Priority queues work just like a regular queue with one difference:
     *
     * The order of the items depends on more than just who lined up first.
     *
     * Instead, the ordering depends on some priority. By default, this is numeric or alphabetical order when dealing with numbers or characters/strings
     *
     * In more complex scenarios, you have to define the ordering by overriding the comparison method in the PriorityQueue class.
     *
     * When would you do this? Maybe you are making a queue of cities to travel to next based off of a predefined starting city. In this case,
     * you might prioritize the cities objects added to the Queue by their distance from your starting point (pretend it's columbus).
     *
     * For cities, the next city out of your queue would be the city closest to columbus.
     *
     * A priority queue handles the ordering for you automatically as items are added/removed, you just have to tell it how to handle custom comparisons for things like our cities example.
     *
     * Another priority queue example might be an emergency room. Just because you show up first to the ER does not mean you will be seen first. Instead,
     * ordering is done by seriousness of the health issue. The more likely a person is to need immediate help, the faster they are seen by the doctor for treatment.
     */
    public void priorityQueue()
    {
        priorityQueue.add("willy");
        priorityQueue.add("butters");
        priorityQueue.add("dottie");
        priorityQueue.add("kitty");

        // butters comes alphabetically before willy, dottie or kitty, so it's the first to be removed
        String butters = priorityQueue.remove();
        // dottie comes next
        String dottie = priorityQueue.remove();

        // lets do a fancier example with our cities:

        PriorityQueue cities

    }

    class City// implements Comparable<City>
    {
        private final String            name;
        private final Map<City, Double> distanceTo = new HashMap<>();

        public City(String name)
        {
            this.name = name;
            // the current city is always 0 miles away from itself
            distanceTo.put(this, 0.0d);
        }
/*
        @Override
        public int compareTo(City city)
        {
            if (!distanceTo.containsKey(city) && !city.distanceTo.containsKey(this)) {
                throw new NoSuchElementException(String.format("%s does not currently have a distance recorded between it and %s", name, city.name));
            }

            if (name.equalsIgnoreCase(city.name) && distanceTo.get(city) == 0.0d) {
                return 0;
            }


            return 1;
        }*/

        public boolean canTravelTo(City city) {
            return distanceTo.containsKey(city) || city.distanceTo.containsKey(this);
        }

        public String getName()
        {
            return name;
        }

        public double getDistanceTo(City city)
        {
            if (distanceTo.containsKey(city)) {
                return distanceTo.get(city);
            }

            if (city.distanceTo.containsKey(this)) {
                return city.distanceTo.get(city);
            }
            // no distance between either city was found
            return -1;
        }

        public void addDistanceTo(City city, double distance)
        {
            distanceTo.put(city, distance);
            // we want both cities to have the distance, just in case only one does
            city.distanceTo.put(this, distance);
        }

/*        @Override
        public boolean equals(Object o)
        {
            if (!(o instanceof City)) {
                return false;
            }
            return compareTo((City) o) == 0;
        }*/
    }

    class CityDistanceComparator implements Comparator<City> {

        @Override
        public int compare(City fromCity, City toCity)
        {
            double distance = fromCity.getDistanceTo(toCity);
            // not finished

            return fromCity.compareTo(toCity);
        }
    }
}
