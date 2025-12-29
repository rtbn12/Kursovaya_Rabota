import java.util.Scanner;

public class Keyboard extends Peripheral{


    private String keyboardType;        // Тип (механическая, мембранная, гибридная)
    private int countKey;               // Количество клавиш
    private String switchType;          // Тип переключателей (для механических)
    private String layout;              // Раскладка (RU, EN, EU)
    private boolean hasNumpad;          // Наличие цифрового блока



    public Keyboard(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setKeyboardType(scanner);
        setCountKey(scanner);
        setSwitchType(scanner);
        setLayout(scanner);
        setHasNumpad(scanner);
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(Scanner scanner) {
        boolean cycleKeyboardType = true;
        while (cycleKeyboardType) {
            System.out.print("\nВыберите тип клавиатуры:\n" +
                    "1 - Механическая\n" +
                    "2 - Мембранная\n" +
                    "3 - Ножничная (ноутбучная)\n" +
                    "4 - Гибридная\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.keyboardType = "Механическая";
                        cycleKeyboardType = false;
                        break;
                    case 2:
                        this.keyboardType = "Мембранная";
                        cycleKeyboardType = false;
                        break;
                    case 3:
                        this.keyboardType = "Ножничная (ноутбучная)";
                        cycleKeyboardType = false;
                        break;
                    case 4:
                        this.keyboardType = "Гибридная";
                        cycleKeyboardType = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public int getCountKey() {
        return countKey;
    }

    public void setCountKey(Scanner scanner) {
        boolean cycleCountKey = true;
        while (cycleCountKey) {
            System.out.print("\nВведите количество клавиш (61, 68, 87, 104, 108): ");

            try {
                int countKey = scanner.nextInt();
                scanner.nextLine();

                int[] validKeys = {61, 68, 87, 104, 108};
                boolean isValid = false;

                for (int keys : validKeys) {
                    if (countKey == keys) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректное количество клавиш!\n" +
                            "Введите значение ещё раз (61, 68, 87, 104, 108 клавиш): ");
                    countKey = scanner.nextInt();
                    scanner.nextLine();

                    for (int keys : validKeys) {
                        if (countKey == keys) {
                            isValid = true;
                            break;
                        }
                    }
                }

                this.countKey = countKey;
                cycleCountKey = false;

            } catch (java.util.InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(Scanner scanner) {
        // Тип переключателей только для механических клавиатур
        if (!"Механическая".equals(this.keyboardType)) {
            this.switchType = "Нет";
            return;
        }

        boolean cycleSwitchType = true;
        while (cycleSwitchType) {
            System.out.print("\nВыберите тип механических переключателей:\n" +
                    "1 - Cherry MX Red (линейные)\n" +
                    "2 - Cherry MX Blue (кликающие)\n" +
                    "3 - Cherry MX Brown (тактильные)\n" +
                    "4 - Cherry MX Black (линейные тяжелые)\n" +
                    "5 - Gateron Red\n" +
                    "6 - Gateron Blue\n" +
                    "7 - Gateron Brown\n" +
                    "8 - Outemu\n" +
                    "9 - Kailh\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.switchType = "Cherry MX Red";
                        cycleSwitchType = false;
                        break;
                    case 2:
                        this.switchType = "Cherry MX Blue";
                        cycleSwitchType = false;
                        break;
                    case 3:
                        this.switchType = "Cherry MX Brown";
                        cycleSwitchType = false;
                        break;
                    case 4:
                        this.switchType = "Cherry MX Black";
                        cycleSwitchType = false;
                        break;
                    case 5:
                        this.switchType = "Gateron Red";
                        cycleSwitchType = false;
                        break;
                    case 6:
                        this.switchType = "Gateron Blue";
                        cycleSwitchType = false;
                        break;
                    case 7:
                        this.switchType = "Gateron Brown";
                        cycleSwitchType = false;
                        break;
                    case 8:
                        this.switchType = "Outemu";
                        cycleSwitchType = false;
                        break;
                    case 9:
                        this.switchType = "Kailh";
                        cycleSwitchType = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(Scanner scanner) {
        boolean cycleLayout = true;
        while (cycleLayout) {
            System.out.print("\nВыберите раскладку клавиатуры (можно выбрать несколько цифр через пробел):\n" +
                    "1 - Русская (RU)\n" +
                    "2 - Английская (US)\n" +
                    "3 - Европейская (EU)\n" +
                    "4 - Японская (JP)\n" +
                    "5 - Китайская (CN)\n" +
                    "6 - Двуязычная (RU/EN)\n" +
                    "Введите номера выбранных раскладок (например: 1 2 6): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedLayouts = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("RU");
                                break;
                            case 2:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("US");
                                break;
                            case 3:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("EU");
                                break;
                            case 4:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("JP");
                                break;
                            case 5:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("CN");
                                break;
                            case 6:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("RU/EN");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedLayouts.length() == 0) {
                    System.out.println("Вы не выбрали ни одной раскладки! Пожалуйста, выберите хотя бы одну.");
                    continue;
                }

                this.layout = selectedLayouts.toString();
                cycleLayout = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }
    }

    public boolean isHasNumpad() {
        return hasNumpad;
    }

    public void setHasNumpad(Scanner scanner) {
        boolean cycleHasNumpad = true;
        while (cycleHasNumpad) {
            System.out.print("\nЕсть ли у клавиатуры цифровой блок (numpad)?\n" +
                    "Введите:\n" +
                    "1 - Да, цифровой блок присутствует\n" +
                    "0 - Нет, цифровой блок отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        this.hasNumpad = false;
                        cycleHasNumpad = false;
                        break;
                    case 1:
                        this.hasNumpad = true;
                        cycleHasNumpad = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice());
        System.out.println("Тип клавиатуры : " + getKeyboardType());
        System.out.println("Количество клавиш: " + getCountKey());
        System.out.println("Тип переключателей: " + getSwitchType());
        System.out.println("Раскладка: " + getLayout());
        System.out.println("Наличие цифрового блока: " + (isHasNumpad() ? "Да" : "Нет"));
        System.out.println("Цвет устройства: " + getColor());
        System.out.println("Доступные типы подключения: " + getConnectionType());
        System.out.println("Длина кабеля: " + getCableLength() + " м");
        System.out.println("Беспроводное устройство: " + (isWireless() ? "Да" : "Нет"));
        System.out.println("Наличие RGB подсветки: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());

    }
}
