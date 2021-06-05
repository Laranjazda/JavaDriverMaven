package view;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Foods;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.net.UnknownHostException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class InsertElements {
    public static void main(String[] args) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

        MongoDatabase database = mongoClient.getDatabase("mongo_connection")
                .withCodecRegistry(pojoCodecRegistry);

//        //Inserir dados
        MongoCollection<Foods> collection = database.getCollection("product", Foods.class);
        List<Foods> foods = asList(
                new Foods(false,"teste4",22),
                new Foods(true,"teste5",12),
                new Foods(true,"teste6",45)
        );
        collection.insertMany(foods);
        System.out.println(foods);
    };
    //Acessar dados
//    public void getProduct() throws UnknownHostException, MongoException {
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//
//        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
//
//        MongoDatabase database = mongoClient.getDatabase("mongo_connection")
//                .withCodecRegistry(pojoCodecRegistry);
//
//        //Inserir dados
//        MongoCollection<Foods> collection = database.getCollection("product", Foods.class);
//
//        try{
//            FindIterable<Document> cursor = database.getCollection("product").find();
//            System.out.println("--------");
//            while (cursor == (FindIterable<Document>) database.getCollection ("product", Foods.class)) {
//                BasicDBObject produtos;
//                produtos = (BasicDBObject) cursor.cursor();
//                System.out.println("Perecivel: " + produtos.getBoolean("isPerishable"));
//                System.out.println("Nome: " + produtos.getBoolean("description"));
//                System.out.println("Preço: " + produtos.getBoolean("Price"));
//            }
//        } catch (Exception exception){
//            System.err.println("=====================\n"
//                    + "Produto não inserido \n"
//                    + "Erro: "+exception.getClass().getName() + "\n"
//                    + "Mensagem: " + exception.getMessage()+"\n"
//                    + "=====================\n");
//        }
    }






//    sudo systemctl start mongod
//    sudo systemctl status mongod
//    sudo service mongod start
//    sudo service mongod status
//    mongo
