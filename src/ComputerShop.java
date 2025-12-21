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

                                       int printChoice;
                                       boolean print = true;
                                       while(print)
                                       {System.out.println("\n\n+-+-+-+-+-+-+-+--Каталог товаров--+-+-+-+-+-+-+-+");
                                           System.out.print("\nВыберите интересующую категорию товара:\n" +
                                                   "1 - Центральный процессор\n" +
                                                   "2 - Материнская плата\n" +
                                                   "3 - Видеокарта\n" +
                                                   "4 - Оперативная память\n" +
                                                   "5 - Постоянное запоминающее устройство\n" +
                                                   "6 - Блок питания\n" +
                                                   "7 - Корпус\n" +
                                                   "8 - Кулер\n" +
                                                   "9 - Программное обеспечение\n" +
                                                   "10 - Монитор\n" +
                                                   "11 - Мышь\n" +
                                                   "12 - Клавиатура\n" +
                                                   "0 - Выход в меню\n" +
                                                   "Ваш выбор:");


                                           try {
                                               printChoice = scanner.nextInt();

                                               switch (printChoice)
                                               {
                                                   case 1:
                                                       handleProductMenu("Центральный процессор", scanner);
                                                       break;
                                                   case 2:
                                                       handleProductMenu("Материнская плата", scanner);
                                                       break;
                                                   case 3:
                                                       handleProductMenu("Видеокарта", scanner);
                                                       break;
                                                   case 4:
                                                       handleProductMenu("Оперативная память", scanner);
                                                       break;
                                                   case 5:
                                                       handleProductMenu("Постоянное запоминающее устройство", scanner);
                                                       break;
                                                   case 6:
                                                       handleProductMenu("Блок питания", scanner);
                                                       break;
                                                   case 7:
                                                       handleProductMenu("Корпус", scanner);
                                                       break;
                                                   case 8:
                                                       handleProductMenu("Кулер", scanner);
                                                       break;
                                                   case 9:
                                                       handleProductMenu("Программное обеспечение", scanner);
                                                       break;
                                                   case 10:
                                                       handleProductMenu("Монитор", scanner);
                                                       break;
                                                   case 11:
                                                       handleProductMenu("Мышь", scanner);
                                                       break;
                                                   case 12:
                                                       handleProductMenu("Клавиатура", scanner);
                                                       break;
                                                   case 0:
                                                       print = false;
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
                                                       productActionsMenu(scanner);
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

                                       if(client != null)
                                       {
                                           // раздел корзины
                                           int basketChoice;
                                           boolean bascet = true;
                                           while(bascet)
                                           {
                                               System.out.println("\n\n+-+-+-+-+-+-+-+--Ваша корзина--+-+-+-+-+-+-+-+");
                                               // тут будет метод для вывода содержимого корзины
                                               System.out.print("\nВыберите одно из доступных действий:\n" +
                                                       "1 - Купить все товары\n" +
                                                       "2 - Купить товар по его id\n" +
                                                       "3 - Очистить козину\n" +
                                                       "4 - Удалить товар из корзины по его id\n" +
                                                       "0 - Выход в меню покупателя\n" +
                                                       "Ваш выбор:");
                                               try {
                                                   basketChoice = scanner.nextInt();

                                                   switch (basketChoice)
                                                   {
                                                       case 1:
                                                          // логика для покупки всех товаров
                                                           break;
                                                       case 2:
                                                           // логика для покупки товара по id
                                                           break;
                                                       case 3:
                                                           // логика для очистки корзины
                                                           break;
                                                       case 4:
                                                           // логика для удаления товара по его id
                                                           break;
                                                       case 0:
                                                           bascet = false;
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
                                   case 7:

                                       if(client != null)
                                       {
                                           // раздел списка покупок
                                           int shoppingListChoice;
                                           boolean shoppingList = true;
                                           while(shoppingList)
                                           {
                                               System.out.println("\n\n+-+-+-+-+-+-+-+--Ваш список покупок--+-+-+-+-+-+-+-+");
                                               // тут будет метод для вывода содержимого списка покупок
                                               System.out.print("\nВыберите одно из доступных действий:\n" +
                                                       "0 - Выход в меню покупателя\n" +
                                                       "Ваш выбор:");
                                               try {
                                                   shoppingListChoice = scanner.nextInt();
                                                   if(shoppingListChoice!=0)
                                                   {
                                                       System.out.println("Такого варианта выбора нет!\n" +
                                                               "Пожалуйста, введите корректное число!");
                                                   }
                                                   else
                                                   {
                                                       shoppingList = false;
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
                                    "6 - Изменить товар\n" +
                                    "7 - Удалить товар\n" +
                                    "8 - Подтвердить покупку\n"+
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
                                    case 8:

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
        System.out.println("\nНазвание магазина:" + name);
        System.out.println("Адрес:" + address);
        System.out.println("Контактный телефон:" + phone);
        System.out.println("\n\nДанный компьютерный магазин не существует в реальности,\n" +
                "а представляет собой лишь некоммерческую программу,\n" +
                "написанную студентом в качестве курсовой работы,\n" +
                "все совпадения с возможной логикой работы магазина 'DNS' вовсе не случайны,\n" +
                "так как лучший способ создать что-то хорошее - брать пример с лучших!");
    }

    public static String getName()
    {
        return name;
    }

    private static void handleProductMenu(String categoryName, Scanner scanner) {
        ProductManager.printMiniInfo(categoryName);
        int productChoice;
        boolean productCycle = true;

        while(productCycle) {
            System.out.print("\nВыберите одно из доступных действий:\n" +
                    "1 - Подробнее о товаре\n" +
                    "0 - Вернуться к каталогу товаров\n" +
                    "Ваш выбор: ");

            try {
                productChoice = scanner.nextInt();

                switch (productChoice) {
                    case 1:
                        productActionsMenu(scanner);
                        break;
                    case 0:
                        productCycle = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }


    private static void productActionsMenu( Scanner scanner) {
        ProductManager.searchProductForClient();
        int choice;
        boolean cycle = true;

        while(cycle) {
            System.out.print("\nВыберите одно из доступных действий:\n" +
                    "1 - Купить товар\n" +
                    "2 - Положить товар в корзину\n" +
                    "3 - Авторизоваться\n" +
                    "0 - Назад\n" +
                    "Ваш выбор: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        if(client != null) {
                            // здесь будет логика для покупки товара
                        } else {
                            System.out.println("\nДля выполнения этого действия сначала надо пройти процесс авторизации!");
                        }
                        break;

                    case 2:
                        if(client != null) {
                            // здесь логика для того, чтобы положить товар в корзину
                        } else {
                            System.out.println("\nДля выполнения этого действия сначала надо пройти процесс авторизации!");
                        }
                        break;

                    case 3:
                        client = AccountManager.authorizationClient();
                        break;

                    case 0:
                        cycle = false;
                        break;

                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }
}
