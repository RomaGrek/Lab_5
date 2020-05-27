package commands;

import commands.CommandPusk;
import general.GeneralCollection;

import java.util.ConcurrentModificationException;
/**
 * Класс, реализующий программу remove_lower id, которая удаляет из коллекции все элементы, значение id которого меньше чем заданный пользователем
 */
public class RemoveLower implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public RemoveLower() {
        CommandPusk.addCommand("remove_lower", this);
    }

    /**
     * Идет проверка на валидность введнного id, если введенное значение валидно, то вызывается метод {@link GeneralCollection#removeLower(Integer)}
     * @param name строковое значение, аргумент команды (id)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        try {
            Integer isis = Integer.parseInt(name);
            if (isis > 0) {
                generalCollection.removeLower(isis);
            } else {
                System.out.println("id должен быть положительным числом");
            }
        }catch(NumberFormatException e){
            System.out.println("Id должен быть полным числом");
        }
    }
}
