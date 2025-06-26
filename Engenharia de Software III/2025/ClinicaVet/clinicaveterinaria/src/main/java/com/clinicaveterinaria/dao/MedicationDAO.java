package com.clinicaveterinaria.dao;

import com.clinicaveterinaria.model.Medication;
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

// DAO Pattern
public class MedicationDAO {
    private MongoCollection<Document> coll;

    public MedicationDAO() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        coll = db.getCollection("medications");
    }

    public void insert(Medication m) {
        coll.insertOne(DocumentAdapter.fromMedication(m));
    }

    public List<Medication> findAll() {
        List<Medication> list = new ArrayList<>();
        for (Document d : coll.find()) {
            list.add(DocumentAdapter.toMedication(d));
        }
        return list;
    }

    public Medication findById(String id) {
        Document d = coll.find(Filters.eq("_id", new org.bson.types.ObjectId(id))).first();
        return d == null ? null : DocumentAdapter.toMedication(d);
    }

    public UpdateResult update(String id, Medication m) {
        return coll.updateOne(
                Filters.eq("_id", new org.bson.types.ObjectId(id)),
                Updates.combine(
                        Updates.set("name", m.getName()),
                        Updates.set("manufacturer", m.getManufacturer()),
                        Updates.set("dosage", m.getDosage()),
                        Updates.set("unit", m.getUnit()),
                        Updates.set("stock", m.getStock())));
    }

    public DeleteResult delete(String id) {
        return coll.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
    }
}