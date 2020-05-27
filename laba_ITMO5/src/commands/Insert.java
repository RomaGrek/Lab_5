package commands;

import general.GeneralCollection;
/**
 * Класс, реализующий программу insert key, которая добавляет новый элемент с заданным ключом
 */
public class Insert implements CommandDo {
    /**
     * Конструктор по умолчанию, который добавляет объект класса команды в коллекцию команд
     */
    public Insert() {
        CommandPusk.addCommand("insert", this);
    }

    /**
     * Сначала идет проверка на наличие элмента в коллекции {@link GeneralCollection#getGenCollection()} c таким ключом, если есть то предлагается выбор заменить элемент коллекции или нет. Если элемента с таким ключом нету то вызывается метод {@link GeneralCollection#addHumanBeing(Integer)}
     * @param name строковое значение, аргумент команды (ключ)
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    @Override
    public void doing(String name, GeneralCollection generalCollection) { // сделать проверку, нет ли уже такого ключа в коллекции
        try {
            Integer ret = Integer.parseInt(name);
            boolean s = true;
                if (generalCollection.getGenCollection().get(ret) != null) {
                    while (s) {
                        System.out.println("Эелемнет с данным ключом уже есть в коллекции, хотите заменить эелемент коллекции? yes/no ");
                        String tip = generalCollection.scanLine();
                        if (tip.equals("yes")) {
                            s = false;
                            generalCollection.addHumanBeing(ret);
                            System.out.println("Объект с ключем: " + ret + " добавлен в коллецию");
                        } else if (tip.equals("no")) {
                            s = false;
                            break;
                        } else {
                            System.out.println("Вы ввели некорректное значение");
                        }
                    }
                } else {
                    generalCollection.addHumanBeing(ret);
                    System.out.println("Объект с ключем: " + ret + " добавлен в коллецию");
                }
        } catch (NumberFormatException e) {
            System.out.println("Ключ должен быть типа целым числом");
        }
    }
}
