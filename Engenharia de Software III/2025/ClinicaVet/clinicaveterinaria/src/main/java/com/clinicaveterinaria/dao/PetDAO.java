package com.clinicaveterinaria.dao;

import com.clinicaveterinaria.model.Pet;
import com.clinicaveterinaria.singleton.MongoDBConnection;
import com.clinicaveterinaria.adapter.DocumentAdapter;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;

// DAO Pattern:
public class PetDAO {
    private MongoCollection<Document> coll;

    public PetDAO() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        coll = db.getCollection("pets");
    }

    public void insert(Pet p) {
        coll.insertOne(DocumentAdapter.fromPet(p));
    }

    public List<Pet> findAll() {
        List<Pet> list = new ArrayList<>();
        for (Document d : coll.find()) {
            list.add(DocumentAdapter.toPet(d));
        }
        return list;
    }

    public Pet findById(String id) {
        Document d = coll.find(Filters.eq("_id", new org.bson.types.ObjectId(id))).first();
        return d == null ? null : DocumentAdapter.toPet(d);
    }

    public UpdateResult update(String id, Pet p) {
        return coll.updateOne(
                Filters.eq("_id", new org.bson.types.ObjectId(id)),
                Updates.combine(
                        Updates.set("name", p.getName()),
                        Updates.set("breed", p.getBreed()),
                        Updates.set("birthDate", p.getBirthDate().toString()),
                        Updates.set("color", p.getColor()),
                        Updates.set("weight", p.getWeight()),
                        Updates.set("allergies", p.getAllergies()),
                        Updates.set("ownerId", p.getOwnerId()),
                        Updates.set("medicationIds", p.getMedicationIds())));
    }

    public DeleteResult delete(String id) {
        return coll.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
    }
}