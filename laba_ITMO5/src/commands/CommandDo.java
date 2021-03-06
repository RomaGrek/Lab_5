package commands;

import general.GeneralCollection;
/**
 * интерфейс для выполнения команд
 */
public interface CommandDo {
    /**
     * @param name строковое значение, аргумент команды
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    void doing(String name, GeneralCollection generalCollection);
}
