public class Mouse extends Peripheral{

    private int dpi;                    // Чувствительность (DPI)
    private int buttonsCount;           // Количество кнопок
    private String sensorType;          // Тип сенсора (оптический, лазерный)
    private boolean isGaming;           // Игровая мышь


    public Mouse(String id, String brand, String model,int dpi,
                 int buttonsCount, String sensorType, boolean isGaming,
                 String connectionType, double cableLength,
                 boolean isWireless, boolean hasRGB, String color,
                 String countryProduction, int productionDate,String category,
                 int price, String description,
                 int warrantyMoths) {


        super(id, brand, model, connectionType, cableLength, isWireless,
                hasRGB, color, countryProduction, productionDate, price,
                 category, description, warrantyMoths);


        this.dpi = dpi;
        this.buttonsCount = buttonsCount;
        this.sensorType = sensorType;
        this.isGaming = isGaming;

    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getButtonsCount() {
        return buttonsCount;
    }

    public void setButtonsCount(int buttonsCount) {
        this.buttonsCount = buttonsCount;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public boolean isGaming() {
        return isGaming;
    }

    public void setGaming(boolean gaming) {
        isGaming = gaming;
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
