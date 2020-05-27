package general;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import commands.CommandPusk;


import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;
/**
 * Класс для дерева с объектами HumanBeing и его управлением
 */
public class GeneralCollection {
    /**Поле genCollection, ключи - Integer, значения - HumanBeing*/
    private TreeMap<Integer, HumanBeing> genCollection = new TreeMap<>();

    /**
     * Чтение данных из файла HumanBeing.json генерация id происходит автоматически в диапазоне от 0 до 10000
     * @throws IOException ошибка пользовательского ввода
     */
    public GeneralCollection() throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("HumanBeing.json")) {
            Type foundMap = new TypeToken<TreeMap<Integer, HumanBeing>>(){}.getType();
            genCollection = gson.fromJson(reader, foundMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выводит справку по доступным командам
     */
    public static void help() {
        System.out.println("help : вывести справку по доступным командам \n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                "insert Integer {element} : добавить новый элемент с заданным ключём \n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному \n" +
                "remove_key Integer : удалить элемент из коллекции по его ключу \n" +
                "clear : очистить коллекцию \n" +
                "save : сохранить коллекцию в файл \n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n" +
                "remove_lower id {element} : удалить из коллекции все элементы, меньшие, чем заданный \n" +
                "remove_lower_key Integer : удалить из коллекции все элементы, ключ которых меньше, чем заданный \n" +
                "history : вывести последние 13 команд (без их аргументов) \n" +
                "remove_any_by_mood mood : удалить из коллекции один элемент, значение поля mood которого эквивалентно заданному \n" +
                "sum_of_impact_speed : вывести сумму значений поля impactSpeed для всех элементов коллекции \n" +
                "count_by_weapon_type weaponType : вывести количество элементов, значение поля weaponType которых равно заданному \n" +
                "exit : завершить программу (без сохранения в файл) \n");

    }

    /**
     * Выводит все элементы коллекции в строковом представлении
     */
    public void show() {
        if (!genCollection.isEmpty()) {
            for (Integer key : genCollection.keySet()) {
                System.out.println("Key: " + key + " Value: " + genCollection.get(key).toString());
            }
        } else {
            System.out.println("Коллекция пуста.");
        }
    }

    /**
     * Завершает программу (без сохранения в файл)
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Удаляет все элементы из коллекции
     */
    public void clear() {
        if (genCollection.size() == 0) {
            System.out.println("Коллекция уже пуста");
        } else {
            genCollection.clear();
        }
    }

    /**
     * Выводит 13 последних команд, введенных пользователем
     */
    public void history() {
        for (int i = 0; i < CommandPusk.historyCommands.size(); i++) {
            System.out.println(CommandPusk.historyCommands.get(i));
        }
    }

    /**
     * Выводит информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     */
    public void info() {
        System.out.println("Тип: HumanBeing\n"
                + "Дата инициализации: " + genCollection.get(0).getCreationDate() + '\n'
                + "Количество элементов: " + genCollection.size());
    }

    /**
     * Удаляет элемент коллекции, ключ которого равен введенному
     * @param key ключ
     */
    public void removeKey(Integer key) {
        genCollection.remove(key);
    }

    /**
     * Геттер genCollection
     * @return возвращает коллекцию
     */
    public TreeMap<Integer, HumanBeing> getGenCollection() {
        return genCollection;
    }

    /**
     * Считает сумму значений поля impactSpeed для всех элементов коллекции
     */
    public void sumOfIpactSpeed() {
        int sum = 0;
        for (Integer key : getGenCollection().keySet()) {
            sum = sum + getGenCollection().get(key).getImpactSpeed();
        }
        System.out.println("Cумма значений поля impactSpeed для всех элементов коллекции = " + sum);
    }

    /**
     * Выводит количесвто элементов, значение поля weaponType которых, равно заданному
     * @param name weaponType
     */
    public void countByWeaponType(String name) {
        int moodSum = 0;
        boolean dod = true;
        if (name.equals("pistol")) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getWeaponType().equals(WeaponType.PISTOL)) {
                    moodSum = moodSum + 1;
                }
            }
        } else if (name.equals("machine_gan")) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getWeaponType().equals(WeaponType.MACHINE_GAN)) {
                    moodSum = moodSum + 1;
                }
            }
        } else if (name.equals("bat")) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getWeaponType().equals(WeaponType.BAT)) {
                    moodSum = moodSum + 1;
                }
            }
        } else if (name.equals("hammer")) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getWeaponType().equals(WeaponType.HAMMER)) {
                    moodSum = moodSum + 1;
                }
            }
        } else if (name.equals("knife")) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getWeaponType().equals(WeaponType.KNIFE)) {
                    moodSum = moodSum + 1;
                }
            }
        } else {
            System.out.println("Вы ввели некорректный тип оружия, введите тип оружия из списка:\n" + "knife\n" + "hammer\n" + "bat\n" + "machine_gun\n" + "pistol\n");
            dod = false;
        }
        if (dod) {
            System.out.println(moodSum);
        }
    }

    /**
     * Удаляет из коллекции один элемент коллекции, значение поля mood которого, равно введенному пользовтелю значению
     * @param name mood
     */
    public void removeAnyByMood(String name) {
        int sizeDoRem = genCollection.size();
        metka:
        if (name.equals("sorrow") && (getGenCollection().size() == sizeDoRem)) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getMood().equals(Mood.SORROW)) {
                    getGenCollection().remove(key);
                    break metka;
                }
            }
        } else if (name.equals("rage") && (getGenCollection().size() == sizeDoRem)) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getMood().equals(Mood.RAGE)) {
                    getGenCollection().remove(key);
                    break metka;
                }
            }
        } else if (name.equals("frenzy") && (getGenCollection().size() == sizeDoRem)) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getMood().equals(Mood.FRENZY)) {
                    getGenCollection().remove(key);
                    break metka;
                }
            }
        } else if (name.equals("null") && (getGenCollection().size() == sizeDoRem)) {
            for (Integer key : getGenCollection().keySet()) {
                if (getGenCollection().get(key).getMood() == null) {
                    getGenCollection().remove(key);
                    break metka;
                }
            }
        }
        else {
            System.out.println("Вы ввели некорректный тип поля mood, введите тип поля mood из списка:\n" + "rage\n" + "frenzy\n" + "sorrow\n");
        }
    }

    /**
     * Удаляет из коллекции все элементы id которых меньше заданного
     * @param id id
     */
    public void removeLower(Integer id) {
        List<Integer> keys = new ArrayList<>();
        for (Integer key : getGenCollection().keySet()) {
            if (getGenCollection().get(key).getId() < id) {
                keys.add(key);
            }
        }
        for (Integer key : keys) {
            getGenCollection().remove(key);
        }
    }

    /**
     * Удаляет из коллекции все элементы, ключ которых меньше чем заданный
     * @param keyi ключ
     */
    public void removeLowerKey(Integer keyi) {
        List<Integer> keyp = new ArrayList<>();
        for (Integer key : getGenCollection().keySet()) {
            if (key < keyi) {
                keyp.add(key);
            }
        }
        for (Integer integer : keyp) {
            getGenCollection().remove(integer);
        }
    }

    /**
     * Добавляет новый элемент в коллекцию
     * @param key Ключ
     */
    public void addHumanBeing(Integer key) { // метода для создания нового обьекта и помещение его в коллекцию
        HumanBeing humanBeing1 = new HumanBeing(scanName(), scanCoordinates(), scanRealHero(), scanHasToothpick(), scanImpactSpeed(), scanWeaponType(), scanMood(), scanCar());
        getGenCollection().remove(key);
        getGenCollection().put(key, humanBeing1);
    }

    /**
     * Считывает поле name
     * @return name
     */
    public String scanName() {
        System.out.println("Введите имя:");
        Scanner in = new Scanner(System.in);
        String go = in.nextLine();
        while (go.isEmpty()) {
            System.out.println("Имя не может быть пустым! Пожалуйста, введите имя:");
            go = in.nextLine();
        }
        return go;
    }
    /**
     * Считывает строку, введенную пользователем
     * @return строка, введенная пользователем
     */
    public String scanLine() {
        Scanner im = new Scanner(System.in);
        String ups = im.nextLine();
        while (ups.isEmpty()) {
            System.out.println("Вы ввели пустую строку. Пожалуйста, повторите ввод.");
            ups = im.nextLine();
        }
        return ups;
    }

    /**
     * Считывает координаты
     * @return координаты
     */
    public Coordinates scanCoordinates() {
        Float inputX = null;
        Integer inputY = null;
        while (inputX == null) {
            System.out.println("Введите х координату: ");
            try {
                inputX = Float.parseFloat(scanLine());
            } catch (NumberFormatException e) {
                System.out.println("Координата х должна быть числом.");
            }
        }
        System.out.println("Введите у координату: ");
        while (inputY == null) {
            try {
                inputY = Integer.parseInt(scanLine());
            } catch (NumberFormatException e) {
                System.out.println("Координата у должна быть числом.");
            }
        }
        Coordinates coordinates = new Coordinates(inputX, inputY);
        return coordinates;
    }

    /**
     * Считывает поле realHero
     * @return true/false
     */
    public Boolean scanRealHero() {
        System.out.println("Это реальный герой? (true/false)");
        String inputRealHero = scanLine().toLowerCase();
        while (!(inputRealHero.equals("false") || inputRealHero.equals("true"))) {
            System.out.println("Невалидное значение, введите (true/false).\nЭто реальный герой?");
            inputRealHero = scanLine().toLowerCase();
        }
        return Boolean.parseBoolean(inputRealHero);
    }

    /**
     * Считывает поле hasToothpick
     * @return true/false
     */
    public boolean scanHasToothpick() {
        System.out.println("У него есть зубочистка? (true/false)");
        String inputHasToothpick = scanLine().toLowerCase();
        while (!(inputHasToothpick.equals("false") || inputHasToothpick.equals("true"))) {
            System.out.println("Некорректное значение. Введите true или false.\nУ него есть зубочистка?");
            inputHasToothpick = scanLine().toLowerCase();
        }
        return Boolean.parseBoolean(inputHasToothpick);
    }

    /**
     * Считывает поле inmpactSpeed
     * @return int (значение скорости)
     */
    private int scanImpactSpeed() {
        System.out.println("Введите значение скорости (`Минимальное значение: -354): ");
        int ImpactSpeed = 0;
        boolean as = true;
        while (as) {
            try {
                ImpactSpeed = Integer.parseInt(scanLine());
                if (ImpactSpeed <= -354) {
                    System.out.println("Значение скорости должно быть не ниже -354.\nВведите значение скорости: ");
                } else {
                    as = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Скорость должны быть числом.\nВведите значение скорости: ");
            }
        }
        return ImpactSpeed;
    }

    /**
     * Считывает тип оружия
     * @return weaponType
     */
    public WeaponType scanWeaponType(){
        WeaponType weaponType = null;
        boolean dw = true;
        while (dw) {
            System.out.println("Введите тип оружия персонажа из списка:\n" + "knife\n" + "hammer\n" + "bat\n" + "machine_gun\n" + "pistol\nЕсли оружения нет, просто нажмите Enter\n");
            Scanner im = new Scanner(System.in);
            String pol = im.nextLine();
            switch (pol) {
                case "knife":
                    weaponType = WeaponType.KNIFE;
                    dw = false;
                    break;
                case "machine_gan":
                    weaponType = WeaponType.MACHINE_GAN;
                    dw = false;
                    break;
                case "pistol":
                    weaponType = WeaponType.PISTOL;
                    dw = false;
                    break;
                case "hammer":
                    weaponType = WeaponType.HAMMER;
                    dw = false;
                    break;
                case "bat":
                    weaponType = WeaponType.BAT;
                    dw = false;
                    break;
                case "":
                    weaponType = null;
                    dw = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный тип оружия");
                    break;
            }
        }
        return weaponType;
    }

    /**
     * Считывает тип настроения
     * @return mood
     */
    public Mood scanMood(){
        boolean qrt = true;
        Mood mood = null;
        while (qrt) {
            System.out.println("Введите тип настроения из списка:\n" + "rage\n" + "frenzy\n" + "sorrow\nЕсли оружения нет, просто нажмите Enter");
            Scanner im = new Scanner(System.in);
            String poy = im.nextLine();
            switch (poy) {
                case "sorrow":
                    mood = Mood.SORROW;
                    qrt = false;
                    break;
                case "rage":
                    mood = Mood.RAGE;
                    qrt = false;
                    break;
                case "frenzy":
                    mood = Mood.FRENZY;
                    qrt = false;
                    break;
                case "":
                    mood = null;
                    qrt = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный тип настроения");
                    break;
            }
        }
        return mood;
    }

    /**
     * Считывает машину
     * @return car
     */
    public Car scanCar() {
        Car car = new Car();
        System.out.println("Введите название машины:");
        String fer = scanLine();
        while (fer.isEmpty()) {
            System.out.println("Имя машины не может быть пустым, введите пожалуйста имя:");
            fer = scanLine();
        }
        car.setName(fer);
        return car;
    }

    /**
     * Получение ключа элемента по его id
     * @param id id элемента
     * @return ключ если существует элемент с данным id, если же наоборот то возвращается null
     */
    public Integer getKeyById(Integer id){
        for (int key : genCollection.keySet()){
            if (Objects.equals(genCollection.get(key).getId(), id)){
                return key;
            }
        }
        return null;
    }

    /**
     * Сохраняет коллекцию в файл afterHumanBeing.json
     */
    public void save() {
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("afterHumanBeing.json"))) {
            Gson gson = new Gson();
            String json = gson.toJson(genCollection);
            stream.write(json.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


