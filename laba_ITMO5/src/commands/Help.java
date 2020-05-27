package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу help, которая выводит справку по доступным командам
 */
public class Help implements CommandDo{
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public Help() {
        CommandPusk.addCommand("help", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#help()}
     * @param name строковое значение, аргумент команды(null)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    public void doing(String name, GeneralCollection generalCollection) {
        GeneralCollection.help();
    }
}
