public class AVLTree<K extends Comparable<K>, V> {
	private AVLNode root = null;

	/*
	 * true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {		
		return root == null;
	}

	/*
	 * Adds a given value indexed with a given key to the tree according to the
	 * binary search structure.  If the key is already present, this method throws
	 * a DuplicateKeyException.
	 */
	public void add(K key, V value) {
		if (isEmpty()) {
//			root = new AVLNode(key, value, null);
			root = new AVLNode(key, value);
		} 
		else {
			root.add(key, value);
		}
	}

	/*
	 * Returns the value associated with the given key in this binary search tree.
	 * If there is no element associated with this key, null is returned.
	 */
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		if (root == null) {
			return null;
		}
		AVLNode toReturn = root.get(key);
		if (toReturn == null) {
			return null;
		}
		return toReturn.value;
	}

	/*
	 * Clears all elements from the tree.
	 */
	public void clear() {
		root = null;
	}

	public int getHeight(K key) {
		return root.get(key).height;
	}

	private class AVLNode {
		public K key;
		public V value;
		public AVLNode leftChild = null;
		public AVLNode rightChild = null;
//		public AVLNode parent = null;
		public int height = 1;

		/*
		 * null key will generate a null pointer exception when
		 * a method (such as compareTo) is called on it.
		 * This is matches the Java Collections Framework specification.
		 */

//		public AVLNode(K key, V value, AVLNode parent) {
//			this.key = key;
//			this.value = value;
//			this.parent = parent;
//		}
		
		public AVLNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

//		public AVLNode(AVLNode avlNode) {
//			key = avlNode.key;
//			value = avlNode.value;
//			leftChild = avlNode.leftChild;
//			rightChild = avlNode.rightChild;
//			parent = avlNode.parent;
//			height = avlNode.height;
//		}

		public AVLNode(K key, V value, AVLNode leftChild, AVLNode rightChild) {
			this.key = key;
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		//		private void balance(int balanceFactor) {
		//			/*
		//			 * if balanceFactor is positive
		//			 * 		if left-right
		//			 * 				fix it
		//			 * 		fix left-left
		//			 * if balanceFactor is negative
		//			 * 		if right-left
		//			 * 			fix it
		//			 * 		fix right-right
		//			 */
		//			int rotationNodeBalanceFactor;
		//			
		//			if (balanceFactor >= 2 ) {
		//				// checking left side cases
		//				rotationNodeBalanceFactor = leftChild.balanceFactor();
		//				if (rotationNodeBalanceFactor < 0) {
		//					balanceLeftRightCase();
		//				}
		//				balanceLeftLeftCase();
		//			}
		//			else if (balanceFactor <= -2) {
		//				// checking right side cases 
		//				rotationNodeBalanceFactor = rightChild.balanceFactor();
		//				if (rotationNodeBalanceFactor < 0) {
		//					balanceRightLeftCase();
		//				}
		//				balanceRightRightCase();
		//			}
		//		}
		
		//		private void rebalance(int balanceFactor) {
		//			/*
		//			 * if balanceFactor is positive
		//			 * 		if left-right
		//			 * 				fix it
		//			 * 		fix left-left
		//			 * if balanceFactor is negative
		//			 * 		if right-left
		//			 * 			fix it
		//			 * 		fix right-right
		//			 */
		//			int rotationNodeBalanceFactor;
		//			
		//			if (balanceFactor >= 2 ) {
		//				// checking left side cases
		//				rotationNodeBalanceFactor = leftChild.balanceFactor();
		//				if (rotationNodeBalanceFactor < 0) {
		//					balanceLeftRightCase();
		//				}
		//				balanceLeftLeftCase();
		//			}
		//			else if (balanceFactor <= -2) {
		//				// checking right side cases 
		//				rotationNodeBalanceFactor = rightChild.balanceFactor();
		//				if (rotationNodeBalanceFactor > 0) { //switched sign: was <
		//					balanceRightLeftCase();
		//				}
		//				balanceRightRightCase();
		//			}
		//		}
		
		//		private void balanceLeftRightCase() {
		//			AVLNode bottom = leftChild;
		//			bottom.rightChild = leftChild.rightChild.leftChild; // 3's right = B
		//			bottom.rightChild.parent = bottom; // B's parent = new 3
		//			bottom.height = leftChild.rightChild.height;		//change height of bottom to old height of old 4
		//			bottom.parent = leftChild.rightChild;		// change bottom's parent to old 4
		//					
		//			AVLNode middle = leftChild.rightChild;		//make middle = old 4
		//			middle.leftChild = bottom;		// middle's left = new 3 (bottom)
		//			middle.parent = this;		// middle's parent = old 5
		//			middle.height = leftChild.height;		// middle's height = old 3's height
		//					
		//			this.leftChild = middle;		// top's left = new 4 (middle)
		//					// 
		//				
		//			
		////			AVLNode top = new AVLNode(this);
		////			AVLNode middle = new AVLNode(leftChild);
		////			AVLNode bottom = new AVLNode(middle.rightChild);
		//			
		////			leftChild = bottom;
		////			leftChild.parent = this;
		////			leftChild.height = middle.height;
		////			leftChild.leftChild = middle;
		////			leftChild.leftChild.parent = leftChild;
		////			leftChild.leftChild.height = bottom.height;
		////			leftChild.leftChild.rightChild = bottom.leftChild;
		////			leftChild.leftChild.rightChild.parent = leftChild.leftChild;
		//		}
		
		//		private void balanceLeftLeftCase() {
		//			AVLNode top = new AVLNode(this);
		//			AVLNode middle = new AVLNode(leftChild);
		//			AVLNode bottom = new AVLNode(middle.leftChild);	
		//			this.changeFields(middle.key, middle.value, middle.leftChild, top);
		//			rightChild.leftChild = middle.rightChild;
		//			rightChild.height = leftChild.height;
		//		}
		
				private void changeFields(K key, V value, AVLNode leftChild, AVLNode rightChild) {
					this.key = key;
					this.value = value;
					this.leftChild = leftChild;
					this.rightChild = rightChild;
		//			this.parent = parent;
		//			this.height = height;
				}

//		public AVLNode getParentPredecessor() {
//			if (rightChild.rightChild == null) {
//				return this;
//			}
//			else {
//				return rightChild.getParentPredecessor();
//			}
//		}
//
//		public AVLNode getPredecessor(AVLNode ancestor) {
//			if (this == ancestor) {
//				return leftChild;
//			}
//			else {
//				return rightChild;
//			}
//		}

		public void add(K addKey, V addValue) {

			int keyComparison = addKey.compareTo(key);
			if (keyComparison == 0) {
				throw new DuplicateKeyException(addKey);
			}
			else if (keyComparison < 0) {
				if (leftChild == null) {
//					leftChild = new AVLNode(addKey, addValue, this);
					leftChild = new AVLNode(addKey, addValue);
//					balance();
				}
				else {
					leftChild.add(addKey, addValue);
				}
			}
			else {
				if (rightChild == null) {
//					rightChild = new AVLNode(addKey, addValue, this);
					rightChild = new AVLNode(addKey, addValue);
//					balance();
				}
				else {
					rightChild.add(addKey, addValue);
				}
			}
			balance();
			
		}

		public AVLNode get(K getKey) {
			int keyComparison = getKey.compareTo(key);
			if (keyComparison == 0){
				//System.out.println("height of " + this.value + " is " + height);
				return this;
			}
			else if (keyComparison < 0) {
				if (leftChild == null) {
					return null;
				}
				else {
					//System.out.println("height of " + leftChild.value + " is " + leftChild.height);
					return leftChild.get(getKey);
				}
			}
			else {
				if (rightChild == null) {
					return null;
				}
				else {
					//System.out.println("height of " + rightChild.value + " is " + rightChild.height);
					return rightChild.get(getKey);
				}
			}
		}
		
		public void balance(){
			
			int balanceFactor = balanceFactor();
			// wiki says we will never get anything other than 2 or -2 for unbalanced tree.
			if (balanceFactor == 2) {
				if (leftChild.balanceFactor() == -1) { // left-right case
					leftChild.rotateLeft();
				}
				rotateRight();
			}
			else if (balanceFactor == -2) {
				if (rightChild.balanceFactor() == 1) { // right-left case
					rightChild.rotateRight();
				}
				rotateLeft();
			}
			updateHeight();
//			height = Math.max(getLeftHeight(), getRightHeight()) + 1;
//			if (balanceFactor == 0) {
//				return;
//			}
//			else if (balanceFactor == 1) {
//				// left is slightly heavier
//				height = leftChild.height + 1;
//				if (parent != null) {
//					parent.balance();
//				}
//			}
//			else if (balanceFactor == -1) {
//				// right is slightly heavier
//				height = rightChild.height + 1;
//				if (parent != null) {
//					parent.balance();
//				}
//			}
//			// TO DO: remove else case when done
//			else {
//				System.out.println("balance factor is out of balance");
//			}
			
		}

		private void rotateRight() {
			System.out.println("rotating right");
//			if (leftChild.balanceFactor() == -1) { // left-right case
//				leftChild.rotateLeft();
//			}
			// At this point, we know it's the left-left case
			AVLNode toMoveDown = new AVLNode(key, value, leftChild.rightChild, rightChild);
			changeFields(leftChild.key, leftChild.value, leftChild.leftChild, toMoveDown);
			rightChild.updateHeight();
			updateHeight();
//			rightChild = this;
//			rightChild.leftChild = leftChild.rightChild;
//			leftChild = leftChild.leftChild;
			System.out.println("rotating right ended");
		}

//		private AVLNode getLeftChild() {
//			return leftChild;
//		}
//
//		private AVLNode getRightChild() {
//			return rightChild;
//		}

		private void rotateLeft() {
			System.out.println("rotating left");
//					if (rightChild.balanceFactor() == 1) { // right-left case
//						rightChild.rotateRight();
//					}
					// At this point, we know it's the right-right case
					AVLNode toMoveDown = new AVLNode(key, value, leftChild, rightChild.leftChild);
					changeFields(rightChild.key, rightChild.value, toMoveDown, rightChild.rightChild);
					leftChild.updateHeight();
					updateHeight();
		//			leftChild = this;
		//			leftChild.rightChild = rightChild.leftChild;
		//			rightChild = rightChild.rightChild;
					System.out.println("rotating left ended");
				}

		private void updateHeight() {
			System.out.println(this.key + " is at height " + this.height);
			height = Math.max(getLeftHeight(), getRightHeight()) + 1;
			System.out.println(this.key + " is at height " + this.height);
			System.out.println();
		}

		private int getLeftHeight() {
			return (leftChild == null ? 0 : leftChild.height);
		}

		private int getRightHeight() {
			return (rightChild == null ? 0 : rightChild.height);
		}

		private int balanceFactor() {
//			int leftHeight = (leftChild == null ? 0 : leftChild.height);
//			int rightHeight = (rightChild == null ? 0 : rightChild.height);
//			int balanceFactor = leftHeight - rightHeight;
//			if (balanceFactor <= -2 || 2 <= balanceFactor) {
//				rebalance(balanceFactor);
//				return balanceFactor();
//			}
//			return balanceFactor;
			return getLeftHeight() - getRightHeight();
		}

//		private void balance(int balanceFactor) {
//			/*
//			 * if balanceFactor is positive
//			 * 		if left-right
//			 * 				fix it
//			 * 		fix left-left
//			 * if balanceFactor is negative
//			 * 		if right-left
//			 * 			fix it
//			 * 		fix right-right
//			 */
//			int rotationNodeBalanceFactor;
//			
//			if (balanceFactor >= 2 ) {
//				// checking left side cases
//				rotationNodeBalanceFactor = leftChild.balanceFactor();
//				if (rotationNodeBalanceFactor < 0) {
//					balanceLeftRightCase();
//				}
//				balanceLeftLeftCase();
//			}
//			else if (balanceFactor <= -2) {
//				// checking right side cases 
//				rotationNodeBalanceFactor = rightChild.balanceFactor();
//				if (rotationNodeBalanceFactor < 0) {
//					balanceRightLeftCase();
//				}
//				balanceRightRightCase();
//			}
//		}

//		private void rebalance(int balanceFactor) {
//			/*
//			 * if balanceFactor is positive
//			 * 		if left-right
//			 * 				fix it
//			 * 		fix left-left
//			 * if balanceFactor is negative
//			 * 		if right-left
//			 * 			fix it
//			 * 		fix right-right
//			 */
//			int rotationNodeBalanceFactor;
//			
//			if (balanceFactor >= 2 ) {
//				// checking left side cases
//				rotationNodeBalanceFactor = leftChild.balanceFactor();
//				if (rotationNodeBalanceFactor < 0) {
//					balanceLeftRightCase();
//				}
//				balanceLeftLeftCase();
//			}
//			else if (balanceFactor <= -2) {
//				// checking right side cases 
//				rotationNodeBalanceFactor = rightChild.balanceFactor();
//				if (rotationNodeBalanceFactor > 0) { //switched sign: was <
//					balanceRightLeftCase();
//				}
//				balanceRightRightCase();
//			}
//		}

//		private void balanceLeftRightCase() {
//			AVLNode bottom = leftChild;
//			bottom.rightChild = leftChild.rightChild.leftChild; // 3's right = B
//			bottom.rightChild.parent = bottom; // B's parent = new 3
//			bottom.height = leftChild.rightChild.height;		//change height of bottom to old height of old 4
//			bottom.parent = leftChild.rightChild;		// change bottom's parent to old 4
//					
//			AVLNode middle = leftChild.rightChild;		//make middle = old 4
//			middle.leftChild = bottom;		// middle's left = new 3 (bottom)
//			middle.parent = this;		// middle's parent = old 5
//			middle.height = leftChild.height;		// middle's height = old 3's height
//					
//			this.leftChild = middle;		// top's left = new 4 (middle)
//					// 
//				
//			
////			AVLNode top = new AVLNode(this);
////			AVLNode middle = new AVLNode(leftChild);
////			AVLNode bottom = new AVLNode(middle.rightChild);
//			
////			leftChild = bottom;
////			leftChild.parent = this;
////			leftChild.height = middle.height;
////			leftChild.leftChild = middle;
////			leftChild.leftChild.parent = leftChild;
////			leftChild.leftChild.height = bottom.height;
////			leftChild.leftChild.rightChild = bottom.leftChild;
////			leftChild.leftChild.rightChild.parent = leftChild.leftChild;
//		}

//		private void balanceLeftLeftCase() {
//			AVLNode top = new AVLNode(this);
//			AVLNode middle = new AVLNode(leftChild);
//			AVLNode bottom = new AVLNode(middle.leftChild);	
//			this.changeFields(middle.key, middle.value, middle.leftChild, top);
//			rightChild.leftChild = middle.rightChild;
//			rightChild.height = leftChild.height;
//		}


//		private void balanceRightLeftCase() {
//			AVLNode top = this;
//			AVLNode middle = rightChild;
//			AVLNode bottom = middle.leftChild;
//			rightChild = bottom;
//			rightChild.height = middle.height;
//			rightChild.rightChild = middle;
//			rightChild.rightChild.height = bottom.height;
//			rightChild.rightChild.leftChild = bottom.rightChild;
//			
//		}

//		private void balanceRightRightCase() {
//			AVLNode top = this;
//			AVLNode middle = rightChild;
//			AVLNode bottom = middle.rightChild;
//			this.changeFields(middle.key, middle.value, middle.rightChild, top);
//			leftChild.rightChild = middle.leftChild;
//			leftChild.height = rightChild.height;
//		}
		
		
	}
}