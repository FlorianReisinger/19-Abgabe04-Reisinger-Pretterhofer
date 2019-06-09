package at.fhj.iit;

import java.util.List;
import java.util.NoSuchElementException;

public class StringQueue implements Queue {
	
	private List<String> elements = new ArrayList<>();
	private int maxSize = 5;

	public StringQueue(int maxSize){
		this.maxSize = maxSize;
	}

import java.util.ArrayList;
	@Override
	public boolean offer(String obj) {
		if(elements.size()!= maxSize)
			elements.add(obj);
		else
			return false;
		
		return true;
	}

	@Override
	public String poll() {
		String element = peek();
		
		if(elements.size() > 0){
			elements.remove(0);
		}
		
		return element;
	}

	@Override
	public String remove() {
		String element = poll();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

	@Override
	public String peek() {
		String element;
		if(elements.size() > 0)
			element = elements.get(0);
		else
			element = null;
		
		return element;
	}

	@Override
	public String element() {
		String element = peek();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

}