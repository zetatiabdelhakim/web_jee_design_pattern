package ma.xproce.database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.bson.Document;

@Getter
@Setter
@Builder
public class Mongodb implements DatabaseFacade {
    String dbName;
    String conection;
    @Override
    public MongoDatabase databaseLayer() {
        MongoClient mongoClient = MongoClients.create(new ConnectionString(conection));
        return mongoClient.getDatabase(dbName);
    }
}