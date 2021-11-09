package LinkedList;

public class LeetcodeQuestions {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseActual(ListNode head, ListNode kPlus1) {
		// TODO Auto-generated method stub

		ListNode prev = null;
		ListNode curr = head;

		while (curr != kPlus1) {
			ListNode currNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = currNext;
		}

		head = prev;
		return head;
	}

	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null) {
			return head;
		}
		ListNode kPlus1 = head;

		for (int i = 0; i < k; i++) {
			if (kPlus1 == null) {
				return head;
			}
			kPlus1 = kPlus1.next;
		}
		ListNode newHead = reverseActual(head, kPlus1);
		System.out.println(head.val);
		head.next = reverseKGroup(kPlus1, k);
		return newHead;
	}
	
	public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode oddHead = head, evenHead = head.next, oddTemp = head, evenTemp = head.next;
        
        while(evenTemp != null && evenTemp.next != null) {
            oddTemp.next = oddTemp.next.next;
            oddTemp = oddTemp.next;
            
            evenTemp.next = evenTemp.next.next;
            evenTemp = evenTemp.next;
        }
        
        oddTemp.next = evenHead;
        return oddHead;
    }
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = head;
		ListNode f = head;
		
		for(int i = 1; i <= n; i++) {
			f = f.next;
		}
        
        if(f == null) {
            return head.next;
        }
        
        while( f.next != null) {
			s = s.next;
			f = f.next;
		}
        
        System.out.println(s.val);
        s.next = s.next.next;
        return head;
    }
	
	public int length(ListNode head) {
        int count = 0;
        
        while(head != null) {
            head = head.next;
            count++;
        }
        
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);
        
        int diff = 0;
        
        ListNode lN1 = null;
        ListNode lN2 = null;
        
        if(l1 >= l2) {
            diff = l1 - l2;
            lN1 = headA;
            lN2 = headB;
        } else {
            diff = l2 - l1;
            
            lN1 = headB;
            lN2 = headA;
        }
        
        while(diff > 0) {
            lN1 = lN1.next;
            diff--;
        }
        while(lN1 != null && lN2 != null) {
            if(lN1 == lN2) {
                return lN1;
            }
            
            lN1 = lN1.next;
            lN2 = lN2.next;
        }
        
        return null;
    }
}
