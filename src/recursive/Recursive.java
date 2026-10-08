package recursive;

public class Recursive {

    public int countDown(int i) {
        System.out.println("ENTRO: countDown(" + i + ")");

        if (i == 0) {
            System.out.println("CASO BASE: ¡TIEMPO!");
            System.out.println("SALE: countDown(0) retorna 0");
            return 0;
        }

        System.out.println("CUENTA REGRESIVA: " + i);

        int calc = i - 1;

        System.out.println("ESPERANDO: countDown(" + i + ") "
                + "queda esperando a countDown(" + calc + ")");

        int resultado = countDown(calc);

        System.out.println("REGRESO: countDown(" + i + ") "
                + "recibio el resultado: " + resultado);

        System.out.println("SALE: countDown(" + i + ") "
                + "retorna " + resultado);

        return resultado;
    }

    public int sumInteral(int i) {
        System.out.println("ENTRO: sumInteral(" + i + ")");

        if (i == 0) {
            System.out.println("CASO BASE: sumInteral(0) retorna 0");
            return 0;
        }

        System.out.println("ESPERANDO: sumInteral(" + i + ") "
                + "espera a sumInteral(" + (i - 1) + ")");

        int result = i + sumInteral(i - 1);

        System.out.println("REGRESO: sumInteral(" + i + ") "
                + "recibio el resultado y calcula: "
                + i + " + " + (result - i) + " = " + result);

        System.out.println("SALE: sumInteral(" + i + ") retorna " + result);

        return result;
    }

    public static void countUp(int number) {
        System.out.println("ENTRO: countUp(" + number + ")");

        if (number == 0) {
            System.out.println("CASO BASE: ¡LLEGÓ A CERO!");
            System.out.println("SALE: countUp(0) termina");
            return;
        }

        int calc = number - 1;

        System.out.println("ESPERANDO: countUp(" + number + ") "
                + "queda esperando a countUp(" + calc + ")");

        countUp(calc);

        System.out.println("REGRESO: countUp(" + number + ") "
                + "terminó la llamada a countUp(" + calc + ")");

        System.out.println("IMPRIMIENDO: " + number);

        System.out.println("SALE: countUp(" + number + ") termina");
    }

    public static void countUp(int number, int limit) {
        System.out.println("ENTRO: countUp(" + number + ", " + limit + ")");

        if (number > limit) {
            System.out.println("CASO BASE: " + number
                    + " superó el límite " + limit);
            System.out.println("SALE: countUp(" + number + ", " + limit + ") termina");
            return;
        }

        System.out.println("IMPRIMIENDO: " + number);

        int calc = number + 1;

        System.out.println("ESPERANDO: countUp(" + number + ", " + limit + ") "
                + "queda esperando a countUp(" + calc + ", " + limit + ")");

        countUp(calc, limit);

        System.out.println("REGRESO: countUp(" + number + ", " + limit + ") "
                + "terminó la llamada a countUp(" + calc + ", " + limit + ")");

        System.out.println("SALE: countUp(" + number + ", " + limit + ") termina");
    }
}
