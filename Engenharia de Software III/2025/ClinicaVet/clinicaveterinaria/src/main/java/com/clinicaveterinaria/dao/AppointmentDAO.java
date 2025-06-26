package com.clinicaveterinaria.dao;

import com.clinicaveterinaria.model.Appointment;
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
public class AppointmentDAO {
    private MongoCollection<Document> coll;

    public AppointmentDAO() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        coll = db.getCollection("appointments");
    }

    public void insert(Appointment a) {
        coll.insertOne(DocumentAdapter.fromAppointment(a));
    }

    public List<Appointment> findAll() {
        List<Appointment> list = new ArrayList<>();
        for (Document d : coll.find()) {
            list.add(DocumentAdapter.toAppointment(d));
        }
        return list;
    }

    public Appointment findById(String id) {
        Document d = coll.find(Filters.eq("_id", new org.bson.types.ObjectId(id))).first();
        return d == null ? null : DocumentAdapter.toAppointment(d);
    }

    public UpdateResult update(String id, Appointment a) {
        return coll.updateOne(
                Filters.eq("_id", new org.bson.types.ObjectId(id)),
                Updates.combine(
                        Updates.set("date", a.getDate().toString()),
                        Updates.set("petId", a.getPetId()),
                        Updates.set("ownerId", a.getOwnerId()),
                        Updates.set("anamnese", a.getAnamnese()),
                        Updates.set("veterinarianId", a.getVeterinarianId())));
    }

    public DeleteResult delete(String id) {
        return coll.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
    }

}