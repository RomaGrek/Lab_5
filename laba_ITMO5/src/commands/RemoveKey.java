package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу remove_key key, которая удаляет элемент коллекции по его ключу
 */
public class RemoveKey implements CommandDo{
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public RemoveKey() {
        CommandPusk.addCommand("remove_key", this);
    }

    /**
     * Идет проверка на наличии в коллекции {@link GeneralCollection#getGenCollection()} элемента с таким ключем, если элемент существует, то вызывается метод {@link GeneralCollection#removeKey(Integer)}
     * @param name строковое значение, аргумент команды (ключ)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) {
        try {
            Integer key = Integer.parseInt(name);
            if(generalCollection.getGenCollection().get(key) == null) {
                System.out.println("Элемента с таким ключом не существует, используйте \"show\" что бы посмотреть элементы коллекции.");
            } else {
                generalCollection.removeKey(key);
            }
        }catch (NumberFormatException e) {
            System.out.println("Ключ должен быть типа Integer");
        }
    }
}
