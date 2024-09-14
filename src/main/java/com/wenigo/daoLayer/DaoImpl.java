package com.wenigo.daoLayer;

import com.wenigo.entities.ShuttleCab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DaoImpl implements Dao {
     @Autowired
    MongoTemplate mongoTemplate;




    @Override
    public ShuttleCab saveCabDetails(ShuttleCab shuttleCab) {
        mongoTemplate.save(shuttleCab,"cabdetails");
        return null;
    }

    @Override
    public List<ShuttleCab> getAllCabDetails() {
        return mongoTemplate.findAll(ShuttleCab.class,"cabdetails");
    }

    @Override
    public ShuttleCab getShuttleCabById(String cabId){
    Query query = new Query(Criteria.where("cabId").is(cabId));
    List<ShuttleCab> shuttleCab = mongoTemplate.find(query,ShuttleCab.class,"cabdetails");
    return shuttleCab.get(0);

    }

    @Override
    public void updateShuttleCab(ShuttleCab shuttleCab) {
        mongoTemplate.save(shuttleCab,"cabdetails");
    }

}
