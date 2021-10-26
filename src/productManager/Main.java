package productManager;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
    public static void findDataFromFileById(String path ,int id){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
            for (Product product : products){
                if (product.getId() == id ){
                    System.out.println("Sản phẩm cần tìm là " + product );
                    return;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Ko tìm thấy sản phẩm");
    }
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"sữa","vinamilk",5000,"sữa nóng"));
        products.add(new Product(2,"kem","TH true milk",6000,"kem"));
        products.add(new Product(3,"thịt bò","3g",10000,"thịt"));
        products.add(new Product(4,"bơ","president",12000,"bơ sữa"));
        products.add(new Product(5,"mỳ hảo hảo","acecook",3000,"mỳ ăn liền"));
//        writeToFile("List product.txt",products);
//        List<Product> readDataFromFile = readDataFromFile("List product.txt");
//        for (Product product : readDataFromFile){
//            System.out.println(product);
//        }
        findDataFromFileById("List product.txt",2);
        findDataFromFileById("List product.txt",10);
    }
}
