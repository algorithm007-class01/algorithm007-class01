package G20200343040039

import "math"

type Automaton struct {
	state string
	table map[string][4]string
	sign int
	ans int
}

func NewAutomaton() *Automaton {
	return &Automaton{
		state: "start",
		table: map[string][4]string{
			"start":{"start", "signed", "in_number", "end"},
			"signed":{"end", "end", "in_number", "end"},
			"in_number":{"end", "end", "in_number", "end"},
			"end":{"end", "end", "end", "end"},
		},
		sign: 1,
		ans: 0,
	}
}

func (automaton *Automaton) get_col(c byte) int {
	if c == ' ' {
		return 0
	}

	if c == '+' || c == '-' {
		return 1
	}

	if c >= '0' && c <= '9' {
		return 2
	}

	return 3
}

func (automaton *Automaton) get(c byte)  {

	automaton.state = automaton.table[automaton.state][automaton.get_col(c)]

	if automaton.state == "in_number" {
		automaton.ans = automaton.ans * 10 + int(c - '0')
		if automaton.sign == 1 {
			automaton.ans = int(math.Min(float64(automaton.ans), math.MaxInt32))
		} else {
			automaton.ans = int(math.Min(float64(automaton.ans), -math.MinInt32))
		}
	} else if automaton.state == "signed" {
		if c == '+' {
			automaton.sign = 1
		} else {
			automaton.sign = -1
		}
	}
}

func myAtoi(str string) int {
	automation := NewAutomaton()
	for i := 0; i < len(str); i++ {
		automation.get(str[i])
	}

	return automation.sign * automation.ans
}