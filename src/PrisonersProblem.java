import java.util.Random;

public class PrisonersProblem {

    private int prisonersNumber;
    private int[] boxes;

    public PrisonersProblem(int prisonersNumber) {
        this.prisonersNumber = prisonersNumber;
        this.boxes = new int[prisonersNumber];
    }

    /**
     * Generates an array of n unique random integers between 0 and n-1
     * using a Fisher-Yates shuffle.
     */
    public void generateUniqueRandomArray() {
        for (int i = 0; i < this.prisonersNumber; i++) {
            this.boxes[i] = i;
        }
        // Fisher-Yates shuffle
        Random rand = new Random();
        for (int i = this.prisonersNumber - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = this.boxes[i];
            this.boxes[i] = this.boxes[j];
            this.boxes[j] = temp;
        }
    }

    /**
     * Follows a chain of indices starting from start_index,
     * counting steps until arr[current_index] == start_index.
     * Returns -1 if an infinite loop or invalid index is encountered.
     */
    public int serialSearchByValueChain(int startIndex) {
        if (startIndex < 0 || startIndex >= this.boxes.length) {
            throw new IllegalArgumentException("Input 'startIndex' is out of array bounds.");
        }

        boolean[] visited = new boolean[this.boxes.length];
        int currentIndex = startIndex;
        int currentValue = this.boxes[currentIndex];
        int searchCount = 0;

        while (currentValue != startIndex && searchCount <= this.boxes.length) {

            if (currentIndex < 0 || currentIndex >= this.boxes.length) {
                System.out.println("Error: Invalid index encountered: " + currentIndex);
                return -1;
            }

            if (visited[currentIndex]) {
                System.out.println("Warning: Infinite loop detected at index " + currentIndex);
                return -1;
            }
            visited[currentIndex] = true;

            currentValue = this.boxes[currentIndex];
            currentIndex = currentValue;
            searchCount++;

        }
        return searchCount;
    }

    public int serialSearchByValueChainCons(int startIndex) {
        if (startIndex < 0 || startIndex >= this.boxes.length) {
            throw new IllegalArgumentException("Input 'startIndex' is out of array bounds.");
        }

        boolean[] visited = new boolean[this.boxes.length];
        int currentIndex = startIndex;
        int currentValue = this.boxes[currentIndex];
        int searchCount = 0;

        while (currentValue != startIndex && searchCount <= this.boxes.length) {

            if (currentIndex < 0 || currentIndex >= this.boxes.length) {
                System.out.println("Error: Invalid index encountered: " + currentIndex);
                return -1;
            }

            if (visited[currentIndex]) {
                System.out.println("Warning: Infinite loop detected at index " + currentIndex);
                return -1;
            }
            visited[currentIndex] = true;

            currentValue = this.boxes[currentIndex];
            currentIndex++;
            searchCount++;

        }
        return searchCount;
    }

    /**
     * Tests all start indices. Returns true only if every chain
     * resolves in at most n/2 steps.
     */
    public boolean testSerialSearchByValueChain() {
        this.generateUniqueRandomArray();
        boolean passed = true;

        for (int startIndex = 0; startIndex < this.prisonersNumber; startIndex++) {
            int numOfSearches = serialSearchByValueChain(startIndex);
            if (numOfSearches == -1 || numOfSearches > this.prisonersNumber / 2.0) {
                passed = false;
                return passed;
            }
        }
        return passed;
    }

}