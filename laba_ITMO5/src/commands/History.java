package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу history, которая выводит последние 13 команд, введенных пользователем (без аргументов)
 */
public class History implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public History() {
        CommandPusk.addCommand("history", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#history()}
     * @param name строковое значение, аргумент команды(null)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        generalCollection.history();
    }
}
