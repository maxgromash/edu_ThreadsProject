import java.util.Random;

public class Main {
    static final Random rand = new Random();
    public static final Dray dray = new Dray();
    private static int pushingLimit = 25;

    /**
     * Дополнительный функционал:
     * третьим параметром командной строки можно указать время, когда животные будет уставать окончательно
     * @param args аргументы командной строки (х, у, время усталости животного)
     */
    public static void main(String[] args) {
        parseInput(args);

        //Создание потоков животных и отдельного потока для вывод значений на экран
        Thread crayfish = new Thread(new Animal(180, randPullTime(), randSleepTime(), pushingLimit));
        Thread swan = new Thread(new Animal(60, randPullTime(), randSleepTime(), pushingLimit));
        Thread pike = new Thread(new Animal(300, randPullTime(), randSleepTime(), pushingLimit));

        //Запускаем потоки
        crayfish.start();   //Потоки животных
        swan.start();
        pike.start();

        while (swan.isAlive() || pike.isAlive() || crayfish.isAlive()) {
            System.out.println(dray.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) { }
        }

        System.out.println("Итоговые координаты телеги: " + dray.toString());
    }

    /**
     * Метод парсит входные значения, при неудаче выставляет дефолтные значения
     * @param args введённые в командную строку при запуске парамеметры
     */
    public static void parseInput(String[] args){
        int[] res = new int[3];

        for (int i=0; i<3; i++){
            try {
                res[i] = Integer.parseInt(args[i]);
                if (i == 2)
                    System.out.println("Время усталости животного: " + res[2] + " секунд");
            } catch(NumberFormatException ex){
                if (i==2)
                    System.out.println("Выставлено стандартное значение времени усталости животного: 25 секунд");
                    else
                {
                    String s = i == 0 ? "x" : "y";
                    System.out.println("Неверный формат данных для " + s + ", выставлено стандартное значение 0");
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}
        }

        if (res[0]!=0 || res[1]!=0)
            dray.setNewCord(res[0], res[1]);
        if (res[2] > 0 && res[2] != 25)
            pushingLimit = res[2];
    }

    /**
     * Метод генерирует случайное целое число из диапазона [1000;5000)
     * @return случайное целое число из диапазона
     */
    public static int randSleepTime(){
        return 1000+ rand.nextInt(4000);
    }

    /**
     * Метод генерирует случайное вещественное число из диапазона [1;10)
     * @return случайное вещественное число из диапазона
     */
    public static double randPullTime(){
        return 9*rand.nextDouble()+1;
    }
}