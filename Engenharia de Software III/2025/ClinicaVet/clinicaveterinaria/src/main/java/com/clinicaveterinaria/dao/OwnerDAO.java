package com.clinicaveterinaria.dao;

import com.clinicaveterinaria.model.Owner;
import com.clinicaveterinaria.singleton.MongoDBConnection;
import com.clinicaveterinaria.adapter.DocumentAdapter;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

// DAO Pattern
public class OwnerDAO {
    private MongoCollection<Document> coll;

    public OwnerDAO() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        coll = db.getCollection("owners");
    }

    public void insert(Owner o) {
        coll.insertOne(DocumentAdapter.fromOwner(o));
    }

    public List<Owner> findAll() {
        List<Owner> list = new ArrayList<>();
        for (Document d : coll.find()) {
            list.add(DocumentAdapter.toOwner(d));
        }
        return list;
    }

    public Owner findById(String id) {
        Document d = coll.find(Filters.eq("_id", new org.bson.types.ObjectId(id))).first();
        return d == null ? null : DocumentAdapter.toOwner(d);
    }

    public UpdateResult update(String id, Owner o) {
        return coll.updateOne(
                Filters.eq("_id", new org.bson.types.ObjectId(id)),
                Updates.combine(
                        Updates.set("name", o.getName()),
                        Updates.set("birthDate", o.getBirthDate().toString()),
                        Updates.set("address", o.getAddress()),
                        Updates.set("phone", o.getPhone()),
                        Updates.set("cpf", o.getCpf()),
                        Updates.set("petIds", o.getPetIds())));
    }

    public DeleteResult delete(String id) {
        return coll.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
    }

}
