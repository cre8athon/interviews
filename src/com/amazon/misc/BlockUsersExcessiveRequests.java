package com.amazon.misc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by gnowakow on 9/15/16.
 */
public class BlockUsersExcessiveRequests {

    private static final int REQUEST_WINDOW = 5;
    private static final int MAX_REQUESTS = 10;
    private Node head;

    public BlockUsersExcessiveRequests() {

        // Build doubly linked, circular list of nodes (one for each minute in the window)
        Node prevNode = null;
        for( int ctr = 0; ctr < REQUEST_WINDOW; ctr++) {
            Node newNode = new Node();

            if( head == null ) {
                head = newNode;
            } else {
                prevNode.setNext(newNode);
                newNode.setPrev(newNode);
            }
            prevNode = newNode;
        }
        head.setNext(prevNode);
        prevNode.setPrev(head);
    }

    private void adjustQueue(long minutes) {
        if( minutes <= 1 ) {
            return;
        }

        Node curr = head;
        for( int ctr = 0; ctr < minutes; ctr++ ) {
            curr.clear();
            curr = curr.getPrev();
        }

        head = curr;
    }

    private int countRequests(int userId) {
        int count = 0;
        Node curr = head;
        do {
            if( curr.getRequestsPerUser().containsKey(userId) ) {
                count += curr.getRequestsPerUser().get(userId).size();
            }
            curr = curr.getNext();
        } while( curr != head);

        return count;
    }

    public boolean blockUser(int userId) {
        Date now = new Date();
        long elapsedMinutes = (now.getTime() - head.getLatest().getTime()) % 60000;
        adjustQueue(elapsedMinutes);

        if( head.getRequestsPerUser().containsKey(userId) ) {
            head.getRequestsPerUser().get(userId).add(now);
        } else {
            List<Date> requests = new ArrayList<>();
            requests.add(now);
            head.getRequestsPerUser().put(userId, requests);
        }
        return countRequests(userId) > MAX_REQUESTS;
    }
}

class Node {
    private Node next;
    private Node prev;
    private Date latest;
    private Map<Integer, List<Date>> requestsPerUser;

    public Node getNext() {
        return next;
    }

    public void clear() {
        requestsPerUser = new HashMap<>();
    }

    public Node setNext(final Node next) {
        this.next = next;
        return this;
    }

    public Node getPrev() {
        return prev;
    }

    public Node setPrev(final Node prev) {
        this.prev = prev;
        return this;
    }

    public Date getLatest() {
        return latest;
    }

    public Node setLatest(final Date latest) {
        this.latest = latest;
        return this;
    }

    public Map<Integer, List<Date>> getRequestsPerUser() {
        return requestsPerUser;
    }

    public Node setRequestsPerUser(final Map<Integer, List<Date>> requestsPerUser) {
        this.requestsPerUser = requestsPerUser;
        return this;
    }
}