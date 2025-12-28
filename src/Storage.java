import java.util.Scanner;

public class Storage extends ComputerComponent{

    private int capacity;           // Емкость (ГБ или ТБ)
    private String storageType;     // Тип (SSD, HDD, NVMe)
    private int readSpeed;          // Скорость чтения (МБ/с)
    private int writeSpeed;         // Скорость записи (МБ/с)
    private String formFactor;      // Форм-фактор (2.5", M.2, 3.5")
    private int tbw;                // Ресурс записи (TBW - терабайт записи)
    private int cacheSize;          // Размер кэша (МБ)
    private String nandType;        // Тип памяти (TLC, QLC, 3D NAND)

    public Storage(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setCapacity(scanner);
        setStorageType(scanner);
        setFormFactor(scanner);
        setReadSpeed(scanner);
        setWriteSpeed(scanner);
        setTbw(scanner);
        setCacheSize(scanner);
        setNandType(scanner);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Scanner scanner) {
        boolean cycleCapacity = true;
        while (cycleCapacity) {
            System.out.print("\nВведите емкость накопителя в ГБ (128, 256, 512, 1024, 2048, 4096, 8192): ");

            try {
                int capacity = scanner.nextInt();
                scanner.nextLine();

                int[] validCapacities = {128, 256, 512, 1024, 2048, 4096, 8192};
                boolean isValid = false;

                for (int cap : validCapacities) {
                    if (capacity == cap) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная емкость накопителя!\n" +
                            "Введите значение ещё раз (128, 256, 512, 1024, 2048, 4096, 8192 ГБ): ");
                    capacity = scanner.nextInt();
                    scanner.nextLine();

                    for (int cap : validCapacities) {
                        if (capacity == cap) {
                            isValid = true;
                            break;
                        }
                    }
                }

                this.capacity = capacity;
                cycleCapacity = false;

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

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(Scanner scanner) {
        boolean cycleStorageType = true;
        while (cycleStorageType) {
            System.out.print("\nВыберите тип накопителя:\n" +
                    "1 - SSD (SATA)\n" +
                    "2 - NVMe SSD\n" +
                    "3 - HDD\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.storageType = "SSD";
                        cycleStorageType = false;
                        break;
                    case 2:
                        this.storageType = "NVMe SSD";
                        cycleStorageType = false;
                        break;
                    case 3:
                        this.storageType = "HDD";
                        cycleStorageType = false;
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

    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(Scanner scanner) {
        boolean cycleReadSpeed = true;
        while (cycleReadSpeed) {
            System.out.print("\nВведите скорость чтения в МБ/с (минимальное значение 10 МБ/с): ");

            try {
                int readSpeed = scanner.nextInt();
                scanner.nextLine();

                while (readSpeed < 10) {
                    System.out.print("\nНекорректная скорость чтения!\n" +
                            "Введите значение ещё раз (не менее 10 МБ/с): ");
                    readSpeed = scanner.nextInt();
                    scanner.nextLine();
                }

                this.readSpeed = readSpeed;
                cycleReadSpeed = false;

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

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(Scanner scanner) {
        boolean cycleWriteSpeed = true;
        while (cycleWriteSpeed) {
            System.out.print("\nВведите скорость записи в МБ/с (минимальное значение 5 МБ/с): ");

            try {
                int writeSpeed = scanner.nextInt();
                scanner.nextLine();

                while (writeSpeed < 5) {
                    System.out.print("\nНекорректная скорость записи!\n" +
                            "Введите значение ещё раз (не менее 5 МБ/с): ");
                    writeSpeed = scanner.nextInt();
                    scanner.nextLine();
                }

                // Проверка, чтобы скорость записи не была больше скорости чтения
                if (writeSpeed > this.readSpeed) {
                    System.out.println("Внимание: Скорость записи не может быть выше скорости чтения!\n" +
                            "Скорость записи установлена равной скорости чтения.");
                    writeSpeed = this.readSpeed;
                }

                this.writeSpeed = writeSpeed;
                cycleWriteSpeed = false;

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

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(Scanner scanner) {
        boolean cycleFormFactor = true;
        while (cycleFormFactor) {
            System.out.print("\nВыберите форм-фактор накопителя:\n" +
                    "1 - 2.5\"\n" +
                    "2 - M.2\n" +
                    "3 - 3.5\"\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.formFactor = "2.5\"";
                        cycleFormFactor = false;
                        break;
                    case 2:
                        this.formFactor = "M.2";
                        cycleFormFactor = false;
                        break;
                    case 3:
                        this.formFactor = "3.5\"";
                        cycleFormFactor = false;
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

    public int getTbw() {
        return tbw;
    }

    public void setTbw(Scanner scanner) {
        boolean cycleTBW = true;
        while (cycleTBW) {
            System.out.print("\nВведите ресурс записи (TBW) в терабайтах: ");

            try {
                int tbw = scanner.nextInt();
                scanner.nextLine();

                while (tbw <= 0) {
                    System.out.print("\nНекорректный ресурс записи!\n" +
                            "Введите значение ещё раз (положительное число): ");
                    tbw = scanner.nextInt();
                    scanner.nextLine();
                }

                this.tbw = tbw;
                cycleTBW = false;

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

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Scanner scanner) {
        boolean cycleCacheSize = true;
        while (cycleCacheSize) {
            System.out.print("\nВведите размер кэша в МБ (0, 64, 128, 256, 512, 1024, 2048): ");

            try {
                int cacheSize = scanner.nextInt();
                scanner.nextLine();

                int[] validCacheSizes = {0, 64, 128, 256, 512, 1024, 2048};
                boolean isValid = false;

                for (int cache : validCacheSizes) {
                    if (cacheSize == cache) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректный размер кэша!\n" +
                            "Введите значение ещё раз (0, 64, 128, 256, 512, 1024, 2048 МБ): ");
                    cacheSize = scanner.nextInt();
                    scanner.nextLine();

                    for (int cache : validCacheSizes) {
                        if (cacheSize == cache) {
                            isValid = true;
                            break;
                        }
                    }
                }

                this.cacheSize = cacheSize;
                cycleCacheSize = false;

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

    public String getNandType() {
        return nandType;
    }

    public void setNandType(Scanner scanner) {
        boolean cycleNandType = true;
        while (cycleNandType) {
            System.out.print("\nВыберите тип памяти NAND:\n" +
                    "1 - TLC\n" +
                    "2 - QLC\n" +
                    "3 - 3D NAND\n" +
                    "4 - MLC (для SSD)\n" +
                    "5 - SLC (для SSD)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.nandType = "TLC";
                        cycleNandType = false;
                        break;
                    case 2:
                        this.nandType = "QLC";
                        cycleNandType = false;
                        break;
                    case 3:
                        this.nandType = "3D NAND";
                        cycleNandType = false;
                        break;
                    case 4:
                        this.nandType = "MLC";
                        cycleNandType = false;
                        break;
                    case 5:
                        this.nandType = "SLC";
                        cycleNandType = false;
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
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Тип: " + getStorageType());
        System.out.println("Емкость: " + getCapacity()+" ГБ ");
        System.out.println("Форм-фактор: " + getFormFactor());
        System.out.println("Скорость чтения: " + getReadSpeed() + " МБ/с");
        System.out.println("Скорость записи: " + getWriteSpeed() + " МБ/с");
        System.out.println("Тип памяти: " + getNandType());
        System.out.println("Кэш: " + getCacheSize() + " МБ");
        System.out.println("Ресурс записи: " + getTbw() + " TBW");
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
