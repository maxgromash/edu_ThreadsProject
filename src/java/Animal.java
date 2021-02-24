class Animal implements Runnable
{
    private final double degree;
    private final double s;
    private final int sleepTime;
    private final int pushingLimit;

    /**
     * Основной конструктор
     * @param degree Угол
     * @param s Время, которые животное тянет телегу
     * @param sleepTime Время, которое отдыхает животное
     * @param pushingLimit Время, после которого животное перестаёт тянуть телегу
     */
    public Animal(double degree, double s, int sleepTime, int pushingLimit) {
        this.degree = Math.toRadians(degree);
        this.s = s;
        this.sleepTime = sleepTime;
        this.pushingLimit = pushingLimit*1000;
    }

    /**
     * Переопределенный метод run
     * Животное тащит телегу время s, а потом отдыхает sleepTime
     */
    @Override
    public void run() {
        double timeOfThrusts = 0;
        while (timeOfThrusts < pushingLimit){
            synchronized (Main.dray) {
                Main.dray.pull(s, degree);
                timeOfThrusts += sleepTime;
            }
            if (timeOfThrusts < pushingLimit)
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ignored) { }
        }
    }
}