package co.ke.bsl.sisdo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ListUtils {
	/**
	 * Create a new list which contains the specified number of elements from
	 * the source list, in a random order but without repetitions.
	 * 
	 * @param sourceList
	 *            the list from which to extract the elements.
	 * @param itemsToSelect
	 *            the number of items to select
	 * @param random
	 *            the random number generator to use
	 * @return a new list containg the randomly selected elements
	 */
	// From http://jimblackler.net/blog/?p=59
	// Thanks.
	public static <T> List<T> getRandomSubSelection(List<T> sourceList,
			int itemsToSelect, Random random) {
		int sourceSize = sourceList.size();

		if (sourceSize == 0 || itemsToSelect <= 0 || sourceSize < itemsToSelect) {
			throw new IllegalArgumentException();
		}

		// Generate an array representing the element to select from 0... number
		// of available
		// elements after previous elements have been selected.
		int[] selections = new int[itemsToSelect];

		// Simultaneously use the select indices table to generate the new
		// result array
		ArrayList<T> resultArray = new ArrayList<T>();
		for (int count = 0; count < itemsToSelect; count++) {
			// An element from the elements *not yet chosen* is selected
			int selection = random.nextInt(sourceSize - count);
			selections[count] = selection;

			// Store original selection in the original range 0.. number of
			// available elements
			// This selection is converted into actual array space by iterating
			// through the elements
			// already chosen.
			for (int scanIdx = count - 1; scanIdx >= 0; scanIdx--) {
				if (selection >= selections[scanIdx]) {
					selection++;
				}
			}

			// When the first selected element record is reached all selections
			// are in the range
			// 0.. number of available elements, and free of collisions with
			// previous entries.
			// Write the actual array entry to the results
			resultArray.add(sourceList.get(selection));
		}

		return resultArray;
	}

	/*public static void slide_down(Context ctx, View v) {
		Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
		if (a != null) {
			a.reset();
			if (v != null) {
				v.clearAnimation();
				v.startAnimation(a);
			}
		}
	}*/
}
