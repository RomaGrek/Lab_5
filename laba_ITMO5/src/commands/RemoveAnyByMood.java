package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу remove_any_by_mood mood, которая удаляет из коллекции один элемент, значение поля mood которого эквивалентно заданному
 */
public class RemoveAnyByMood implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public RemoveAnyByMood() {
        CommandPusk.addCommand("remove_any_by_mood", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#removeAnyByMood(String)}
     * @param name строковое значение, аргумент команды (mood)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        generalCollection.removeAnyByMood(name);
    }
}
