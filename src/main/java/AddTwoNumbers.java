import utility.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode sumList = new ListNode(0);
    ListNode sumListPointer = sumList;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int l1value = (l1 != null) ? l1.val : 0;
      int l2value = (l2 != null) ? l2.val : 0;

      int valSum = l1value + l2value + carry;
      int onesPlaceDigit = valSum % 10;
      carry = valSum / 10;

      ListNode newNode = new ListNode(onesPlaceDigit);
      sumListPointer.next = newNode;
      sumListPointer = sumListPointer.next;

      if (l1 != null) {l1 = l1.next;}
      if (l2 != null) {l2 = l2.next;}
    }

    if (carry == 1) {
      ListNode lastNode = new ListNode(carry);
      sumListPointer.next = lastNode;
    }

    return sumList.next;
  }
}
