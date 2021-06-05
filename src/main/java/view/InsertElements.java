package view;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Foods;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

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

        //Inserir dados
        MongoCollection<Foods> collection = database.getCollection("Testes", Foods.class);
        List<Foods> foods = asList(
                new Foods(false,"teste4",22),
                new Foods(true,"teste5",12),
                new Foods(false,"teste6",45)
        );
//        collection.insertMany(foods);
//        System.out.println(foods);

        //Acessar dados
    };

    public void search(){

    }
}










//    sudo systemctl start mongod
//    sudo systemctl status mongod
//    sudo service mongod start
//    sudo service mongod status
//    mongo
