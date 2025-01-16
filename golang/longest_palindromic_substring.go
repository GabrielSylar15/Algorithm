package main

// ppabcdefgfedcbatayyy
// yyyatabcdefgfedcbapp -> ppabcdefgfedcbatayyy
//
// babad -> dabab
// cbbd -> dbbc
func LongestPalindrome(s string) string {
	var result string
	maxLength := 0
	for i := 0; i < len(s); i++ {
		temp := compare(s[i:], maxLength)
		if len(temp) > maxLength {
			maxLength = len(temp)
			result = temp
		}
	}
	return result
}

func compare(s string, maxLength int) string {
	if len(s) == 1 {
		return s
	}
	if len(s) < maxLength {
		return ""
	}
	if maxLength == 0 {
		maxLength = 2
	}
	var temp string
	for i := maxLength; i < len(s)+1; i++ {
		if s[0:i] == reverseString(s[0:i]) {
			temp = s[0:i]
		}
	}
	return temp
}

func reverseString(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}
