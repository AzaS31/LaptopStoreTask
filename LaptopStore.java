package LaptopHW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopStore {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Lenovo", "white", 250, 16, "Windows", 500);
        Laptop laptop2 = new Laptop("Acer", "grey", 500, 32, "Windows", 1200);
        Laptop laptop3 = new Laptop("HP", "black", 320, 8, "Linux", 650);
        Laptop laptop4 = new Laptop("Acer", "black", 500, 16, "Linux", 800);
        Laptop laptop5 = new Laptop("Lenovo", "grey", 128, 8, "Linux", 300);
        Laptop laptop6 = new Laptop("Macbook", "grey", 500, 32, "MacOS", 2000);
        Laptop laptop7 = new Laptop("Macbook", "white", 256, 16, "MacOS", 1600);

        Set<Laptop> laptops = new HashSet<>(
                Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        System.out.println("1 - Бренд");
        System.out.println("2 - Цвет");
        System.out.println("3 - Жесткий Диск");
        System.out.println("4 - ОЗУ");
        System.out.println("5 - Операционная система");
        System.out.println("6 - Цена");
        System.out.print("Выберите критерий фильтрации: ");

        try {
            int criterionNumber = scanner.nextInt();

            switch (criterionNumber) {
                case 1:
                    System.out.print("Введите Бренд(Lenovo, Acer, HP, Macbook): ");
                    String brand = scanner.next();
                    filters.put("brand", brand);
                    break;
                case 2:
                    System.out.print("Введите цвет(white, grey, black): ");
                    String color = scanner.next();
                    filters.put("color", color);
                    break;
                case 3:
                    System.out.print("Введите (минимальный) объем Жесткого Диска: ");
                    int minHardDrive = scanner.nextInt();
                    filters.put("minHardDrive", minHardDrive);
                    break;
                case 4:
                    System.out.print("Введите (минимальный) ОЗУ: ");
                    int minRam = scanner.nextInt();
                    filters.put("minRam", minRam);
                    break;
                case 5:
                    System.out.print("Введите операционную систему(Windows, Linux, MacOS): ");
                    String operatingSystem = scanner.next();
                    filters.put("operatingSystem", operatingSystem);
                    break;
                case 6:
                    System.out.print("Введите максимальную цену (в долларах): ");
                    int maxPrice = scanner.nextInt();
                    filters.put("maxPrice", maxPrice);
                    break;
                default:
                    System.out.println("Некорректный выбор критерия фильтрации.");
            }

            Set<Laptop> filteredLaptops = filterLaptops(filters, laptops);
            if (filteredLaptops.isEmpty()) {
                System.out.println("Нет ноутбуков, соответствующих вашему запросу.");
            } else {
                System.out.println("Найденные ноутбуки:");
                for (Laptop laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
        } finally {
            scanner.close();
        }
    }

    public static Set<Laptop> filterLaptops(Map<String, Object> filters, Set<Laptop> laptops) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String criterion = entry.getKey();
            Object value = entry.getValue();

            switch (criterion) {
                case "brand":
                    filteredLaptops.removeIf(laptop -> !laptop.getBrand().equals(value));
                    break;
                case "color":
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equals(value));
                    break;
                case "minHardDrive":
                    int minHardDrive = (int) value;
                    filteredLaptops.removeIf(laptop -> laptop.getHardDrive() < minHardDrive);
                    break;
                case "minRam":
                    int minRam = (int) value;
                    filteredLaptops.removeIf(laptop -> laptop.getRam() < minRam);
                    break;
                case "operatingSystem":
                    filteredLaptops.removeIf(laptop -> !laptop.getOperatingSystem().equals(value));
                    break;
                case "maxPrice":
                    int maxPrice = (int) value;
                    filteredLaptops.removeIf(laptop -> laptop.getPrice() > maxPrice);
                    break;
                default:
                    System.out.println("Неизвестный критерий фильтрации: " + criterion);
            }
        }
        return filteredLaptops;
    }
}
