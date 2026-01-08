import java.util.List;
import java.util.Scanner;

public class Software extends Product{

    private String softwareType;      // Тип ПО (ОС, антивирус, офис, игра)
    private int licenseDuration;      // Срок лицензии (месяцев, 0 = бессрочная)
    private String supportedOS;       // Поддерживаемые ОС (Windows, macOS, Linux)
    private String systemRequirements; // Системные требования
    private boolean isDigital;        // Цифровая версия (true) или коробочная (false)
    private String languages;         // Поддерживаемые языки

    public Software(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setSoftwareType(scanner);
        setLicenseDuration(scanner);
        setSupportedOS(scanner);
        setSystemRequirements(scanner);
        setIsDigital(scanner);
        setLanguages(scanner);
    }

    public String getSoftwareType() {
        return softwareType;
    }
    public void setSoftwareType(Scanner scanner) {
        boolean cycleSoftwareType = true;
        while (cycleSoftwareType) {
            System.out.print("\nВыберите тип программного обеспечения:\n" +
                    "1 - Операционная система\n" +
                    "2 - Антивирус\n" +
                    "3 - Офисный пакет\n" +
                    "4 - Графический редактор\n" +
                    "5 - Игра\n" +
                    "6 - Утилита\n" +
                    "7 - Драйвер\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.softwareType = "Операционная система";
                        cycleSoftwareType = false;
                        break;
                    case 2:
                        this.softwareType = "Антивирус";
                        cycleSoftwareType = false;
                        break;
                    case 3:
                        this.softwareType = "Офисный пакет";
                        cycleSoftwareType = false;
                        break;
                    case 4:
                        this.softwareType = "Графический редактор";
                        cycleSoftwareType = false;
                        break;
                    case 5:
                        this.softwareType = "Игра";
                        cycleSoftwareType = false;
                        break;
                    case 6:
                        this.softwareType = "Утилита";
                        cycleSoftwareType = false;
                        break;
                    case 7:
                        this.softwareType = "Драйвер";
                        cycleSoftwareType = false;
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
    public int getLicenseDuration() {
        return licenseDuration;
    }
    public void setLicenseDuration(Scanner scanner) {
        boolean cycleLicenseDuration = true;
        while (cycleLicenseDuration) {
            System.out.print("\nВведите срок лицензии в месяцах (0 = бессрочная, 1-120 месяцев): ");

            try {
                int licenseDuration = scanner.nextInt();
                scanner.nextLine();

                while (licenseDuration < 0 || licenseDuration > 120) {
                    System.out.print("\nНекорректный срок лицензии!\n" +
                            "Введите значение ещё раз (0-120 месяцев): ");
                    licenseDuration = scanner.nextInt();
                    scanner.nextLine();
                }

                this.licenseDuration = licenseDuration;
                cycleLicenseDuration = false;

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
    public String getSupportedOS() {
        return supportedOS;
    }
    public void setSupportedOS(Scanner scanner) {
        boolean cycleSupportedOS = true;
        while (cycleSupportedOS) {
            System.out.print("\nВыберите поддерживаемые операционные системы (можно выбрать несколько цифр через пробел):\n" +
                    "1 - Windows 10/11\n" +
                    "2 - Windows 7/8\n" +
                    "3 - macOS\n" +
                    "4 - Linux\n" +
                    "5 - Android\n" +
                    "6 - iOS\n" +
                    "7 - PS5\n" +
                    "8 - PS4/5\n" +
                    "9 - XBOX\n" +
                    "10 - Nintendo Switch\n" +
                    "Введите номера выбранных ОС (например: 1 3 4): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedOS = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Windows 10/11");
                                break;
                            case 2:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Windows 7/8");
                                break;
                            case 3:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("macOS");
                                break;
                            case 4:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Linux");
                                break;
                            case 5:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Android");
                                break;
                            case 6:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("iOS");
                                break;
                            case 7:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("PS5");
                                break;
                            case 8:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("PS4/5");
                                break;
                            case 9:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("XBOX");
                                break;
                            case 10:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Nintendo Switch");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedOS.length() == 0) {
                    System.out.println("Вы не выбрали ни одной ОС! Пожалуйста, выберите хотя бы одну.");
                    continue;
                }

                this.supportedOS = selectedOS.toString();
                cycleSupportedOS = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }
    }
    public String getSystemRequirements() {
        return systemRequirements;
    }
    public void setSystemRequirements(Scanner scanner) {
        boolean cycleSystemRequirements = true;
        while (cycleSystemRequirements) {
            System.out.print("\nВведите системные требования (можно подробно описать требования к железу): ");

            try {
                String systemRequirements = scanner.nextLine();

                if (systemRequirements.trim().isEmpty()) {
                    System.out.println("Системные требования не могут быть пустыми! Пожалуйста, введите описание.");
                    continue;
                }

                this.systemRequirements = systemRequirements;
                cycleSystemRequirements = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!");
            }
        }
    }
    public boolean isDigital() {
        return isDigital;
    }
    public void setIsDigital(Scanner scanner) {
        boolean cycleIsDigital = true;
        while (cycleIsDigital) {
            System.out.print("\nВыберите тип версии:\n" +
                    "1 - Цифровая версия (электронный ключ/файл)\n" +
                    "2 - Коробочная версия (физический носитель)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.isDigital = true;
                        cycleIsDigital = false;
                        break;
                    case 2:
                        this.isDigital = false;
                        cycleIsDigital = false;
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
    public String getLanguages() {
        return languages;
    }
    public void setLanguages(Scanner scanner) {
        boolean cycleLanguages = true;
        while (cycleLanguages) {
            System.out.print("\nВыберите поддерживаемые языки (можно выбрать несколько цифр через пробел):\n" +
                    "1 - Русский\n" +
                    "2 - Английский\n" +
                    "3 - Немецкий\n" +
                    "4 - Французский\n" +
                    "5 - Испанский\n" +
                    "6 - Китайский\n" +
                    "7 - Японский\n" +
                    "8 - Многоязычная версия\n" +
                    "Введите номера выбранных языков (например: 1 2 8): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedLanguages = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Русский");
                                break;
                            case 2:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Английский");
                                break;
                            case 3:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Немецкий");
                                break;
                            case 4:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Французский");
                                break;
                            case 5:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Испанский");
                                break;
                            case 6:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Китайский");
                                break;
                            case 7:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Японский");
                                break;
                            case 8:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Многоязычная");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedLanguages.length() == 0) {
                    System.out.println("Вы не выбрали ни одного языка! Пожалуйста, выберите хотя бы один.");
                    continue;
                }

                this.languages = selectedLanguages.toString();
                cycleLanguages = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }
    }
    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Тип программного обеспечения: " + getSoftwareType());
        System.out.println("Срок лицензирования: " + getLicenseDuration() + " месяцев");
        System.out.println("Поддерживаемые операционные системы: " + getSupportedOS());
        System.out.println("Системные требования: " + getSystemRequirements());
        System.out.println("Цифровая версия: " + (isDigital()? "Да" : "Нет"));
        System.out.println("Поддерживаемые языки: " + getLanguages());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
