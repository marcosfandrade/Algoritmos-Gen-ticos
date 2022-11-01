public class GeneticAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    private TournamentSelection tournamentSelection;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
            boolean tournamentSelection) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.tournamentSelection = new TournamentSelection(tournamentSelection);
    }

    public Population initPopulation() {
        return new Population(this.populationSize);
    }

    public void evalPopulation(Population population) {
        double populationFitness = 0;
        for (Individual individual : population.getIndividuals()) {
            populationFitness += this.calcFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }

    private double calcFitness(Individual individual) {
        double x1 = individual.getChromosome(0);
        double x2 = individual.getChromosome(1);
        // double fitness = x1 - x2;
        double fitness = (x1 - Math.log(x2)) / (Math.pow(x1, 2) - 3 * x2);
        individual.setFitness(fitness);
        return fitness;
    }

    public boolean isTerminationConditionMet(Population population) {
        // condition to terminate if generation is not variable in 30 generations
        for (Individual individual : population.getIndividuals()) {
            if (individual.getFitness() == 1) {
                return true;
            }
        }
        return false;
    }

    public Population crossoverPopulation(Population population) {
        Population newPopulation = new Population(population.size());
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual parent1 = population.getFittest(populationIndex);
            if (this.crossoverRate > Math.random() && populationIndex >= this.elitismCount) {
                Individual offspring = new Individual(parent1.getChromosomeLength());
                Individual parent2 = this.tournamentSelection.select(population);
                for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
                    if (0.5 > Math.random()) {
                        offspring.setChromosome(geneIndex, parent1.getChromosome(geneIndex));
                    } else {
                        offspring.setChromosome(geneIndex, parent2.getChromosome(geneIndex));
                    }
                }
                newPopulation.setIndividual(populationIndex, offspring);
            } else {
                newPopulation.setIndividual(populationIndex, parent1);
            }
        }
        return newPopulation;
    }

    public Population mutatePopulation(Population population) {
        Population newPopulation = new Population(this.populationSize);
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual individual = population.getFittest(populationIndex);
            for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
                if (populationIndex > this.elitismCount && this.mutationRate > Math.random()) {
                    double newGene = 1 + Math.random();
                    individual.setChromosome(geneIndex, newGene);
                }
            }
            newPopulation.setIndividual(populationIndex, individual);
        }
        return newPopulation;
    }

    public void setElitismCount(int elitismCount) {
        this.elitismCount = elitismCount;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public void setTournamentSelection(boolean tournamentSelection) {
        this.tournamentSelection = new TournamentSelection(tournamentSelection);
    }

    public int getElitismCount() {
        return this.elitismCount;
    }

    public double getCrossoverRate() {
        return this.crossoverRate;
    }

    public double getMutationRate() {
        return this.mutationRate;
    }

    public int getPopulationSize() {
        return this.populationSize;
    }

    public boolean getTournamentSelection() {
        return this.tournamentSelection.getTournamentSelection();
    }
}
