import java.util.Random;

public class PrisonersProblem {

    /**
     * Generates an array of n unique random integers between 0 and n-1
     * using a Fisher-Yates shuffle.
     */
    static int[] generateUniqueRandomArray(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input N must be non-negative.");
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        // Fisher-Yates shuffle
        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    /**
     * Follows a chain of indices starting from start_index,
     * counting steps until arr[current_index] == start_index.
     * Returns -1 if an infinite loop or invalid index is encountered.
     */
    static int serialSearchByValueChain(int[] arr, int startIndex) {
        if (startIndex < 0 || startIndex >= arr.length) {
            throw new IllegalArgumentException("Input 'startIndex' is out of array bounds.");
        }

        boolean[] visited = new boolean[arr.length]; // replaces the Python set
        int currentIndex = startIndex;
        int searchCount = 0;

        while (true) {
            searchCount++;

            if (visited[currentIndex]) {
                System.out.println("Warning: Infinite loop detected at index " + currentIndex);
                return -1;
            }
            visited[currentIndex] = true;

            if (currentIndex < 0 || currentIndex >= arr.length) {
                System.out.println("Error: Invalid index encountered: " + currentIndex);
                return -1;
            }

            int currentValue = arr[currentIndex];

            if (currentValue == startIndex) {
                return searchCount;
            }

            currentIndex = currentValue;
        }
    }

    /**
     * Tests all start indices. Returns true only if every chain
     * resolves in at most n/2 steps.
     */
    static boolean testSerialSearchByValueChain(int n) {
        int[] randomArray = generateUniqueRandomArray(n);
        boolean passed = true;

        for (int startIndex = 0; startIndex < n; startIndex++) {
            int numOfSearches = serialSearchByValueChain(randomArray, startIndex);
            if (numOfSearches > n / 2.0) {
                passed = false;
                break;
            }
        }
        return passed;
    }

}