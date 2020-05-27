package commands;

import general.GeneralCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс управления командами командами
 */
public class CommandPusk {
    /** Карта команд. Ключ - строковое название команды. Значение - классы, реализующие интерфейс CommandDo*/
    private  static Map<String, CommandDo> commands = new HashMap<>();
    /** Массив для хранения истории ввода команд пользователем*/
    public static ArrayList<String> historyCommands = new ArrayList<>();
    /** Массив для хранения команд, которые обрабатываются командо execute_script*/
    public static ArrayList<String> runScripts = new ArrayList<>();

    /**
     * Метод создания истории команд введнных пользователем
     * @param commandDo объект команды
     */
    public static void historyCom(String commandDo) {
        if(historyCommands.size() > 12) {
            historyCommands.remove(0);
        }
        historyCommands.add(commandDo);
    }

    /**
     *
     * @param name имя команды (ключ)
     * @param commandDo объект команды
     */
    public static void addCommand(String name, CommandDo commandDo) {
        commands.put(name, commandDo);
    }

    /**
     * Введенная строка пользователем разбивается на две строки по пробелу, если второй строка пустая то вызывается метод {@link CommandDo#doing(String, GeneralCollection)} с первым аргументом null, если вторая строка не пустая то так же запускается метод {@link CommandDo#doing(String, GeneralCollection)} и в первый аргумент передается вторая строка
     * @param words строка введенная пользователем
     * @param generalCollection класс с коллекцией, над которой производятся действия
     */
    public static void doing(String words, GeneralCollection generalCollection) {
        String[] partsWords = words.split(" ");
        if (words.isEmpty()) {
            return;
        }
        if (partsWords.length == 1) {    // если введено одно слово
            CommandDo commandDo = commands.get(partsWords[0]);
            if(commandDo != null) {    // проверка на правильность программы
                historyCom(partsWords[0]);   // добавляем в коллекцию истории введнную команду
                commandDo.doing(null, generalCollection);
            } else {
                System.out.println("Команды не существует");
            }
        } else if (partsWords.length == 2) {  // если введено 2 слова
            CommandDo commandDo = commands.get(partsWords[0]);
            String kek = partsWords[1];
            if (commandDo != null) {
                historyCom(partsWords[0]);
                commandDo.doing(kek, generalCollection);
            } else {
                System.out.println("Команды не существует");
            }
        } else {
            System.out.println("Невенрный ввод команды");
        }

    }

}
