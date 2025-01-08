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

func AddTwoNumbersV2(l1 *ListNode, l2 *ListNode) *ListNode {
	result := &ListNode{
		Val: 0,
	}
	flag := false
	for l1 != nil || l2 != nil {
		sum := 0
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		if flag {
			sum += 1
		}
		if sum > 9 {
			flag = true
			appendNodeList(sum%10, result)
		} else {
			flag = false
			appendNodeList(sum, result)
		}
	}
	if flag {
		appendNodeList(1, result)
	}
	return result.Next
}

func appendNodeList(num int, l *ListNode) *ListNode {
	for l.Next != nil {
		l = l.Next
	}
	l.Next = &ListNode{
		Val: num,
	}
	return l
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
