package edu.monash.fit2099.engine;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range implements Iterable<Integer> {

	private List<Integer> list;

	public Range(int start, int count) {
		list = new ArrayList<Integer>();

		for (int i = start; i < start + count; i++) {
			list.add(i);
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return list.iterator();
	}

	public int min() {
		return list.get(0);
	}

	public int max() {
		return list.get(list.size() - 1);
	}

	public boolean contains(int i) {
		return list.contains(i);
	}

}
