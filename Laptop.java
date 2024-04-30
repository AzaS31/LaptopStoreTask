package LaptopHW;

import java.util.Objects;

public class Laptop {
    String brand;
    String color;
    int hardDrive;
    int ram;
    String operatingSystem;
    int price;

    public Laptop(String brand, String color, int hardDrive, int ram, String operatingSystem, int price) {
        this.brand = brand;
        this.color = color;
        this.hardDrive = hardDrive;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }
    public String getBrand () {
        return brand;
    }
    public String getColor () {
        return color;
    }
    public String getOperatingSystem () {
        return operatingSystem;
    }
    public int getHardDrive () {
        return hardDrive;
    }
    public int getRam () {
        return ram;
    }
    public int getPrice () {
        return price;
    }
    public void setBrand (String brand) {
        this.brand = brand;
    }
    public void setColor (String color) {
        this.color = color;
    }
    public void setOpertatingSystem (String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }
    public void setRam (int ram) {
        this.ram = ram;
    }
    public void setPrice (int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("Бренд: %s, Цвет: %s, Жесткий Диск: %dgb, Оперативная память: %dgb, Операционная система: %s, Цена: %s$", 
        brand, color, hardDrive, ram, operatingSystem, price);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return brand == laptop.brand && color.equals(laptop.color) && hardDrive == laptop.hardDrive && 
        ram == laptop.ram && operatingSystem.equals(laptop.operatingSystem) && price == laptop.price; 
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand, color, hardDrive, ram, operatingSystem, price);
    }
}
