import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class ComputerShop {
    private static final String address = "Belgorod, Pobedy street, 85b";
    private static final String name = "ENS";
    private static final String phone = "+79024292753";

    private static Client client = null;
    private static Seller seller = null;

   public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Migrator();// применяется при изменении методов классов

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
                                               client.printShoppingCart();
                                               System.out.print("\nВыберите одно из доступных действий:\n" +
                                                       "1 - Подробнее о каком-либо товаре\n" +
                                                       "2 - Купить все товары\n" +
                                                       "3 - Купить товар по его id\n" +
                                                       "4 - Очистить козину\n" +
                                                       "5 - Удалить товар из корзины по его id\n" +
                                                       "0 - Выход в меню покупателя\n" +
                                                       "Ваш выбор:");
                                               try {
                                                   basketChoice = scanner.nextInt();

                                                   switch (basketChoice)
                                                   {
                                                       case 1:
                                                           ProductManager.searchProductForClient();
                                                           int searchC;
                                                           boolean searchCCC = true;
                                                           while(searchCCC)
                                                           {

                                                               System.out.print("\nВведите 0 для возвращения к корзине:");
                                                               try {
                                                                   searchC = scanner.nextInt();

                                                                   switch (searchC)
                                                                   {

                                                                       case 0:
                                                                           searchCCC = false;
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
                                                       case 2:
                                                           int buyALLChoice;
                                                           boolean buyALLCycle = true;
                                                           while(buyALLCycle)
                                                           {

                                                               System.out.print("\nВы точно уверены в том, что хотите купить все товары из вашей корзины?\n" +
                                                                       "Выберите одно из доступных действий:\n" +
                                                                       "1 - Подтвердить покупку всех товаров\n" +
                                                                       "0 - Отменить процесс покупки всех товаров\n" +
                                                                       "Ваш выбор:");
                                                               try {
                                                                   buyALLChoice = scanner.nextInt();
                                                                   scanner.nextLine();

                                                                   switch (buyALLChoice)
                                                                   {
                                                                       case 1:
                                                                           client.buyALLShoppingCard(scanner);
                                                                           FileManager.rewriteClient(client);
                                                                           buyALLCycle = false;
                                                                           break;

                                                                       case 0:
                                                                           buyALLCycle = false;
                                                                           System.out.println("\nПроцесс покупки всех товаров был отменён!");
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
                                                       case 3:
                                                           int byeToIDChoice;
                                                           boolean byeToIDCycle = true;
                                                           while(byeToIDCycle)
                                                           {

                                                               System.out.print("\nВы точно уверены в том, что хотите купить товар?\n" +
                                                                       "Выберите одно из доступных действий:\n" +
                                                                       "1 - Подтвердить покупку товара\n" +
                                                                       "0 - Отменить процесс покупки товара\n" +
                                                                       "Ваш выбор:");
                                                               try {
                                                                   byeToIDChoice = scanner.nextInt();
                                                                   scanner.nextLine();

                                                                   switch (byeToIDChoice)
                                                                   {
                                                                       case 1:
                                                                           System.out.print("\nВведите id товара, который хотите купить:");
                                                                           String idToBye = scanner.nextLine();
                                                                           client.buyProductInShoppingCartById(idToBye,scanner);
                                                                           FileManager.rewriteClient(client);
                                                                           byeToIDCycle = false;
                                                                           break;

                                                                       case 0:
                                                                           byeToIDCycle = false;
                                                                           System.out.println("\nПроцесс покупки товара был отменён!");
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
                                                           int clearChoice;
                                                           boolean clearCycle = true;
                                                           while(clearCycle)
                                                           {

                                                               System.out.print("\nВы точно уверены в том, что хотите удалить всё содержимое вашей корзины?\n" +
                                                                       "Выберите одно из доступных действий:\n" +
                                                                       "1 - Подтвердить очистку корзины\n" +
                                                                       "0 - Отменить процесс очистки корзины\n" +
                                                                       "Ваш выбор:");
                                                               try {
                                                                   clearChoice = scanner.nextInt();
                                                                   scanner.nextLine();

                                                                   switch (clearChoice)
                                                                   {
                                                                       case 1:
                                                                           client.clearShoppingCart();
                                                                           clearCycle = false;
                                                                           FileManager.rewriteClient(client);
                                                                           break;

                                                                       case 0:
                                                                           clearCycle = false;
                                                                           System.out.println("\nПроцесс очистки корзины был отменён!");
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
                                                           int removeToIDChoice;
                                                           boolean removeToIDCycle = true;
                                                           while(removeToIDCycle)
                                                           {

                                                               System.out.print("\nВы точно уверены в том, что хотите удалить товар из вашей корзины?\n" +
                                                                       "Выберите одно из доступных действий:\n" +
                                                                       "1 - Подтвердить удаление товара из корзины\n" +
                                                                       "0 - Отменить процесс удаления товара из корзины\n" +
                                                                       "Ваш выбор:");
                                                               try {
                                                                   removeToIDChoice = scanner.nextInt();
                                                                   scanner.nextLine();

                                                                   switch (removeToIDChoice)
                                                                   {
                                                                       case 1:
                                                                           System.out.print("\nВведите id товара, который хотите удалить из корзины:");
                                                                           String idToRemove = scanner.nextLine();
                                                                           client.removeProductInShoppingCartById(idToRemove);
                                                                           FileManager.rewriteClient(client);
                                                                           removeToIDCycle = false;
                                                                           break;

                                                                       case 0:
                                                                           removeToIDCycle = false;
                                                                           System.out.println("\nПроцесс удаления товара из корзины был отменён!");
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
                                           int shoppingListChoice;
                                           boolean shoppingList = true;
                                           while(shoppingList)
                                           {
                                               System.out.println("\n\n+-+-+-+-+-+-+-+--Ваш список покупок--+-+-+-+-+-+-+-+");
                                               client.printShoppingList();
                                               System.out.print("\nВыберите одно из доступных действий:\n" +
                                                       "1 - Подробнее о товаре товаре:\n" +
                                                       "0 - Выход в меню покупателя\n" +
                                                       "Ваш выбор:");
                                               try {
                                                   shoppingListChoice = scanner.nextInt();

                                                   switch (shoppingListChoice)
                                                   {
                                                       case 1:
                                                           ProductManager.searchProductForClient();
                                                           int searchC;
                                                           boolean searchCCC = true;
                                                           while(searchCCC)
                                                           {

                                                               System.out.print("\nВведите 0 для возвращения к списку покупок:");
                                                               try {
                                                                   searchC = scanner.nextInt();

                                                                   switch (searchC)
                                                                   {

                                                                       case 0:
                                                                           searchCCC = false;
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
                                                       case 0:
                                                           shoppingList = false;
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
                                    "0 - Выход в главное меню\n" +
                                    "Ваш выбор:");
                            int choiceSeller;

                            try {
                                choiceSeller = scanner.nextInt();
                                switch (choiceSeller)
                                {
                                    case 1://Регистрация
                                        AccountManager.registrationSeller();
                                        break;
                                    case 2://Авторизация
                                        seller = AccountManager.authorizationSeller();
                                        break;
                                    case 3://Добавление товара
                                        if(seller!=null)
                                        {
                                            seller.registrationProduct();
                                        }

                                        else
                                        {
                                            System.out.println("\nПродавец не авторизован!");
                                        }
                                        break;
                                    case 4://Каталог товаров
                                        if(seller!=null)
                                        {
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
                                                            ProductManager.printFullInformationCPU();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 2:
                                                            ProductManager.printFullInformationMotherboard();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 3:
                                                            ProductManager.printFullInformationGPU();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 4:
                                                            ProductManager.printFullInformationRAM();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 5:
                                                            ProductManager.printFullInformationStorage();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 6:
                                                            ProductManager.printFullInformationPowerSupply();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 7:
                                                            ProductManager.printFullInformationCase();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 8:
                                                            ProductManager.printFullInformationCooler();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 9:
                                                            ProductManager.printFullInformationSoftware();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 10:
                                                            ProductManager.printFullInformationMonitor();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 11:
                                                            ProductManager.printFullInformationMouse();
                                                            handleProductSellerMenu(scanner);
                                                            break;
                                                        case 12:
                                                            ProductManager.printFullInformationKeyboard();
                                                            handleProductSellerMenu(scanner);
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

                                        }

                                        else
                                        {
                                            System.out.println("\nПродавец не авторизован!");
                                        }

                                        break;
                                    case 5://Поиск по id
                                        if(seller!=null)
                                        {
                                            int searchC;
                                            boolean searchCCC = true;
                                            while(searchCCC)
                                            {
                                                System.out.println("=+=+=+=+=+=+=+=+ Поиск товара по ID +=+=+=+=+=+=+=+=+=+=");
                                                ProductManager.searchProductForSeller();

                                                System.out.print("\nВведите 0 для возвращения к меню продавца:\n" +
                                                        "Введите 1 - чтобы повторно выполнить поиск:\n" +
                                                        "Ваш выбор:");
                                                try {
                                                    searchC = scanner.nextInt();

                                                    switch (searchC)
                                                    {

                                                        case 0:
                                                            searchCCC = false;
                                                            break;
                                                        case 1:

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
                                            System.out.println("\nПродавец не авторизован!");
                                        }

                                        break;
                                    case 6://Изменить товар
                                        if(seller!=null)
                                        {
                                            ProductManager.reWriteTovarAndProduct(scanner);
                                        }

                                        else
                                        {
                                            System.out.println("\nПродавец не авторизован!");
                                        }

                                        break;
                                    case 7://Удалить товар
                                        if(seller!=null)
                                        {
                                            ProductManager.removeTovarAndProduct(scanner);
                                        }

                                        else
                                        {
                                            System.out.println("\nПродавец не авторизован!");
                                        }

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

        Map<String, Product> products_0 = ProductManager.printMiniInfo(categoryName);

        List<Product> products = new ArrayList<>(products_0.values());
        List<Product> products_no_izmen = new ArrayList<>(products_0.values());




        int productChoice;
        boolean productCycle = true;

        while(productCycle) {
            System.out.print("\nВыберите одно из доступных действий:\n" +
                    "1 - Подробнее о товаре\n" +
                    "2 - Вывести товары только в выделенном диапазоне\n" +
                    "3 - Вывести товары только ниже введённой цены\n" +
                    "4 - Вывести товары только выше указанной цены\n" +
                    "5 - Сортировать по увеличению цены\n" +
                    "6 - Сортировать  по уменьшению цены\n" +
                    "7 - Сортировать по уменьшению рейтинга\n" +
                    "8 - Сортировать по увеличению рейтинга\n" +
                    "9 - Сбросить сортировки\n" +
                    "0 - Вернуться к каталогу товаров\n" +
                    "Ваш выбор: ");

            try {
                productChoice = scanner.nextInt();

                switch (productChoice) {
                    case 1:
                        productActionsMenu(scanner);
                        break;
                    case 2:

                        double minPrice=0;
                        double maxPrice=0;
                        boolean priceMinMax = true;
                        while (priceMinMax){


                            System.out.print("\nВведите нижний порог интересующей цены:");
                            try{
                                minPrice = scanner.nextDouble();

                                try {
                                    System.out.print("\nВведите верхний порог интересующей цены:");
                                    maxPrice = scanner.nextDouble();
                                    if(maxPrice<minPrice){
                                        System.out.println("\nОшибка! Верхний порог диапазона не может быть меньше нижнего!");
                                        continue;
                                    }

                                    double finalMinPrice = minPrice;
                                    double finalMaxPrice = maxPrice;
                                    products = products_no_izmen.stream().filter(p -> p.getPrice() >= finalMinPrice).
                                            filter(p -> p.getPrice() <= finalMaxPrice).filter(p ->p.getCategory().equals(categoryName)).collect(Collectors.toList());

                                    if(products.isEmpty()){
                                        System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                                    }else {
                                        System.out.printf("\n=+=+=+=+=+=+=+=+=Товары в ценовом диапазоне от %.2f до %.2f рублей=+=+=+=+=+=+=+=+=+=\n", minPrice, maxPrice);
                                        for(Product product : products){
                                            product.getMiniInfo();
                                            System.out.println("============================================");
                                        }
                                    }

                                    priceMinMax = false;


                                }catch (InputMismatchException e) {
                                    System.out.println("Произошла ошибка!\n" +
                                            "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                            "В прошлый раз вы ввели букву вместо числа!");
                                    scanner.nextLine();
                                } catch (Exception a) {
                                    System.out.println("Произошла неизвестная ошибка!");
                                    scanner.nextLine();
                                }

                            }catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }


                        }

                        break;
                    case 3:

                        double maxP = 0;
                        boolean maxip = true;
                        while(maxip){
                            System.out.print("\nВведите максимальную допустимую цену:");
                            try{

                                maxP = scanner.nextDouble();

                                double finalMaxP = maxP;
                                products = products_no_izmen.stream().filter(p -> p.getPrice()<= finalMaxP).
                                        filter(p -> p.getCategory().equals(categoryName)).collect(Collectors.toList());

                                if(products.isEmpty()){
                                    System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                                }else {
                                    System.out.printf("\n=+=+=+=+=+=+=+=+=Товары, стоящие меньше %.2f рублей=+=+=+=+=+=+=+=+=+=\n", maxP);
                                    for(Product product : products){
                                        product.getMiniInfo();
                                        System.out.println("============================================");
                                    }
                                }
                                maxip = false;

                            }catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }
                        }

                        break;
                    case 4:
                        double minP = 0;
                        boolean minip = true;
                        while(minip){
                            System.out.print("\nВведите минимальную допустимую цену:");
                            try{

                                minP = scanner.nextDouble();
                                double finalMinP = minP;

                                products = products_no_izmen.stream().filter(p-> p.getPrice() >= finalMinP).
                                        filter(p -> p.getCategory().equals(categoryName)).collect(Collectors.toList());

                                if(products.isEmpty()){
                                    System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                                }else {
                                    System.out.printf("\n=+=+=+=+=+=+=+=+=Товары, стоящие больше %.2f рублей=+=+=+=+=+=+=+=+=+=\n", minP);
                                    for(Product product : products){
                                        product.getMiniInfo();
                                        System.out.println("============================================");
                                    }
                                }
                                minip = false;

                            }catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }
                        }

                        break;
                    case 5:
                        products = products_no_izmen.stream().filter(p -> p.getCategory().equals(categoryName))
                                .collect(Collectors.toList());
                        products.sort(comparing(Product::getPrice));
                        if(products.isEmpty()){
                            System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                        }else {
                            System.out.print("\n=+=+=+=+=+=+=+=+=Товары, отсортированные по увеличению цены=+=+=+=+=+=+=+=+=+=\n");
                            for(Product product : products){
                                product.getMiniInfo();
                                System.out.println("============================================");
                            }
                        }

                        break;
                    case 6:
                        products = products_no_izmen.stream().filter(p -> p.getCategory().equals(categoryName))
                                .collect(Collectors.toList());
                        products.sort(comparing(Product::getPrice).reversed());
                        if(products.isEmpty()){
                            System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                        }else {
                            System.out.print("\n=+=+=+=+=+=+=+=+=Товары, отсортированные по уменьшению цены=+=+=+=+=+=+=+=+=+=\n");
                            for(Product product : products){
                                product.getMiniInfo();
                                System.out.println("============================================");
                            }
                        }

                        break;
                    case 7:
                        products = products_no_izmen.stream().filter(p -> p.getCategory().equals(categoryName))
                                .collect(Collectors.toList());
                        products.sort(comparing(Product::getRating).reversed());
                        if(products.isEmpty()){
                            System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                        }else {
                            System.out.print("\n=+=+=+=+=+=+=+=+=Товары, отсортированные по уменьшению рейтинга=+=+=+=+=+=+=+=+=+=\n");
                            for(Product product : products){
                                product.getMiniInfo();
                                System.out.println("============================================");
                            }
                        }

                        break;
                    case 8:
                        products = products_no_izmen.stream().filter(p -> p.getCategory().equals(categoryName))
                                .collect(Collectors.toList());
                        products.sort(comparing(Product :: getRating));
                        if(products.isEmpty()){
                            System.out.println("\nНе найдено товаров, удовлетворяющих критериям вашего отбора!");
                        }else {
                            System.out.print("\n=+=+=+=+=+=+=+=+=Товары, отсортированные по увеличению рейтинга=+=+=+=+=+=+=+=+=+=\n");
                            for(Product product : products){
                                product.getMiniInfo();
                                System.out.println("============================================");
                            }
                        }


                        break;
                    case 9:
                        ProductManager.printMiniInfo(categoryName);
                        products = products_no_izmen;
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
        Product product = ProductManager.searchProductForClient();
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
                            ProductManager.buyProductTovar(product,client,scanner);
                        } else {
                            System.out.println("\nДля выполнения этого действия сначала надо пройти процесс авторизации!");
                        }
                        break;

                    case 2:
                        if(client != null) {
                            client.addShoppingCart(product);
                            FileManager.rewriteClient(client);
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


    public static void handleProductSellerMenu( Scanner scanner){

        int printChoice;
        boolean print = true;
        while(print)
        {
            System.out.print("\nВыберите одно из доступных действий:\n" +
                    "1 - Добавить товар\n" +
                    "2 - Изменить товар\n" +
                    "3 - Удалить товар\n" +
                    "0 - Вернуться к каталогу товаров\n" +
                    "Ваш выбор:");


            try {
                printChoice = scanner.nextInt();

                switch (printChoice)
                {
                    case 1:
                        seller.registrationProduct();
                        break;
                    case 2:
                        ProductManager.reWriteTovarAndProduct(scanner);
                        break;
                    case 3:
                        ProductManager.removeTovarAndProduct(scanner);
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


    }

    public static void Migrator(){
        System.out.println("=== Начало миграции товаров ===");

        // 1. Процессоры
        Map<String, CPU> cpuMap = FileManager.loadCPU();
        FileManager.saveCPU(cpuMap);
        System.out.println("CPU мигрированы: " + cpuMap.size());

        // 2. RAM
        Map<String, RAM> ramMap = FileManager.loadRAM();
        FileManager.saveRAM(ramMap);
        System.out.println("RAM мигрированы: " + ramMap.size());

        // 3. Материнские платы
        Map<String, MotherBoard> mbMap = FileManager.loadMotherBoard();
        FileManager.saveMotherBoard(mbMap);
        System.out.println("MotherBoard мигрированы: " + mbMap.size());

        // 4. Видеокарты
        Map<String, GPU> gpuMap = FileManager.loadGPU();
        FileManager.saveGPU(gpuMap);
        System.out.println("GPU мигрированы: " + gpuMap.size());

        // 5. Накопители
        Map<String, Storage> storageMap = FileManager.loadStorage();
        FileManager.saveStorage(storageMap);
        System.out.println("Storage мигрированы: " + storageMap.size());

        // 6. Блоки питания
        Map<String, PowerSupply> psMap = FileManager.loadPowerSupply();
        FileManager.savePowerSupply(psMap);
        System.out.println("PowerSupply мигрированы: " + psMap.size());

        // 7. Корпуса
        Map<String, Case> caseMap = FileManager.loadCase();
        FileManager.saveCase(caseMap);
        System.out.println("Case мигрированы: " + caseMap.size());

        // 8. Кулеры
        Map<String, Cooler> coolerMap = FileManager.loadCooler();
        FileManager.saveCooler(coolerMap);
        System.out.println("Cooler мигрированы: " + coolerMap.size());

        // 9. ПО
        Map<String, Software> softwareMap = FileManager.loadSoftware();
        FileManager.saveSoftware(softwareMap);
        System.out.println("Software мигрированы: " + softwareMap.size());

        // 10. Мониторы
        Map<String, Monitor> monitorMap = FileManager.loadMonitor();
        FileManager.saveMonitor(monitorMap);
        System.out.println("Monitor мигрированы: " + monitorMap.size());

        // 11. Мыши
        Map<String, Mouse> mouseMap = FileManager.loadMouse();
        FileManager.saveMouse(mouseMap);
        System.out.println("Mouse мигрированы: " + mouseMap.size());

        // 12. Клавиатуры
        Map<String, Keyboard> keyboardMap = FileManager.loadKeyboard();
        FileManager.saveKeyboard(keyboardMap);
        System.out.println("Keyboard мигрированы: " + keyboardMap.size());

        // 13. Общая карта продуктов
        Map<String, Product> productMap = FileManager.loadProduct0();
        FileManager.saveProduct0(productMap);
        System.out.println("Общая карта продуктов мигрирована: " + productMap.size());

        System.out.println("=== Миграция завершена ===");
    }
}
