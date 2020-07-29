import java.io.IOException;

class GeneticsTest {

    public static class Main {
        public static void main(String[] args) throws IOException {
            //MyFitnessFunction.generateRandomFile("matrix.txt", 256);
            MyFitnessFunction ff = new MyFitnessFunction("matrix.txt");
            GeneticEngine ge = new GeneticEngine(ff);
            ge.setIndividualCount(100);//устанавливаем кол-во особей в поколении
            ge.setGenerationCount(10000); //устанвливаем кол-во поколений
            ge.setSelectionType(GeneticEngine.SelectionType.TOURNEY); //тип селекции
            ge.setCrossingType(GeneticEngine.CrossingType.ELEMENTWISE_RECOMBINATION); //тип скрещивания
            ge.setUseMutation(true); //наши геномы могут мутировать
            ge.setMutationPercent(0.02d); //насколько часто мутируют геномы

            long time = System.currentTimeMillis();
            long[] better = ge.run(); //запускаем

            long timeToFF = ge.timeToFF;
            long timeToSelection = ge.timeToSelection;
            long timeToCrossing = ge.timeToCrossing;
            long timeToMutate = ge.timeToMutate;

            System.out.println("Running:\t" + (System.currentTimeMillis() - time) / 1000 + " secs");
            System.out.println("FitnessFunc:\t" + timeToFF / 1000 + " secs");
            System.out.println(" - FF Prepare:\t" + ff.prepareTime / 1000 + " secs");
            System.out.println(" - FF QSort:\t" + ff.sortingTime / 1000 + " secs");
            System.out.println(" - FF Check: \t" + ff.checkTime / 1000 + " secs");
            System.out.println("Selection:\t" + (timeToSelection - timeToFF) / 1000 + " secs");
            System.out.println("Crossing:\t" + timeToCrossing / 1000 + " secs");
            System.out.println("Mutate: \t" + timeToMutate / 1000 + " secs");
            System.out.println(Long.MAX_VALUE - ff.run(better));
        }

        private static void printLongInBin(long l, int last) {
            if (last > 0) {
                int p = (int) (l & 1);
                printLongInBin(l >> 1, --last);
                System.out.print(p);
            }
        }

    }
}