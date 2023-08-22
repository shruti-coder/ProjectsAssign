//import java.util.*;
	class item {
		  private int current = 0;

		  private int size = 3;

		  private int grow = 2;

		  private int place = 0;

		  private Object[] elements = null;

		  private Object[] tmpElements = null;

		  public item() {
		    init();
		  }

		  public item(int size) {
		    setSize(size);
		    init();
		  }

		  public item(int size, int grow) {
		    setSize(size);
		    setGrow(grow);
		    init();
		  }

		  private void init() {
		    elements = new Object[size];
		  }

		  public Object nextElement() throws Exception {
		    if (elements[place] != null && place != current) {
		      place++;
		      return elements[place - 1];
		    } else {
		      place = 0;
		      throw new java.util.NoSuchElementException();
		    }
		  }

		  
		  public void setSize(int size) {
		    this.size = size;
		  }

		  public int getCurrentSize() {
		    return current;
		  }

		  public void rehash() {
		    tmpElements = new Object[size];
		    int count = 0;
		    for (int x = 0; x < elements.length; x++) {
		      if (elements[x] != null) {
		        tmpElements[count] = elements[x];
		        count++;
		      }
		    }
		    elements = (Object[]) tmpElements.clone();
		    tmpElements = null;
		    current = count;
		  }

		  public void setGrow(int grow) {
		    this.grow = grow;
		  }

		  public void grow() {
		    size = size += (size / grow);
		    rehash();
		  }

		  public void add(Object o) {
		    if (current == elements.length)
		      grow();

		    try {
		      elements[current] = o;
		      current++;
		    } catch (java.lang.ArrayStoreException ase) {
		    }
		  }

		  public void add(int location, Object o) {
		    try {
		      elements[location] = o;
		    } catch (java.lang.ArrayStoreException ase) {
		    }
		  }

		  public void remove(int location) {
		    elements[location] = null;
		  }

		  public int location(Object o) throws Exception {
		    int loc = -1;
		    for (int x = 0; x < elements.length; x++) {
		      if ((elements[x] != null && elements[x] == o)
		          || (elements[x] != null && elements[x].equals(o))) {
		        loc = x;
		        break;
		      }
		    }
		    if (loc == -1)
		      throw new Exception();
		    return (loc);
		  }

		  public Object get(int location) {
		    return elements[location];
		  }

		public String[] printElement() {
			String[] st = new String[3];
			int val = 0;
			for (Object i : elements) {

				st[val] = (String) i;
				val++;			
			}	
			return st;		
		}
	}
