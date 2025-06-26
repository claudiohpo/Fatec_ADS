package com.clinicaveterinaria.dao;

import com.clinicaveterinaria.model.Veterinarian;
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
public class VeterinarianDAO {
    private MongoCollection<Document> coll;

    public VeterinarianDAO() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        coll = db.getCollection("veterinarians");
    }

    public void insert(Veterinarian v) {
        coll.insertOne(DocumentAdapter.fromVeterinarian(v));
    }

    public List<Veterinarian> findAll() {
        List<Veterinarian> list = new ArrayList<>();
        for (Document d : coll.find()) {
            list.add(DocumentAdapter.toVeterinarian(d));
        }
        return list;
    }

    public Veterinarian findById(String id) {
        Document d = coll.find(Filters.eq("_id", new org.bson.types.ObjectId(id))).first();
        return d == null ? null : DocumentAdapter.toVeterinarian(d);
    }

    public UpdateResult update(String id, Veterinarian v) {
        return coll.updateOne(
                Filters.eq("_id", new org.bson.types.ObjectId(id)),
                Updates.combine(
                        Updates.set("nome", v.getNome()),
                        Updates.set("crmv", v.getCrmv()),
                        Updates.set("especialidade", v.getEspecialidade()),
                        Updates.set("telefone", v.getTelefone()),
                        Updates.set("dataNascimento",
                                v.getDataNascimento() != null
                                        ? v.getDataNascimento().toString()
                                        : null)));
    }

    public DeleteResult delete(String id) {
        return coll.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
    }
}
