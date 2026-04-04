public class App {
    public static void main(String[] args) {
        int free = 0;
        int tests = 10000;
        
        PrisonersProblem prisonersObj = new PrisonersProblem(100);
        for (int i = 0; i < tests; i++) {
            if (prisonersObj.testSerialSearchByValueChain()) {
                free++;
            }
        }

        System.out.println(100.0 * free / tests + "% of trials result in free prisoners.");
    }
}
