package model;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.*;

public class AddProducts {
    private MongoClient connection;
    private MongoDatabase database;

    public void addProduct(Foods insert) throws MongoException{
        this.connection = new MongoClient("localhost");
        this.database = connection.getDatabase("mongo_connection");

        try {
            BasicDBObject newProduct = new BasicDBObject();
            newProduct.put("isPerishable", insert.isPerishable());
            newProduct.put("description", insert.getDescription());
            newProduct.put("price", insert.getPrice());

            DBCollection insertFoods = (DBCollection) database.getCollection("product");
            insertFoods.insert(newProduct);
            System.out.println("PRODUTO INSERIDO NO BANCO DE DADOS COM SUCESSO!\n" + newProduct);

        }  catch (Exception exception){
            System.err.println("=====================\n"
                    + "Produto não inserido \n"
                    + "Erro: "+exception.getClass().getName() + "\n"
                    + "Mensagem: " + exception.getMessage()+"\n"
                    + "=====================\n");
        }
    }

    public void getProduct() throws UnknownHostException, MongoException {
        this.connection = new MongoClient("localhost");
        this.database = connection.getDatabase("mongo_connection");

        try{
            FindIterable<Document> cursor = database.getCollection("product").find();
            System.out.println("--------");
            while (cursor.sort(cursor.first()) {
                BasicDBObject produtos;
                produtos = (BasicDBObject) cursor.cursor();
                System.out.println("Perecivel: " + produtos.getBoolean("isPerishable"));
                System.out.println("Nome: " + produtos.getBoolean("description"));
                System.out.println("Preço: " + produtos.getBoolean("Price"));
            }
        } catch (Exception exception){
            System.err.println("=====================\n"
                    + "Produto não inserido \n"
                    + "Erro: "+exception.getClass().getName() + "\n"
                    + "Mensagem: " + exception.getMessage()+"\n"
                    + "=====================\n");
        }
    }

}

//    sudo systemctl start mongod
//    sudo systemctl status mongod
//    sudo service mongod start
//    sudo service mongod status
//    mongo


//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongo_connection").withCodecRegistry(pojoCodecRegistry);
//
//        MongoCollection<Foods> insertFoodsList = mongoDatabase.getCollection("product", Foods.class);
//        insertFoodsList.insertOne(new Foods(true, "Banana", 4));
//        MongoCursor<Foods> inseridos = conectionFoods.find(Filters.eq("isPerishable"), Foods.class).iterator();
//
//        List<Foods> foods = asList(
//                new Foods(false,"Arroz",5),
//                new Foods(true,"Maçã",3),
//                new Foods(false,"Café",8)
//        );
//        insertFoodsList.insertMany(foods);






//        System.out.println("================\n"
//                + "Produtos Inseridos:\n"
//                + c
//                + "\n================");

//        this.connection = new MongoClient("127.0.0.1", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
//        this.database = connection.getDatabase("mongo_connection");
