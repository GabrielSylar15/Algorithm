package main

import (
	"strconv"
)

// ListNode https://leetcode.com/problems/add-two-numbers/description/
type ListNode struct {
	Val  int
	Next *ListNode
}

func AddTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	num1, _ := ParseToNumber(l1)
	num2, _ := ParseToNumber(l2)
	sum := num1 + num2
	return ParseToListNode(sum)
}

func ParseToNumber(l *ListNode) (int64, error) {
	var strNum string
	for l != nil {
		strNum += strconv.Itoa(l.Val)
		l = l.Next
	}
	return strconv.ParseInt(Reverse(strNum), 10, 64)
}

func Reverse(s string) (result string) {
	for _, v := range s {
		result = string(v) + result
	}
	return
}

func ParseToListNode(num int64) *ListNode {
	strNum := strconv.FormatInt(num, 10)
	dummyHead := &ListNode{}
	current := dummyHead

	for i := len(strNum) - 1; i >= 0; i-- {
		digit := int(strNum[i] - '0') // Convert char to int
		current.Next = &ListNode{Val: digit}
		current = current.Next
	}
	return dummyHead.Next
}
