package annexe;

import java.util.ArrayList;

public class StringInfo {

    public static void main(String[] args) {

        // Le string builder

        String chaine = "salut " + " ca va?" + " oui et toi?" + " tres bien" + "merci"; // 4 instanciations dues à concat
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("salut ")
                .append(" ca va?")
                .append(" oui et toi?")
                .append(" tres bien")
                .append("merci");

        String chaineViaBuilder = stringBuilder.toString(); // 2 instanciations dues à StringBuilder(celle du stringBuilder et celle du toString)

        System.out.println("Stringbuilder demo : \n" + chaineViaBuilder);

        String a = "salut";
        String b = "salut";
        String c = new String("salut");
        String d = "sa"+"lut";

        System.out.println( a == b ); // true
        System.out.println( a == c ); // false
        System.out.println( a == d ); // true

    }

}
