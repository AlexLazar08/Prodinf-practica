public class problema3 {
    public static void afiseazaNumere(int numar) {
        if (numar <= 10) {
            System.out.println(numar);
            afiseazaNumere(numar + 1);
        }
    }

    public static void main(String[] args) {
        afiseazaNumere(1);
    }
}