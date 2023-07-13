public class VanzareMasina {
    private String marca;
    private String model;
    private double pretLista;
    private double discount;
    private double pretFinal;

    public VanzareMasina(String marca, String model, double pretLista, double discount) {
        this.marca = marca;
        this.model = model;
        this.pretLista = pretLista;
        this.discount = discount;
        this.pretFinal = calculatePretFinal();
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public double getPretLista() {
        return pretLista;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPretFinal() {
        return pretFinal;
    }

    private double calculatePretFinal() {
        return pretLista - (pretLista * discount / 100);
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Model: " + model + "\n" +
                "Pret de lista: " + pretLista + "\n" +
                "Discount: " + discount + "%\n" +
                "Pret final: " + pretFinal;
    }

    public static void main(String[] args) {
        VanzareMasina masina1 = new VanzareMasina("Ford", "Focus", 25000, 10);
        VanzareMasina masina2 = new VanzareMasina("BMW", "X5", 60000, 15);

        System.out.println("Masina 1:\n" + masina1.toString());
        System.out.println("\nMasina 2:\n" + masina2.toString());
    }
}
