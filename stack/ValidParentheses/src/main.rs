fn main() {
	let s = "[]".to_string();
	println!("{}", valid_parentheses(s));
}

fn valid_parentheses(s: String) -> bool {
	let mut stack = Vec::new();
	let pairs = vec![('(', ')'), ('{', '}'), ('[', ']')];

	for ch in s.chars() {
		if pairs.iter().any(|&(open, _)| open == ch ) {
			stack.push(ch);
		}
		if pairs.iter().any(|&(_, close)| close == ch) {
			if stack.is_empty() { return false; }
			if let Some(last) = stack.pop() {
				if !pairs.iter().any(|&(open, close)| open == last && close == ch) {
					return false;
				}
			}
		}
	}
	stack.is_empty()
}

#[cfg(test)]
mod tests {
	use super::*;

	#[test]
	fn test_valid_cases() {
		assert!(valid_parentheses("[]".to_string()));
		assert!(valid_parentheses("{{[]}}".to_string()));
		assert!(valid_parentheses("(){[]}{}".to_string()));
		assert!(valid_parentheses("".to_string()));
		assert!(valid_parentheses("(((())))".to_string()));
	}

	#[test]
	fn test_invalid_cases() {
		assert!(!valid_parentheses("({[]}{}".to_string()));
		assert!(!valid_parentheses("({[)]}{}".to_string()));
		assert!(!valid_parentheses("((".to_string()));
		assert!(!valid_parentheses("))".to_string()));
		assert!(!valid_parentheses("({})}".to_string()));
	}

	#[test]
	fn test_edge_cases() {
		assert!(valid_parentheses("".to_string()));
		assert!(!valid_parentheses("(".to_string()));
		assert!(!valid_parentheses(")".to_string()));
		assert!(!valid_parentheses("[{]".to_string()));
	}
}