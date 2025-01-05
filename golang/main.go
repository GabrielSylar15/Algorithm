package main

import "fmt"

// TIP <p>To run your code, right-click the code and select <b>Run</b>.</p> <p>Alternatively, click
// the <icon src="AllIcons.Actions.Execute"/> icon in the gutter and select the <b>Run</b> menu item from here.</p>
func ArrayToListNode(arr []int) *ListNode {
	// Khởi tạo dummy node
	dummyHead := &ListNode{}
	current := dummyHead

	// Lặp qua mảng và tạo các ListNode
	for _, val := range arr {
		// Tạo node mới với giá trị val
		current.Next = &ListNode{Val: val}
		// Di chuyển con trỏ current tới node vừa tạo
		current = current.Next
	}

	// Trả về head của danh sách liên kết (bỏ dummy node)
	return dummyHead.Next
}

// Hàm in ra danh sách liên kết
func PrintListNode(head *ListNode) {
	for head != nil {
		fmt.Print(head.Val, " ")
		head = head.Next
	}
	fmt.Println()
}

func main() {
	l1 := ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 0,
			Next: &ListNode{
				Val: 0,
				Next: &ListNode{
					Val: 0,
					Next: &ListNode{
						Val: 1,
					},
				},
			},
		},
	}

	l2 := ListNode{
		Val: 5,
		Next: &ListNode{
			Val: 6,
			Next: &ListNode{
				Val: 4,
			},
		},
	}

	//arr := []int{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}

	//head := ArrayToListNode(arr)
	fmt.Println(ParseToNumber(AddTwoNumbers(&l1, &l2)))
}
