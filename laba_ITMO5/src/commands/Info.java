package commands;

import commands.CommandDo;
import commands.CommandPusk;
import general.GeneralCollection;
/**
 * Класс, реализующий программу info, которая выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, кол-во элементов и тд)
 */
public class Info implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public Info() {
        CommandPusk.addCommand("info", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#info()}
     * @param name строковое значение, аргумент команды(null)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        try {
            generalCollection.info();
        }catch (NullPointerException e) {
            System.out.println("В коллекции отсутствуют элементы");
        }
    }
}
