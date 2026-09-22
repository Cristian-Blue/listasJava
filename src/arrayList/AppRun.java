package arrayList;

import java.util.ArrayList; 
public class AppRun {

    public void run() {
        ArrayList<Integer> arreglo = new ArrayList<>();
        arreglo.add(1);
        arreglo.add(2);
        arreglo.add(3);

        arreglo.remove(1);
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.println(arreglo.get(i) + " i:" + i);
        }
        arreglo.add(1, 2);
        arreglo.forEach(res -> {
            System.out.println(res);
        });
        System.out.println("...............");
        System.out.println(
                arreglo.contains(2));
        System.out.println(
                arreglo.contains(5));
        for (Integer num : arreglo) {
            System.out.println(num);
        }
        arreglo.clear();
        System.out.println("Clear");
        for (Integer num : arreglo) {
            System.out.println(num);
        }

    }
}