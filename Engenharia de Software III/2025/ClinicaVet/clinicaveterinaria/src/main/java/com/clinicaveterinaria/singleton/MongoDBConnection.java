package com.clinicaveterinaria.singleton;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

// Singleton Pattern
public class MongoDBConnection {
    private static MongoDBConnection instance;
    private MongoClient client;
    private MongoDatabase database;

    private MongoDBConnection() {
        String uri = "Insira aqui sua chave de conexão com banco de dados";
        client = MongoClients.create(uri);
        database = client.getDatabase("ClinicaVet");
    }

    public static synchronized MongoDBConnection getInstance() {
        if (instance == null)
            instance = new MongoDBConnection();
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
