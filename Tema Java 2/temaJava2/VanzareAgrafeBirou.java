public class VanzareAgrafeBirou {
    private String culoare;
    private double pretUnitar;
    private int cantitate;
    private double valoareTotala;

    public VanzareAgrafeBirou(String culoare, double pretUnitar, int cantitate) {
        this.culoare = culoare;
        this.pretUnitar = pretUnitar;
        this.cantitate = cantitate;
        this.valoareTotala = calculateValoareTotala();
    }

    public String getCuloare() {
        return culoare;
    }

    public double getPretUnitar() {
        return pretUnitar;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getValoareTotala() {
        return valoareTotala;
    }

    private double calculateValoareTotala() {
        return pretUnitar * cantitate;
    }

    @Override
    public String toString() {
        return "Culoare: " + culoare + "\n" +
                "Pret unitar: " + pretUnitar + "\n" +
                "Cantitate: " + cantitate + "\n" +
                "Valoare totala: " + valoareTotala;
    }

    public static void main(String[] args) {
        VanzareAgrafeBirou agrafe1 = new VanzareAgrafeBirou("Rosu", 0.5, 100);
        VanzareAgrafeBirou agrafe2 = new VanzareAgrafeBirou("Albastru", 0.3, 200);

        System.out.println("Agrafe 1:\n" + agrafe1.toString());
        System.out.println("\nAgrafe 2:\n" + agrafe2.toString());
    }
}
