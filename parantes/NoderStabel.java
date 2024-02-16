package parantes;

import java.util.EmptyStackException;


public class NoderStabel<T> implements StabelADT<T> {
	private Node topNode;

	public NoderStabel() {
		topNode = null;
	}

	@Override
	public void push(T newEntry) {
		topNode = new Node(newEntry, topNode);
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return topNode.data;
	}

	@Override
	public T pop() {
		T top = peek();
		topNode = topNode.neste;
		return top;
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void clear() {
		topNode = null;
	}
	
	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this(data, null);
		}

		private Node(T data, Node neste) {
			this.data = data;
			this.neste = neste;
		}
	}
}
