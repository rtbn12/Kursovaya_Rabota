public class Peripheral extends Product{

    private String connectionType;    // Тип подключения (USB, Bluetooth, Wireless)
    private double cableLength;       // Длина кабеля (м), 0 для беспроводных
    private boolean isWireless;       // Беспроводное устройство
    private boolean hasRGB;           // RGB подсветка
    private String color;             // цвет устройства



    public Peripheral(String id, String brand, String model, String connectionType,
                      double cableLength, boolean isWireless, boolean hasRGB,
                      String color, String countryProduction, int productionDate,
                      int price, String category, String description, int warrantyMoths) {


        super(id, brand, model, countryProduction,
                productionDate, price, category,
                description, warrantyMoths);


        this.connectionType = connectionType;
        this.cableLength = cableLength;
        this.isWireless = isWireless;
        this.hasRGB = hasRGB;
        this.color = color;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public double getCableLength() {
        return cableLength;
    }

    public void setCableLength(double cableLength) {
        this.cableLength = cableLength;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice());
        System.out.println("Цвет устройства: " + getColor());
        System.out.println("Доступные типы подключения: " + getConnectionType());
        System.out.println("Длина кабеля: " + getCableLength() + " м");
        System.out.println("Беспроводное устройство: " + (isWireless() ? "Да" : "Нет"));
        System.out.println("Наличие RGB подсветки: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating());
        System.out.println("Описание: " + getDescription());
    }
}
