package model;

import com.mongodb.MongoException;

public class Main {
    public static void main(String[] args) throws MongoException {
        Foods f1 = new Foods(true, "Banana", 5);

//        List<Foods> foods = asList(
//                new Foods(false,"Arroz",5),
//                new Foods(true,"Maçã",3),
//                new Foods(false,"Café",8)
//        );

        AddProducts connection = new AddProducts();

        connection.addProduct(f1);
        System.out.println("Conexão Realizada");

    }
}
