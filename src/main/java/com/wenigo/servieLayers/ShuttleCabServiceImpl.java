package com.wenigo.servieLayers;

import com.wenigo.entities.ShuttleCab;
import com.wenigo.daoLayer.Dao;
import com.wenigo.request.ShuttleCabUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShuttleCabServiceImpl implements ShuttleCabService{
    @Autowired
    Dao dao;
    @Override
    public void saveShuttleCabDetails(ShuttleCab shuttleCab) {

        dao.saveCabDetails(shuttleCab);
    }

    @Override
    public List<ShuttleCab> getShuttleCabDetails() {
       List<ShuttleCab> shuttleCab = dao.getAllCabDetails();
        return shuttleCab;
    }

    @Override
    public ShuttleCab getShuttleCabById(String cabId){
        return dao.getShuttleCabById(cabId);
    }

    @Override
    public List<ShuttleCab> getShuttleCabDetailsForOnlyCap() {
        List<ShuttleCab> list = dao.getAllCabDetails();
        List<ShuttleCab> response = new ArrayList<>();

            for (ShuttleCab sc: list) {
                ShuttleCab shuttleCab = new ShuttleCab();
                shuttleCab.setCabId(sc.getCabId());
                shuttleCab.setCapacity(sc.getCapacity());
                response.add(shuttleCab);
            }
        return response;
    }

    @Override
    public void updateShuttleCab(ShuttleCabUpdateRequest shuttleCabUpdateRequest) {
        ShuttleCab shuttleCab = dao.getShuttleCabById(shuttleCabUpdateRequest.getCabId());
        shuttleCab.setCapacity(shuttleCabUpdateRequest.getCapacity());
        dao.updateShuttleCab(shuttleCab);
    }
}

