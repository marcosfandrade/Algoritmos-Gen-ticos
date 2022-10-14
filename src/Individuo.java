public class Individuo {

    private double x1;
    private double x2;

    public Individuo(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
    
    public double calculate() {
        return x1 - x2;
        // return (x1 - Math.log10(x2)) / (x1 * x1 - 3 * x2);
    }
}
