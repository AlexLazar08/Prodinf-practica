import java.util.Vector;

public class VectorVanzare {
    public static Object getVanzareCuCostMinim(Vector<Object> vanzari) {
        if (vanzari.isEmpty()) {
            return null;
        }

        Object vanzareMinima = vanzari.get(0);
        double costMinim = getCost(vanzareMinima);

        for (Object vanzare : vanzari) {
            double cost = getCost(vanzare);
            if (cost < costMinim) {
                costMinim = cost;
                vanzareMinima = vanzare;
            }
        }

        return vanzareMinima;
    }

    private static double getCost(Object vanzare) {
        if (vanzare instanceof VanzareMasina) {
            VanzareMasina vanzareMasina = (VanzareMasina) vanzare;
            return vanzareMasina.getPretFinal();
        } else if (vanzare instanceof VanzareAgrafeBirou) {
            VanzareAgrafeBirou vanzareAgrafe = (VanzareAgrafeBirou) vanzare;
            return vanzareAgrafe.getValoareTotala();
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Vector<Object> vanzari = new Vector<>();

        VanzareMasina masina1 = new VanzareMasina("Ford", "Focus", 25000, 10);
        VanzareMasina masina2 = new VanzareMasina("BMW", "X5", 60000, 15);
        VanzareAgrafeBirou agrafe1 = new VanzareAgrafeBirou("Rosu", 0.5, 100);
        VanzareAgrafeBirou agrafe2 = new VanzareAgrafeBirou("Albastru", 0.3, 200);

        vanzari.add(masina1);
        vanzari.add(masina2);
        vanzari.add(agrafe1);
        vanzari.add(agrafe2);

        Object vanzareCuCostMinim = getVanzareCuCostMinim(vanzari);

        if (vanzareCuCostMinim != null) {
            System.out.println("Vanzarea cu costul minim:\n" + vanzareCuCostMinim.toString());
        } else {
            System.out.println("Nu exista vanzari in vector.");
        }
    }
}
