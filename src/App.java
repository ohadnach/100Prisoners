public class App {
    public static void main(String[] args) {
        int free = 0;
        int prisoners = 100;
        int tests = 10000;

        for (int i = 0; i < tests; i++) {
            if (PrisonersProblem.testSerialSearchByValueChain(prisoners)) {
                free++;
            }
        }

        System.out.println(100.0 * free / tests + "% of trials result in free prisoners.");
    }
}
