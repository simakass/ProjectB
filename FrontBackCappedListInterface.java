/**
 * An interface for a list. 
 * Entries in a list have positions that begin with 0. 
 * Entries can only be removed or added to the beginning (front) or end (back) of the list.
 * Entries can be accessed from any position. 
 * The size of the list is limited ("capped"). When the limit is reached, no more entries can be added.
 * 
 * @author Jessica Masters
 */
public interface FrontBackCappedListInterface<T> {
	
	/**
	 * Adds a new entry to the beginning of the list if the list is not full. 
	 * If the entry is added, entries currently in the list are shifted down and
	 * the list size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return true if the object was added, false if the list was full and thus the object was not added
	 */
	public boolean addFront(T newEntry);
	
	/**
	 * Adds a new entry to the end of the list if the list is not full.  
	 * Entries currently in the list are unaffected.
	 * If the entry is added, the list size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return true if the object was added, false if the list was full and thus the object was not added
	 */
	public boolean addBack(T newEntry);



	/**
	 * Removes an entry from the beginning of the list. 
	 * Entries currently in the list are shifted up.
	 * If an entry is removed, the list size is decreased by 1.
	 * 
	 * @return A reference to the removed entry or null if the list is empty.
	 */
	public T removeFront();
	
	/**
	 * Removes an entry from the end of the list. 
	 * Entries currently in the list are unaffected.
	 * If an entry is removed, the list size is decreased by 1.
	 * 
	 * @return A reference to the removed entry or null if the list is empty.
	 */
	public T removeBack();

	
	/** Removes all entries from this list. */
	public void clear();

	
	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the desired entry.
	 * @return A reference to the indicated entry or null if the index is out of bounds.
	 */
	public T getEntry(int givenPosition);
	
	
	/**
	 * Determines the position in the list of a given entry. 
	 * If the entry appears more than once, the first index is returned.
	 * 
	 * @param anEntry the object to search for in the list.
	 * @return the first position the entry that was found or -1 if the object is not found.
	 */
	public int indexOf(T anEntry);
	
	/**
	 * Determines the position in the list of a given entry.
	 * If the entry appears more than once, the last index is returned.
	 * 
	 * @param anEntry the object to search for in the list.
	 * @return the last position the entry that was found or -1 if the object is not found.
	 */
	public int lastIndexOf(T anEntry);
	
	/**
	 * Determines whether an entry is in the list.
	 * 
	 * @param anEntry the object to search for in the list.
	 * @return true if the list contains the entry, false otherwise
	 */
	public boolean contains(T anEntry);


	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	public int size();

	/**
	 * Checks whether this list is empty.
	 * 
	 * @return True if the list is empty, or false if the list contains one or more elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Checks whether this list is full.
	 * 
	 * @return True if the list is full, or false otherwise.
	 */
	public boolean isFull();
	
} 
