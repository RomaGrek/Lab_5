package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу sum_of_impact_speed, которая выводит сумму значений поля impactSpeed для всех элементов коллекции
 */
public class SumOfImpactSpeed implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public SumOfImpactSpeed() {
        CommandPusk.addCommand("sum_of_impact_speed", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#sumOfIpactSpeed()}
     * @param name строковое значение, аргумент команды(null)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        generalCollection.sumOfIpactSpeed();
    }
}
