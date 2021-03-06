package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу show, которая выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class Show implements CommandDo{
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public Show() {
        CommandPusk.addCommand("show", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#show()}
     * @param name строковое значение, аргумент команды(null)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        generalCollection.show();
    }
}
