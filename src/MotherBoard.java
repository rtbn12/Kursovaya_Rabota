import java.util.Scanner;

public class MotherBoard extends ComputerComponent{

    private String chipset;          // Чипсет (B550, Z790)
    private String socket;           // Сокет (AM4, LGA1700)
    private int ramSlots;            // Количество слотов RAM
    private int maxRamCapacity;      // Макс. объем RAM (ГБ)
    private String ramType;          // Тип памяти (DDR4, DDR5)
    private int m2Slots;             // Количество M.2 слотов
    private int sataPorts;           // Количество SATA портов
    private boolean hasWiFi;         // Встроенный WiFi
    private String audioCodec;       // Аудиокодек
    private int lanSpeed;         // Скорость сетевой карты



    public MotherBoard(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setChipset(scanner);
        setSocket(scanner);
        setRamSlots(scanner);
        setMaxRamCapacity(scanner);
        setRamType(scanner);
        setM2Slots(scanner);
        setSataPorts(scanner);
        setAudioCodec(scanner);
        setLanSpeed(scanner);
        setHasWiFi(scanner);
    }


    public String getChipset() {
        return chipset;
    }

    public void setChipset(Scanner scanner) {
        System.out.print("\nВведите чипсет материнской платы: ");
        this.chipset = scanner.nextLine();
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(Scanner scanner) {
        System.out.print("\nВведите сокет материнской платы: ");
        this.socket = scanner.nextLine();
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(Scanner scanner) {
        boolean cycleRamSlots = true;
        while (cycleRamSlots) {
            System.out.print("\nВведите количество слотов оперативной памяти: ");

            try {
                int ramSlots = scanner.nextInt();
                scanner.nextLine();
                while (ramSlots < 2 || ramSlots > 8 || ramSlots % 2 != 0) {
                    System.out.print("\nНекорректное количество слотов RAM!\n" +
                            "Введите значение ещё раз: ");
                    ramSlots = scanner.nextInt();
                    scanner.nextLine();
                }
                this.ramSlots = ramSlots;
                cycleRamSlots = false;
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

    public int getMaxRamCapacity() {
        return maxRamCapacity;
    }

    public void setMaxRamCapacity(Scanner scanner) {
        boolean cycleMaxRamCapacity = true;
        while (cycleMaxRamCapacity) {
            System.out.print("\nВведите максимальный объём поддерживаемой оперативной памяти в ГБ (32, 64, 128, 192, 256, 512): ");

            try {
                int maxRamCapacity = scanner.nextInt();
                scanner.nextLine();
                while (maxRamCapacity < 32 || maxRamCapacity > 512 || (maxRamCapacity % 2 != 0 || maxRamCapacity < 8 * this.ramSlots)) {
                    System.out.print("\nНекорректный максимальный объём RAM!\n" +
                            "Введите значение ещё раз (32, 64, 128, 192, 256, 512): ");
                    maxRamCapacity = scanner.nextInt();
                    scanner.nextLine();
                }
                this.maxRamCapacity = maxRamCapacity;
                cycleMaxRamCapacity = false;
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

    public String getRamType() {
        return ramType;
    }

    public void setRamType(Scanner scanner) {
        System.out.print("\nВведите поддерживаемый тип памяти (DDR4, DDR5, DDR4/DDR5): ");
        this.ramType = scanner.nextLine();
    }

    public int getM2Slots() {
        return m2Slots;
    }

    public void setM2Slots(Scanner scanner) {
        boolean cycleM2Slots = true;
        while (cycleM2Slots) {
            System.out.print("\nВведите количество M.2 слотов (0-6): ");

            try {
                int m2Slots = scanner.nextInt();
                scanner.nextLine();
                while (m2Slots < 0 || m2Slots > 6) {
                    System.out.print("\nНекорректное количество M.2 слотов!\n" +
                            "Введите значение ещё раз (0-6): ");
                    m2Slots = scanner.nextInt();
                    scanner.nextLine();
                }
                this.m2Slots = m2Slots;
                cycleM2Slots = false;
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

    public int getSataPorts() {
        return sataPorts;
    }

    public void setSataPorts(Scanner scanner) {
        boolean cycleSataPorts = true;
        while (cycleSataPorts) {
            System.out.print("\nВведите количество SATA портов (2-12): ");

            try {
                int sataPorts = scanner.nextInt();
                scanner.nextLine();
                while (sataPorts < 2 || sataPorts > 12) {
                    System.out.print("\nНекорректное количество SATA портов!\n" +
                            "Введите значение ещё раз (2-12): ");
                    sataPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                this.sataPorts = sataPorts;
                cycleSataPorts = false;
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

    public boolean isHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(Scanner scanner) {
        boolean cycleHasWiFi = true;
        while (cycleHasWiFi) {
            System.out.print("\nЕсть ли у материнской платы встроенный WiFi модуль?\n" +
                    "Введите:\n" +
                    "1 - если WiFi модуль присутствует\n" +
                    "0 - если WiFi модуль отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        this.hasWiFi = false;
                        cycleHasWiFi = false;
                        break;
                    case 1:
                        this.hasWiFi = true;
                        cycleHasWiFi = false;
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

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(Scanner scanner) {
        System.out.print("\nВведите аудиокодек (Realtek ALC897, Realtek ALC1220 и т.д.): ");
        this.audioCodec = scanner.nextLine();
    }

    public int getLanSpeed() {
        return lanSpeed;
    }

    public void setLanSpeed(Scanner scanner) {
        boolean cyclelanSpeed = true;
        while (cyclelanSpeed) {
            System.out.print("\nВведите скорость сетевой карты: ");

            try {
                int lanSpeed = scanner.nextInt();
                scanner.nextLine();
                while (lanSpeed < 0 || lanSpeed > 10000) {
                    System.out.print("\nНекорректная скорость сетевой карты!\n" +
                            "Введите значение ещё раз: ");
                    lanSpeed = scanner.nextInt();
                    scanner.nextLine();
                }
                this.lanSpeed = lanSpeed;
                cyclelanSpeed = false;
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


    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Чипсет: " + getChipset());
        System.out.println("Сокет: " + getSocket());
        System.out.println("Поддерживаемые типы памяти: " + getRamType());
        System.out.println("Количество слотов RAM: " + getRamSlots());
        System.out.println("Максимальный объём RAM: " + getMaxRamCapacity() + "Гб");
        System.out.println("Количество M.2-портов: " + getM2Slots());
        System.out.println("Количество SATA-портов: " + getSataPorts());
        System.out.println("Аудиокодек: " + getAudioCodec());
        System.out.println("Скорость сетевой карты: " + getLanSpeed() + "Мбит/с");
        System.out.println("Наличие встроенного WI-FI модуля: " + (hasWiFi ? "Да" : "Нет"));
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
