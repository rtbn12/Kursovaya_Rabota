import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ComputerShop {
    private static final String address = "Belgorod, Pobedy street, 85b";
    private static final String name = "ENS";
    private static final String phone = "+79024292753";

    private static Client client = null;
    private static Seller seller = null;

   public static  void main(String[] args) {
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
                                   "3 - Каталог товаров\n" +
                                   "4 - Поиск товара по id\n" +
                                   "5 - Проверить баланс\n" +
                                   "6 - Корзина\n" +
                                   "7 - Список покупок\n" +
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
                                       client = AccountManager.authorizationClient();
                                       break;
                                   case 3:
                                       ProductManager.printProduct();
                                       break;
                                   case 4:
                                       //поиск товара
                                       int searchChoice;
                                       boolean search = true;
                                       while(search)
                                       {
                                           System.out.println("\n\n+-+-+-+-+-+-+-+--Раздел поиска товара по id--+-+-+-+-+-+-+-+");
                                           System.out.print("\nВыберите одно из доступных действий:\n" +
                                                   "1 - Выполнить поиск\n" +
                                                   "0 - Выход в меню покупателя\n" +
                                                   "Ваш выбор:");
                                           try {
                                               searchChoice = scanner.nextInt();

                                               switch (searchChoice)
                                               {
                                                   case 1:
                                                       //здесь будет метод по поиску товара и дальнейшие действия
                                                       break;
                                                   case 0:
                                                       search = false;
                                                       break;
                                                   default:
                                                       System.out.println("Такого варианта выбора нет!\n" +
                                                               "Пожалуйста, введите корректное число!");
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
                                   case 5:
                                       if(client != null)
                                       {
                                           // раздел баланса
                                           int balanceChoice;
                                           boolean balance = true;
                                           while(balance)
                                           {
                                               System.out.println("\n\n+-+-+-+-+-+-+-+--Баланс--+-+-+-+-+-+-+-+");
                                               System.out.println("Ваш баланс составляет: " + client.getBalance() +  " рублей!");
                                               System.out.print("\nВыберите одно из доступных действий:\n" +
                                                       "1 - Пополнить баланс\n" +
                                                       "0 - Выход в меню покупателя\n" +
                                                       "Ваш выбор:");
                                               try {
                                                   balanceChoice = scanner.nextInt();

                                                   switch (balanceChoice)
                                                   {
                                                       case 1:
                                                           double sum;
                                                           boolean sumCycle = true;
                                                           while(sumCycle)
                                                           {
                                                               System.out.print("\nВыберите вносимую сумму в рублях:");

                                                               try {
                                                               sum = scanner.nextDouble();
                                                               client.addBalance(sum);
                                                               FileManager.rewriteClient(client);

                                                                   sumCycle = false;
                                                               }catch (InputMismatchException e) {
                                                                   System.out.println("Произошла ошибка!\n" +
                                                                           "Пожалуйста, введите корректное целочисленное вносимой суммы!\n" +
                                                                           "В прошлый раз вы ввели букву вместо числа!");
                                                                   scanner.nextLine();
                                                               }
                                                               catch (Exception a) {
                                                                   System.out.println("Произошла неизвестная ошибка!");
                                                                   scanner.nextLine();
                                                               }

                                                           }
                                                           break;
                                                       case 0:
                                                           balance = false;
                                                           break;
                                                       default:
                                                           System.out.println("Такого варианта выбора нет!\n" +
                                                                   "Пожалуйста, введите корректное число!");
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


                                       }

                                       else
                                       {
                                           System.out.println("\n Для выполнения этого действия, сначала надо пройти процесс авторизации!");

                                       }

                                       break;

                                   case 6:

                                       break;
                                   case 7:

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
                                    "3 - Добавить товар\n" +
                                    "4 - Каталог товаров\n" +
                                    "5 - Поиск товара по id\n" +
                                    "5 - Изменить товар\n" +
                                    "6 - Удалить товар\n" +
                                    "7 - Подтвердить покупку\n"+
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
                                        seller = AccountManager.authorizationSeller();
                                        break;
                                    case 3:
                                        if(seller!=null)
                                        {
                                            seller.registrationProduct();
                                        }

                                        else
                                        {
                                            System.out.println("Продавец не авторизован!");
                                        }
                                        break;
                                    case 4:
                                        if(seller!=null)
                                        {
                                            ProductManager.printProduct();
                                        }

                                        else
                                        {
                                            System.out.println("Продавец не авторизован!");
                                        }

                                        break;
                                    case 5:

                                        break;
                                    case 6:

                                        break;
                                    case 7:

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
