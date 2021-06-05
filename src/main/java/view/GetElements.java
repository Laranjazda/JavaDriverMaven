package view;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Foods;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class GetElements {
    public static void main(String[] args) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase database = mongoClient.getDatabase("mongo_connection")
                .withCodecRegistry(pojoCodecRegistry);

        try{
            FindIterable<Foods> cursor = database.getCollection("product",Foods.class).find();
            System.out.println("--------");
            while (cursor == database.getCollection ("product", Foods.class)) {
                BasicDBObject produtos;
                produtos = (BasicDBObject) cursor.cursor();
                System.out.println("Perecivel: " + produtos.getBoolean("isPerishable"));
                System.out.println("Nome: " + produtos.getString ("description"));
                System.out.println("Preço: " + produtos.getInt ("Price"));
            }
        } catch (Exception exception){
            System.err.println("=====================\n"
                    + "Produto não encontrado \n"
                    + "Erro: "+ exception.getClass().getName() + "\n"
                    + "Mensagem: " + exception.getMessage()+"\n"
                    + "=====================\n");
        }
    }
}