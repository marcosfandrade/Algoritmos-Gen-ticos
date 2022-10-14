public class TournamentSelection {

    private boolean tournamentSelection;

    public TournamentSelection(boolean tournamentSelection) {
        this.tournamentSelection = tournamentSelection;
    }

    public Individual select(Population population) {
        if (this.tournamentSelection) {
            Population tournament = new Population(2);
            tournament.setIndividual(0, population.getIndividual((int) (Math.random() * population.size())));
            tournament.setIndividual(1, population.getIndividual((int) (Math.random() * population.size())));
            return tournament.getFittest(0);
        } else {
            return population.getFittest((int) (Math.random() * population.size()));
        }
    }
    
}
