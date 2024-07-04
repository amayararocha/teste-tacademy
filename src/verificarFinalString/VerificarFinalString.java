package verificarFinalString;

public class VerificarFinalString {

    public static void main(String[] args) {
        String string1 = "programação";
        String string2 = "ão";

        String string3 = "Olá";
        String string4 = "mundo";

        String string5 = "";
        String string6 = "abc";

        boolean saoIguais1 = verificarFinalString(string1, string2);
        boolean saoIguais2 = verificarFinalString(string3, string4);
        boolean saoIguais3 = verificarFinalString(string5, string6);

        System.out.println(saoIguais1);
        System.out.println(saoIguais2);
        System.out.println(saoIguais3);
    }

    public static boolean verificarFinalString(String string1, String string2) {

        if (string1.length() < 2 || string2.length() < 2) {
            return false;
        }
        String ultimos = string1.substring(string1.length() - 2);

        String primeiros = string2.substring(0, 2);

        return ultimos.equals(primeiros);
    }
}
