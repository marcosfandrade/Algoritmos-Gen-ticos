public class App {
    public static void main(String[] args) throws Exception {
        // generate a generic function and find the best solution
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, true);
        Population population = ga.initPopulation(50);
        ga.evalPopulation(population);
        int generation = 1;
        while (ga.isTerminationConditionMet(population) == false) {
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

    public static double fitnessFunction(double x1, double x2) {
        // return x1 - x2;
        return (x1 - Math.log(x2)) / (Math.pow(x1, 2) - 3 * x2);
    }
}
