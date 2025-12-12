import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputerShop {
    private static final String address = "Belgorod, Pobedy street, 85b";
    private static final String name = "ENS";
    private static final String phone = "+79024292753";
    static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean cycle = true;
        while (cycle)
        {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Компьютерный магазин--+-+-+-+-+-+-+-+");
            System.out.print("Введите номер интересующего раздела:\n" +
                    "1 - Покупателю\n" +
                    "2 - Продавцу\n" +
                    "3 - Подробнее о магазине\n" +
                    "0 - Выход\n" +
                    "Ваш выбор:");
            int choice;



            try {
                choice = scanner.nextInt();
                switch (choice)
                {
                    case 1:
                       boolean cycleClient = true;
                       while (cycleClient)
                       {
                           System.out.println("\n\n+-+-+-+-+-+-+-+--Раздел покупателя--+-+-+-+-+-+-+-+");
                           System.out.print("Введите номер интересующего действия:\n" +
                                   "1 - Регистрация\n" +
                                   "2 - Авторизация\n" +
                                   "0 - Выход в главное меню\n" +
                                   "Ваш выбор:");
                           int choiceClient;

                           try {
                               choiceClient = scanner.nextInt();
                               switch (choiceClient)
                               {
                                   case 1:
                                       AccountManager.registrationClient();
                                       break;
                                   case 2:
                                       AccountManager.authorizationClient();
                                       break;
                                   case 0:
                                       cycleClient = false;
                                       break;
                                   default:
                                       System.out.println("Такого варианта выбора нет!\n" +
                                               "Пожалуйста, введите корректную цифру!");
                               }

                           }catch (InputMismatchException e) {
                               System.out.println("Произошла ошибка!\n" +
                                       "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                       "В прошлый раз вы ввели букву вместо числа!");
                               scanner.nextLine();
                           }
                           catch (Exception a) {
                               System.out.println("Произошла неизвестная ошибка!");
                               scanner.nextLine();
                           }

                       }

                        break;
                    case 2:
                        boolean cycleSeller = true;
                        while (cycleSeller)
                        {
                            System.out.println("\n\n+-+-+-+-+-+-+-+--Раздел продавца--+-+-+-+-+-+-+-+");
                            System.out.print("Введите номер интересующего действия:\n" +
                                    "1 - Регистрация\n" +
                                    "2 - Авторизация\n" +
                                    "0 - Выход в главное меню\n" +
                                    "Ваш выбор:");
                            int choiceSeller;

                            try {
                                choiceSeller = scanner.nextInt();
                                switch (choiceSeller)
                                {
                                    case 1:
                                        AccountManager.registrationSeller();
                                        break;
                                    case 2:
                                        AccountManager.authorizationSeller();
                                        break;
                                    case 0:
                                        cycleSeller = false;
                                        break;
                                    default:
                                        System.out.println("Такого варианта выбора нет!\n" +
                                                "Пожалуйста, введите корректную цифру!");
                                }

                            }catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            }
                            catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }

                        }
                        break;
                    case 3:
                        aboutShop();
                        break;
                    case 0:
                        System.out.println("Выражаю благодарность за пользование программой!\n" +
                                "До новых встреч!");
                        cycle = false;
                        break;

                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
               scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }
        scanner.close();


    }

    public static void aboutShop(){
        System.out.println("Название магазина:" + name);
        System.out.println("Адрес:" + address);
        System.out.println("Контактный телефон:" + phone);
    }

    public static String getName()
    {
        return name;
    }
}
