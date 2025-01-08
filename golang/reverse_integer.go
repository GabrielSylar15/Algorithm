package main

import "strconv"

// 120
func reverse(x int) int {
	var t string
	if x < 0 {
		t = strconv.Itoa(-x)
	} else {
		t = strconv.Itoa(x)
	}
	var str string
	if t[len(t)-1] != '0' {
		str += string(t[len(t)-1])
	}
	for i := len(t) - 2; i >= 0; i-- {
		str += string(t[i])
	}
	result, _ := strconv.Atoi(str)
	if x < 0 {
		return -result
	}
	return result
}
