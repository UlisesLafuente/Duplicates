import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Esto es Java 21.");
        System.out.println("Ejercicio DUPLICATES (task1.03:lvl1)!");

        Month month1 = new Month("Enero");
        Month month2 = new Month("Febrero");
        Month month3 = new Month("Marzo");
        Month month4 = new Month("Abril");
        Month month5 = new Month("Mayo");
        Month month6 = new Month("Junio");
        Month month7 = new Month("Julio");
        Month month8 = new Month("Agosto");
        Month month9 = new Month("Septiembre");
        Month month10 = new Month("Octubre");
        Month month11 = new Month("Noviembre");
        Month month12 = new Month("Diciembre");
        Month month13 = new Month("Enero");
        //Si esta línea y la 30 quedan sin comentar, el método para hayar duplicados lanza error.
        //Month month14 = month2;

        ArrayList<Month> monthList = new ArrayList<>(List.of(
                month1, month2, month3, month4, month5, month6,
                month7, month9, month10, month11, month12, month13));

        monthList.add(7, month8);
        //monthList.add(13, month14);

        ArrayList<String> monthOrder = new ArrayList<>(List.of(
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));

        orderValidator(monthList, monthOrder);

        HashSet<Month> monthHash = convertArrayListToHashSet(monthList);
        verifyNoDuplicates(monthList, monthHash);

        for (ListIterator<Month> it = monthList.listIterator(); it.hasNext(); ) {
            System.out.println(it.next().getName());
        }
    }

    /// //////////////////////////////////////////////////////////

    public static void orderValidator(ArrayList<Month> monthList, ArrayList<String> monthOrder) {
        int i = 0;
        for (Month month : monthList) {
            if (!(month.getName().equals(monthOrder.get(i % 12)))) {
                throw new RuntimeException("El mes " + month.getName() + " no es válido.");
            }
            i++;
        }
    }

    public static HashSet<Month> convertArrayListToHashSet(ArrayList<Month> list) {
        return new HashSet<>(list);
    }

    public static void verifyNoDuplicates(ArrayList<Month> originalList, HashSet<Month> hashSet) {
        if (!(originalList.size() == hashSet.size())) {
            throw new RuntimeException("La cantidad de elementos no coincide, ha habido duplicados.");
        }
    }
}