package commands;

import commands.CommandPusk;
import general.GeneralCollection;
/**
 * Класс, реализующий программу exit, которая завершает программу (без сохранения в файл)
 */
public class Exit implements CommandDo{
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public Exit() {
        CommandPusk.addCommand("exit", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#exit()}
     * @param name строковое значение, аргумент команды(null)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        generalCollection.exit();
    }
}
