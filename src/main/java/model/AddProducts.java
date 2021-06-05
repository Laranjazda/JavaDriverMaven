package model;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.net.UnknownHostException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AddProducts {
//    private MongoClient connection;
//    private MongoDatabase database;
//
//    @Override
//    public String toString() {
//        return "AddProducts{" +
//                "connection=" + connection +
//                ", database=" + database +
//                '}';
//    }


    @Override
    public String toString() {
        return "AddProducts{}";
    }

    public void addProduct(Foods insert) throws MongoException{
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongo_connection").withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Foods> c = mongoDatabase.getCollection("product", Foods.class);
//        c.insertOne(new Foods(true, "Banana", 4));
//        MongoCursor<Foods> inseridos = c.find(Filters.eq("isPerishable"), Foods.class).iterator();

        List<Foods> foods = asList(
                new Foods(false,"Arroz",5),
                new Foods(true,"Maçã",3),
                new Foods(false,"Café",8)
        );
        c.insertMany(foods);


        System.out.println("================\n"
                + "Produtos Inseridos:\n"
                + c
                + "\n================");

//        this.connection = new MongoClient("127.0.0.1", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
//        this.database = connection.getDatabase("mongo_connection");

//        try {
//            BasicDBObject newProduct = new BasicDBObject();
//
//            newProduct.put("isPerishable", insert.getPerishable());
//            newProduct.put("description", insert.getDescription());
//            newProduct.put("price", insert.getPrice());
//
//            DBCollection c = (DBCollection) mongoDatabase.getCollection("product");
//            c.insert(newProduct);
//            System.out.println("PRODUTO INSERIDO NO BANCO DE DADOS COM SUCESSO!");
//        }  catch (Exception exception){
//            System.err.println("=====================\n"
//                    + "Produto não inserido \n"
//                    + "Erro: "+exception.getClass().getName() + "\n"
//                    + "Mensagem: " + exception.getMessage()+"\n"
//                    + "=====================\n");
//        }





    }


}
