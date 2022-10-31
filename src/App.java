public class App {
    public static void main(String[] args) throws Exception {
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.05, 0.9, 2, true);
        Population population = ga.initPopulation();
        ga.evalPopulation(population);
        int generation = 1;
        while (ga.isTerminationConditionMet(population) == false && generation <= 1000) {
            System.out.println("Generation: " + generation + " Fittest: " + population.getFittest(0).getFitness());
            population = ga.crossoverPopulation(population);
            population = ga.mutatePopulation(population);
            ga.evalPopulation(population);
            generation++;
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generation);
        System.out.println("Genes:");
        System.out.println(population.getFittest(0).toString());
    }
}
