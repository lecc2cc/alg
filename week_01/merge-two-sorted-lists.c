

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if (l1 == NULL && l2 == NULL) {
		return NULL;
	}
	// 保护节点
	struct ListNode* head = malloc(sizeof(struct ListNode));
	head->next = NULL;

	struct ListNode* p = head;
	struct ListNode* p1 = l1;
	struct ListNode* p2 = l2;
	while (p1 != NULL && p2 != NULL) {
		if (p1->val < p2->val) {
			p->next = p1;
			p = p1;
			p1 = p1->next;
		} else {
			p->next = p2;
			p = p2;
			p2 = p2->next;
		}

	}
	while(p1 != NULL) {
		p->next = p1;
		p = p1;
		p1 = p1->next;
	}
	while(p2 != NULL) {
		p->next = p2;
		p = p2;
		p2 = p2->next;
	}



	return head->next;
}
