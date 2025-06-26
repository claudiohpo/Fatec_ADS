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
        String uri = "mongodb+srv://fatecADS:fatec123@clinicavet.nsgakn6.mongodb.net/?retryWrites=true&w=majority&appName=ClinicaVet";
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