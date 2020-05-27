package general;

/**
 * Класс Coordinates
 */

public class Coordinates {
    /**Поле для координаты x*/
    private float x;
    /**Поле для координаты y*/
    private Integer y;       //Поле не может быть null
    /**
     * Конструктор с координатами x и y
     * @param x X
     * @param y Y
     */
    public Coordinates(float x, Integer y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Геттер x
     * @return поле x
     */
    public Float getX() {
        return x;
    }
    /**
     * Геттер  y
     * @return поле y
     */
    public Integer getY() {
        return y;
    }
    /**
     * Сеттер для x
     * @param x x
     */
    public void setX(Float x) {
        this.x = x;
    }
    /**
     * Сеттер для y
     * @param y y
     */
    public void setY(Integer y) {
        this.y = y;
    }
    /**
     * Переопределение метода toString
     * @return Строковое представление класса
     */
    @Override
    public String toString() {
        return "x = " + getX() + "; y = " + getY();
    }
}
