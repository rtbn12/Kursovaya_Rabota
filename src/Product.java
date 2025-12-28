import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public  class Product implements Serializable {

    private static final long serialVersionUID = 1L;


    private final String id;
    private String brand;
    private String model;
    private String countryProduction;
    private int productionDate;
    private int price;
    private String category;
    private String description;
    private Date addedDate;
    private double rating;
    private int warrantyMoths;
    private int quantityProduct;
    private Date payDate;

    public Product(String id, String category, Scanner scanner) {
        this.id = id;
        this.addedDate = new Date();
        this.payDate = new Date();
        setBrand(scanner);
        setModel(scanner);
        setCountryProduction(scanner);
        setProductionDate(scanner);
        setPrice(scanner);
        setCategory(category);
        setDescription(scanner);
        setWarrantyMoths(scanner);
        setQuantityProduct(scanner);
        setRating(scanner);
    }

    public Product(String id, String brand, String model,
                   String countryProduction, int productionDate,
                   int price, String category, String description,
                   Date addedDate, double rating, int warrantyMoths,
                   int quantityProduct, Date payDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.countryProduction = countryProduction;
        this.productionDate = productionDate;
        this.price = price;
        this.category = category;
        this.description = description;
        this.addedDate = addedDate;
        this.rating = rating;
        this.warrantyMoths = warrantyMoths;
        this.quantityProduct = quantityProduct;
        this.payDate = payDate;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getCountryProduction() {
        return countryProduction;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public double getRating() {
        return rating;
    }

    public int getWarrantyMoths() {
        return warrantyMoths;
    }

    public String getFullName() {
        return brand + model;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите количество товара на складе: ");
                int input = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                if (input < 0 || input > 10) {
                    System.out.println("Некорректное количество товара! (0-10)");
                    continue;
                }
                this.quantityProduct = input;
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public void setBrand(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите бренд: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Бренд не может быть пустым!");
                    continue;
                }
                this.brand = input;
                valid = true;
            } catch (Exception e) {
                System.out.println("Ошибка ввода бренда: " + e.getMessage());
            }
        }
    }

    public void setModel(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите модель: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Модель не может быть пустой!");
                    continue;
                }
                this.model = input;
                valid = true;
            } catch (Exception e) {
                System.out.println("Ошибка ввода модели: " + e.getMessage());
            }
        }
    }

    public void setCountryProduction(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите страну производителя: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Страна производителя не может быть пустой!");
                    continue;
                }
                this.countryProduction = input;
                valid = true;
            } catch (Exception e) {
                System.out.println("Ошибка ввода страны производителя: " + e.getMessage());
            }
        }
    }

    public void setProductionDate(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите год производства: ");
                int input = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                if (input < 2018 || input > currentYear) {
                    System.out.println("Некорректный год производства! Должен быть между 2018 и " + currentYear);
                    continue;
                }
                this.productionDate = input;
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public void setPrice(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите цену товара: ");
                int input = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                if (input <= 0 || input > 1_000_000) {
                    System.out.println("Введена недоступная цена для товара! (1 - 1,000,000)");
                    continue;
                }
                this.price = input;
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите описание товара: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Описание не может быть пустым!");
                    continue;
                }
                if (input.length() > 500) {
                    System.out.println("Описание товара слишком длинное! (максимум 500 символов)");
                    continue;
                }
                this.description = input;
                valid = true;
            } catch (Exception e) {
                System.out.println("Ошибка ввода описания: " + e.getMessage());
            }
        }
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setRating(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите рейтинг товара (0-5): ");
                double input = scanner.nextDouble();
                scanner.nextLine(); // очистка буфера

                if (input < 0 || input > 5) {
                    System.out.println("Некорректный рейтинг! (0-5)");
                    continue;
                }
                this.rating = Math.round(input * 100.0) / 100.0; // округляем до 2 знаков
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение рейтинга!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public void setWarrantyMoths(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nВведите срок предоставляемой гарантии на товар в целом количестве месяцев: ");
                int input = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                if (input < 0 || input > 120) {
                    System.out.println("Вы ввели некорректный срок гарантии! (0-120 месяцев)");
                    continue;
                }
                this.warrantyMoths = input;
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение срока гарантии!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }





    public void getMiniInfo()
    {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice());
        System.out.println("Рейтинг: " + getRating());
    }

    public void getFullInfoForClient()
    {

    }

    public void getFullInfoForSeller()
    {

        System.out.println("Дата добавления товара: " + getAddedDate());
        System.out.println("Количество товара на складе: " + getQuantityProduct() + " шт.");

    }

    public void getFullInformationForShoppingList(){
        System.out.println("Дата покупки товара: " + getPayDate());
    }

}
