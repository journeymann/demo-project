package com.demo.facade;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoFacade {

	public static String printList(final List<?> list) {
		return Arrays.toString(list.toArray());
	}
	
	public static <T,R> Set<R> map(final Function<T,R> function, final Set<T> source){

		return source.stream().map(function).collect(Collectors.toCollection(HashSet::new));
	}	
	
    public static <T,S> Set<T> convertSetSubtype(final Set<S> list, final Class<T> klass) {
    	
    	return DemoFacade.map(s -> klass.cast(s), list);
    }
}
