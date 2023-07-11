
import java.util.HashMap;
import java.util.Map;

public class problema5 {
    public static char gasestePrimulNerepetat(String str) {
        Map<Character, Integer> frecventa = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frecventa.put(ch, frecventa.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (frecventa.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String str = "abcdefghijab";
        char primulNerepetat = gasestePrimulNerepetat(str);

        if (primulNerepetat != '\0') {
            System.out.println("Primul caracter nerepetat: " + primulNerepetat);
        } else {
            System.out.println("Nu există niciun caracter nerepetat în șir.");
        }
    }
}
