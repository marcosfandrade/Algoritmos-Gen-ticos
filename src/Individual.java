public class Individual {

    private double[] chromosome;
    private double fitness = -1;

    public Individual(double[] chromosome) {
        this.chromosome = chromosome;
    }

    public Individual(int chromosomeLength) {
        this.chromosome = new double[chromosomeLength];
    }

    public double[] getChromosome() {
        return this.chromosome;
    }

    public double getChromosome(int index) {
        return this.chromosome[index];
    }

    public void setChromosome(int index, double value) {
        this.chromosome[index] = value;
        this.fitness = -1;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    public double getFitness() {
        return this.fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene] + " ";
        }
        return output;
    }
}
