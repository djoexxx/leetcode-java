import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ListNode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddTwoNumbersTests extends AddTwoNumbers {

  @Test(dataProvider = "Add Two Numbers Data")
  public void addTwoNumbersTest(ListNode listNode1, ListNode listNode2, ListNode expected) {
    ListNode result = addTwoNumbers(listNode1, listNode2);

    ListNode resultPointer = result;
    ListNode expectedPointer = expected;
    do {
      assertThat(resultPointer.val)
          .as(
              "Result value "
                  + resultPointer.val
                  + " does not match expected "
                  + expectedPointer.val)
          .isEqualTo(expectedPointer.val);

      if (resultPointer != null && expectedPointer != null) {
        resultPointer = resultPointer.next;
        expectedPointer = expectedPointer.next;
      }
    } while (resultPointer != null && expected != null);
  }

  /**
   * Recursively build linked list of ListNodes
   *
   * @param values (int[]) int array to generate ListNode
   * @param head (int) index to set as the head value for linked list
   * @param tail (int) index to set as the final node
   * @return (ListNode)
   */
  private ListNode createListNode(int[] values, int head, int tail) {
    if (head == tail) {
      return new ListNode(values[tail]);
    } else {
      return new ListNode(values[head], createListNode(values, head + 1, tail));
    }
  }

  @DataProvider(name = "Add Two Numbers Data")
  public Object[][] addTwoNumbersData() {
    return new Object[][] {
      {
        createListNode(new int[] {2, 4, 3}, 0, 2),
        createListNode(new int[] {5, 6, 4}, 0, 2),
        createListNode(new int[] {7, 0, 8}, 0, 2)
      },
      {new ListNode(0), new ListNode(0), new ListNode(0)},
      {
        createListNode(new int[] {9, 9, 9, 9, 9, 9, 9}, 0, 6),
        createListNode(new int[] {9, 9, 9, 9}, 0, 3),
        createListNode(new int[] {8, 9, 9, 9, 0, 0, 0, 1}, 0, 7)
      }
    };
  }
}
