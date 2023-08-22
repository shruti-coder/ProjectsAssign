public class HashArray {
		private item keys = new item();

		private item elements = new item();

		public HashArray() {
		}

		public void setSize(int newSize) {
			keys.setSize(newSize);
			elements.setSize(newSize);
		}

		public void setGrow(int growBy) {
			keys.setGrow(growBy);
			elements.setGrow(growBy);
		}

		public synchronized void put(String key, Object element) {
			try {
				if (containsKey(key)) {
					elements.add(keys.location(key), element);
				} else {
					keys.add(key);
					elements.add(element);
				}
			} catch (Exception nsoe) {
			}
		}

		public synchronized void remove(String key) {
			try {
				if (containsKey(key)) {
					elements.remove(keys.location(key));
					elements.remove(elements.location(key));
				}
			} catch (Exception nsoe) {
			}
		}

		public int size() {
			return keys.getCurrentSize();
		}

		public boolean contains(Object element) {
			try {
				elements.location(element);
				return (true);
			} catch (Exception noSuchObject) {
				return false;
			}
		}

		public boolean containsKey(String key) {
			try {
				keys.location(key);
			} catch (Exception noSuchObject) {
				return false;
			}
			return (true);
		}

		public Object get(String key) {
			try {
				if (containsKey(key))
					return (elements.get(keys.location(key)));
			} catch (Exception nsoe) {
			}
			return null;
		}

		public void printElement() {
			String key;
			String value = null;
			String[] st=keys.printElement();
			String[] st2=elements.printElement();
			
			for (int i=0;i<st.length;i++) {
				key=st[i];
				value=st2[i];
				System.out.println("Key values are " +key+"----"+value);
			}		
		}	
	}

