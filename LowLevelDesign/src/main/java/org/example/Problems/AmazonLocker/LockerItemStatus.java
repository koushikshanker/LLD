package org.example.Problems.AmazonLocker;

/**
 * Represents the various states of a locker item.
 */
public enum LockerItemStatus {
    /** Item is not yet processed or assigned */
    IDLE,
    /** Item has been shipped but not yet placed in locker */
    SHIPPED,
    /** Item is securely locked in the locker slot */
    LOCKED,
    /** Item has been picked up by the user */
    DELIVERED,
    /** Item has been returned to the locker or sender */
    RETURNED
}
