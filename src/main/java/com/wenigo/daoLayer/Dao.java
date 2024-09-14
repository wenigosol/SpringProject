package com.wenigo.daoLayer;

import com.wenigo.entities.ShuttleCab;
import com.wenigo.request.ShuttleCabUpdateRequest;

import java.util.List;

public interface Dao {
   public ShuttleCab saveCabDetails(ShuttleCab shuttleCab);
   public List<ShuttleCab> getAllCabDetails();
   public ShuttleCab getShuttleCabById(String cabId);
   void updateShuttleCab(ShuttleCab shuttleCab);
}
