// Hash code has to be consistent

// If we override equals() we have to override hashCode()

public int hashCode() {
	return 1;
}

// a.hashCode() == b.hashCode() when a.equals(b)

// Also legal for a.hashCode() == b.hashCode() when !a.equals(b)