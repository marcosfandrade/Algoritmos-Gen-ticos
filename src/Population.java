import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Population {

    private Individual[] individuals;

    public Population(int populationSize) {
        this.individuals = new Individual[populationSize];
    }

    public Population(int populationSize, int chromosomeLength) {
        this.individuals = new Individual[populationSize];
        for (int individualCount = 0; individualCount < populationSize; individualCount++) {
            Individual individual = new Individual(chromosomeLength);
            this.individuals[individualCount] = individual;
        }
    }

    public Individual[] getIndividuals() {
        return this.individuals;
    }

    public Individual getIndividual(int index) {
        return this.individuals[index];
    }

    public Individual setIndividual(int index, Individual individual) {
        return this.individuals[index] = individual;
    }

    public int size() {
        return this.individuals.length;
    }

    public Individual getFittest(int offset) {
        Arrays.sort(this.individuals, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                if (o1.getFitness() > o2.getFitness()) {
                    return -1;
                } else if (o1.getFitness() < o2.getFitness()) {
                    return 1;
                }
                return 0;
            }
        });
        return this.individuals[offset];
    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(this.individuals));
    }

    @Override
    public String toString() {
        String populationString = "";
        for (int individualCount = 0; individualCount < this.individuals.length; individualCount++) {
            populationString += "Individual " + individualCount + ": " + this.individuals[individualCount].toString() + " Fitness: " + this.individuals[individualCount].getFitness() + " | ";
        }
        return populationString;
    }

    public void sortIndividuals() {
        Arrays.sort(this.individuals, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                if (o1.getFitness() > o2.getFitness()) {
                    return -1;
                } else if (o1.getFitness() < o2.getFitness()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    public void setPopulationFitness(double fitness) {
        for (int individualCount = 0; individualCount < this.individuals.length; individualCount++) {
            this.individuals[individualCount].setFitness(fitness);
        }
    }
    
}
