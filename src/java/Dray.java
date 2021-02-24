/**
 * Вспомогательный класс телеги
 */
class Dray{
    private double x=0,y=0;

    public void setNewCord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Метод толчка телеги
     * @param s Постоянная для рассчета
     * @param degree Угол толчка в радианах
     */
    public void pull(double s, double degree){
        x += s * Math.cos(degree);
        y += s * Math.sin(degree);
    }

    /**
     * Переопределенный метод преобразования телеги в строку
     * @return строковое представление координат
     */
    @Override
    public String toString() {
        return String.format("%.2f %.2f", x, y);
    }
}