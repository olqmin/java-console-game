package com.pure.academy.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ShuffelHelper {

	public static <T> Set<T> newShuffledSet(Collection<T> collection) {
	    List<T> shuffleMe = new ArrayList<T>(collection);
	    Collections.shuffle(shuffleMe);
	    return new LinkedHashSet<T>(shuffleMe);
	}
	
	public static <T> List<T> newShuffledList(Collection<T> collection) {
	    List<T> shuffleMe = new ArrayList<T>(collection);
	    Collections.shuffle(shuffleMe);
	    return shuffleMe;
	}
}
