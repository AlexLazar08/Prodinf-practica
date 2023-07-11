 import java.util.Arrays;

    public class problema1 {
        public static boolean suntAnagrame(String cuvant1, String cuvant2) {
            // Verificăm dacă cele două cuvinte au aceeași lungime
            if (cuvant1.length() != cuvant2.length()) {
                return false;
            }

            // Sortăm caracterele din șirurile de caractere
            char[] sirCaractere1 = cuvant1.toCharArray();
            char[] sirCaractere2 = cuvant2.toCharArray();
            Arrays.sort(sirCaractere1);
            Arrays.sort(sirCaractere2);

            // Verificăm dacă șirurile sortate sunt identice
            return Arrays.equals(sirCaractere1, sirCaractere2);
        }

        public static void main(String[] args) {
            String cuvant1 = "ascultare";
            String cuvant2 = "salutare";

            if (suntAnagrame(cuvant1, cuvant2)) {
                System.out.println("DA");
            } else {
                System.out.println("NU");
            }
        }
    }

