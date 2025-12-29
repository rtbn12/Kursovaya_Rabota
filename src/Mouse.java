import java.util.Scanner;

public class Mouse extends Peripheral{

    private int dpi;                    // Чувствительность (DPI)
    private int buttonsCount;           // Количество кнопок
    private String sensorType;          // Тип сенсора (оптический, лазерный)
    private boolean isGaming;           // Игровая мышь


    public Mouse(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setDpi(scanner);
        setButtonsCount(scanner);
        setSensorType(scanner);
        setIsGaming(scanner);
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(Scanner scanner) {
        boolean cycleDpi = true;
        while (cycleDpi) {
            System.out.print("\nВведите максимальную чувствительность мыши в DPI (800, 1000, 1600, 3200, 6400, 12000, 16000, 26000): ");

            try {
                int dpi = scanner.nextInt();
                scanner.nextLine();

                int[] validDpis = {800, 1000, 1600, 3200, 6400, 12000, 16000, 26000};
                boolean isValid = false;

                for (int validDpi : validDpis) {
                    if (dpi == validDpi) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная чувствительность DPI!\n" +
                            "Введите значение ещё раз (800, 1600, 3200, 6400, 12000, 16000, 26000 DPI): ");
                    dpi = scanner.nextInt();
                    scanner.nextLine();

                    for (int validDpi : validDpis) {
                        if (dpi == validDpi) {
                            isValid = true;
                            break;
                        }
                    }
                }

                this.dpi = dpi;
                cycleDpi = false;

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

    public int getButtonsCount() {
        return buttonsCount;
    }

    public void setButtonsCount(Scanner scanner) {
        boolean cycleButtonsCount = true;
        while (cycleButtonsCount) {
            System.out.print("\nВведите количество кнопок (3, 5, 7, 9, 12, 18): ");

            try {
                int buttonsCount = scanner.nextInt();
                scanner.nextLine();

                int[] validButtons = {3, 5, 7, 9, 12, 18};
                boolean isValid = false;

                for (int buttons : validButtons) {
                    if (buttonsCount == buttons) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректное количество кнопок!\n" +
                            "Введите значение ещё раз (3, 5, 7, 9, 12, 18 кнопок): ");
                    buttonsCount = scanner.nextInt();
                    scanner.nextLine();

                    for (int buttons : validButtons) {
                        if (buttonsCount == buttons) {
                            isValid = true;
                            break;
                        }
                    }
                }

                this.buttonsCount = buttonsCount;
                cycleButtonsCount = false;

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

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(Scanner scanner) {
        boolean cycleSensorType = true;
        while (cycleSensorType) {
            System.out.print("\nВыберите тип сенсора мыши:\n" +
                    "1 - Оптический\n" +
                    "2 - Лазерный\n" +
                    "3 - Оптический высокоточный\n" +
                    "4 - Герконовый (для трекболов)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.sensorType = "Оптический";
                        cycleSensorType = false;
                        break;
                    case 2:
                        this.sensorType = "Лазерный";
                        cycleSensorType = false;
                        break;
                    case 3:
                        this.sensorType = "Оптический высокоточный";
                        cycleSensorType = false;
                        break;
                    case 4:
                        this.sensorType = "Герконовый";
                        cycleSensorType = false;
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

    public boolean isGaming() {
        return isGaming;
    }

    public void setIsGaming(Scanner scanner) {
        boolean cycleIsGaming = true;
        while (cycleIsGaming) {
            System.out.print("\nЭто игровая мышь?\n" +
                    "Введите:\n" +
                    "1 - Да, игровая\n" +
                    "0 - Нет, офисная/обычная\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        this.isGaming = false;
                        cycleIsGaming = false;
                        break;
                    case 1:
                        this.isGaming = true;
                        cycleIsGaming = false;
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
        System.out.println("Чувствительность: " + getDpi() + " DPI");
        System.out.println("Количество кнопок: " + getButtonsCount());
        System.out.println("Тип сенсора: " + getSensorType());
        System.out.println("Игровая: " + (isGaming() ? "Да" : "Нет"));
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
