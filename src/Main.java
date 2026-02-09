import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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

        ArrayList<Month> monthList = new ArrayList<>(List.of(
                month1, month2, month3, month4, month5, month6, month7, month9, month10, month11, month12, month13));

        monthList.add(7, month8);

        ArrayList<String> monthOrder=new ArrayList<String>(List.of(
                "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
                "Agosto","Septiembre","Octubre","Noviembre","Diciembre"));


        orderValidator(monthList,monthOrder);
        // positionValidator(monthList, 7, "Agosto");
        HashSet<Month> monthHash = convertArrayListToHashSet(monthList);
        verifyNoDuplicates(monthList, monthHash);

        Iterator<Month> iterator = monthList.listIterator();

        while (iterator.hasNext()) {
            Month month = iterator.next();
            System.out.println(month.getName());
        }
    }

    public static void orderValidator(ArrayList<Month> monthList, ArrayList<String> monthOrder){
        int i=0;
        for (Month month : monthList){
            if(!(month.getName().equals(monthOrder.get(i%12)))){
                throw new RuntimeException("El mes " + month.getName() + " no es válido.");
            }
            i++;
        }
    }

    /*
    public static void positionValidator(ArrayList<Month> months, int index, String name) {
        boolean val = (months.get(index)).getName().equals(name);
        if (!val) {
            throw new RuntimeException("La posición de " + name + " no es válida");
        }
    }
     */

    public static HashSet<Month> convertArrayListToHashSet(ArrayList<Month> list) {
        return new HashSet<>(list);
    }

    public static void verifyNoDuplicates(ArrayList<Month> originalList, HashSet<Month> hashSet) {
        if (!(originalList.size() == hashSet.size())) {
            throw new RuntimeException("La cantidad de elementos no coincide, ha habido duplicados.");
        }
    }
}