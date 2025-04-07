package utility;

/**
 * The class provided in the leetcode comment does not work as written.  In order
 * for the accepted solution to work, I needed to specify all variables and methods
 * as public.  Original comment version had everything defaulting to private.  This
 * is not how I would have created this class, but leetcode questions are interview
 * standard right?
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
