package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу count_by_weapon_type weaponType, которая выводит количество элементов, значение поля weaponType которых равно заданному
 */
public class CountByWeaponType implements CommandDo{
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public CountByWeaponType() {
        CommandPusk.addCommand("count_by_weapon_type", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#countByWeaponType(String)}
     * @param name строковое значение, аргумент команды
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        generalCollection.countByWeaponType(name);
    }
}
