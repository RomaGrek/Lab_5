package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу remove_lower_key key, которая удаляет из коллекции все элементы, ключ которых меньше, чем заданный пользователем
 */
public class RemoveLowerKey implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public RemoveLowerKey() {
        CommandPusk.addCommand("remove_lower_key", this);
    }

    /**
     * Обращение к методу {@link GeneralCollection#removeLowerKey(Integer)}
     * @param name строковое значение, аргумент команды(key)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        try {
            Integer isiq = Integer.parseInt(name);
                generalCollection.removeLowerKey(isiq);
        }catch(NumberFormatException e){
            System.out.println("Ключ должен быть полным числом");
        }
    }
}
