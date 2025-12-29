import java.util.Scanner;

public class Cooler extends ComputerComponent{

    private String coolerType;      // Тип кулера (воздушный, жидкостный)
    private String socketCompatibility; // Совместимые сокеты
    private int fanSize;            // Размер вентилятора (мм)
    private int fanSpeed;           // Скорость вращения (об/мин)
    private int tdp;                // Рассеиваемая мощность (Вт)
    private int heatPipes;          // Количество тепловых трубок
    private boolean hasRGB;         // RGB подсветка
    private boolean hasPwm;         // PWM регулировка оборотов

    public Cooler(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setCoolerType(scanner);
        setSocketCompatibility(scanner);
        setFanSize(scanner);
        setFanSpeed(scanner);
        setTdp(scanner);
        setHeatPipes(scanner);
        setHasPwm(scanner);
        setHasRGB(scanner);
    }

    public String getCoolerType() {
        return coolerType;
    }

    public void setCoolerType(Scanner scanner) {
        boolean cycleCoolerType = true;
        while (cycleCoolerType) {
            System.out.print("\nВыберите тип кулера:\n" +
                    "1 - Процессорный кулер (воздушный)\n" +
                    "2 - Корпусный вентилятор\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.coolerType = "Процессорный (воздушный)";
                        cycleCoolerType = false;
                        break;
                    case 2:
                        this.coolerType = "Корпусный вентилятор";
                        cycleCoolerType = false;
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

    public String getSocketCompatibility() {
        return socketCompatibility;
    }

    public void setSocketCompatibility(Scanner scanner) {
        boolean cycleSocketCompatibility = true;
        while (cycleSocketCompatibility) {
            System.out.print("\nВыберите совместимые сокеты (можно выбрать несколько цифр через пробел):\n" +
                    "1 - LGA 1700\n" +
                    "2 - LGA 1200\n" +
                    "3 - LGA 1151\n" +
                    "4 - AM5\n" +
                    "5 - AM4\n" +
                    "6 - AM3+\n" +
                    "7 - TR4\n" +
                    "8 - sTRX4\n" +
                    "9 - нет (для корпусных кулеров)\n" +
                    "Введите номера выбранных сокетов (например: 1 2 4 5): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedSockets = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("LGA 1700");
                                break;
                            case 2:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("LGA 1200");
                                break;
                            case 3:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("LGA 1151");
                                break;
                            case 4:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("AM5");
                                break;
                            case 5:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("AM4");
                                break;
                            case 6:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("AM3+");
                                break;
                            case 7:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("TR4");
                                break;
                            case 8:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("sTRX4");
                                break;
                            case 9:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("нет");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedSockets.length() == 0) {
                    System.out.println("Вы не выбрали ни одного сокета! Пожалуйста, выберите хотя бы один.");
                    continue;
                }

                this.socketCompatibility = selectedSockets.toString();
                cycleSocketCompatibility = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }
    }

    public int getFanSize() {
        return fanSize;
    }

    public void setFanSize(Scanner scanner) {
        boolean cycleFanSize = true;
        while (cycleFanSize) {
            System.out.print("\nВведите размер вентилятора в мм (80, 92, 120, 140, 200, 240, 280, 360): ");

            try {
                int fanSize = scanner.nextInt();
                scanner.nextLine();

                int[] validSizes = {80, 92, 120, 140, 200, 240, 280, 360};
                boolean isValid = false;

                for (int size : validSizes) {
                    if (fanSize == size) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректный размер вентилятора!\n" +
                            "Введите значение ещё раз (80, 92, 120, 140, 200, 240, 280, 360 мм): ");
                    fanSize = scanner.nextInt();
                    scanner.nextLine();

                    for (int size : validSizes) {
                        if (fanSize == size) {
                            isValid = true;
                            break;
                        }
                    }
                }

                this.fanSize = fanSize;
                cycleFanSize = false;

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

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(Scanner scanner) {
        boolean cycleFanSpeed = true;
        while (cycleFanSpeed) {
            System.out.print("\nВведите максимальную скорость вращения вентилятора в об/мин (800-3000): ");

            try {
                int fanSpeed = scanner.nextInt();
                scanner.nextLine();

                while (fanSpeed < 800 || fanSpeed > 3000) {
                    System.out.print("\nНекорректная скорость вращения!\n" +
                            "Введите значение ещё раз (800-3000 об/мин): ");
                    fanSpeed = scanner.nextInt();
                    scanner.nextLine();
                }

                this.fanSpeed = fanSpeed;
                cycleFanSpeed = false;

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

    public int getTdp() {
        return tdp;
    }

    public void setTdp(Scanner scanner) {
        boolean cycleTdp = true;
        while (cycleTdp) {
            System.out.print("\nВведите рассеиваемую мощность (TDP) в Ваттах (65-400): ");

            try {
                int tdp = scanner.nextInt();
                scanner.nextLine();

                while (tdp < 65 || tdp > 400) {
                    System.out.print("\nНекорректная мощность TDP!\n" +
                            "Введите значение ещё раз (65-400 Вт): ");
                    tdp = scanner.nextInt();
                    scanner.nextLine();
                }

                this.tdp = tdp;
                cycleTdp = false;

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

    public int getHeatPipes() {
        return heatPipes;
    }

    public void setHeatPipes(Scanner scanner) {
        boolean cycleHeatPipes = true;
        while (cycleHeatPipes) {
            System.out.print("\nВведите количество тепловых трубок (0-8): ");

            try {
                int heatPipes = scanner.nextInt();
                scanner.nextLine();

                while (heatPipes < 0 || heatPipes > 8) {
                    System.out.print("\nНекорректное количество тепловых трубок!\n" +
                            "Введите значение ещё раз (0-8): ");
                    heatPipes = scanner.nextInt();
                    scanner.nextLine();
                }

                this.heatPipes = heatPipes;
                cycleHeatPipes = false;

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

    public boolean isHasPwm() {
        return hasPwm;
    }

    public void setHasPwm(Scanner scanner) {
        boolean cycleHasPwm = true;
        while (cycleHasPwm) {
            System.out.print("\nПоддерживает ли вентилятор PWM регулировку оборотов?\n" +
                    "Введите:\n" +
                    "1 - если PWM поддерживается\n" +
                    "0 - если PWM не поддерживается\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        this.hasPwm = false;
                        cycleHasPwm = false;
                        break;
                    case 1:
                        this.hasPwm = true;
                        cycleHasPwm = false;
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

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(Scanner scanner) {
        boolean cycleHasRGB = true;
        while (cycleHasRGB) {
            System.out.print("\nЕсть ли у кулера RGB подсветка?\n" +
                    "Введите:\n" +
                    "1 - если RGB подсветка присутствует\n" +
                    "0 - если RGB подсветка отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        this.hasRGB = false;
                        cycleHasRGB = false;
                        break;
                    case 1:
                        this.hasRGB = true;
                        cycleHasRGB = false;
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
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Тип охлаждения: " + getCoolerType());
        System.out.println("Совместимые сокеты: " + getSocketCompatibility());
        System.out.println("Размер вентилятора: " + getFanSize() + " мм");
        System.out.println("Скорость вращения: " + getFanSpeed() + " об/мин");
        System.out.println("Рассеиваемая мощность: " + getTdp() + " Вт");
        System.out.println("Тепловые трубки: " + getHeatPipes() + " шт");
        System.out.println("PWM регулировка: " + (isHasPwm() ? "Да" : "Нет"));
        System.out.println("RGB подсветка: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
