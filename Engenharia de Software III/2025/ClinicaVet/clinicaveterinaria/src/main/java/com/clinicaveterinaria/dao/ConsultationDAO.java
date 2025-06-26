package com.clinicaveterinaria.dao;

import com.clinicaveterinaria.model.Consultation;
import com.clinicaveterinaria.singleton.MongoDBConnection;
import com.clinicaveterinaria.adapter.DocumentAdapter;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

// DAO Pattern
public class ConsultationDAO {
    private final MongoCollection<Document> coll;

    public ConsultationDAO() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        this.coll = db.getCollection("consultations");
    }

    public void insert(Consultation c) {
        coll.insertOne(DocumentAdapter.fromConsultation(c));
    }

    public List<Consultation> findAll() {
        List<Consultation> list = new ArrayList<>();
        for (Document doc : coll.find()) {
            list.add(DocumentAdapter.toConsultation(doc));
        }
        return list;
    }

    public Consultation findById(String id) {
        Document doc = coll.find(Filters.eq("_id", new ObjectId(id))).first();
        return doc != null ? DocumentAdapter.toConsultation(doc) : null;
    }

    public UpdateResult update(String id, Consultation c) {
        return coll.updateOne(
                Filters.eq("_id", new ObjectId(id)),
                Updates.combine(
                        Updates.set("petId", c.getPetId()),
                        Updates.set("veterinarianId", c.getVeterinarianId()),
                        Updates.set("description", c.getDescription()),
                        Updates.set("prescription", c.getPrescription()),
                        Updates.set("date", c.getDate())));
    }

    public DeleteResult delete(String id) {
        return coll.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
}