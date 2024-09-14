package com.wenigo.servieLayers;

import com.wenigo.entities.ShuttleCab;
import com.wenigo.request.ShuttleCabUpdateRequest;

import java.util.List;

public interface ShuttleCabService {
    public void saveShuttleCabDetails(ShuttleCab shuttleCab);
    public List<ShuttleCab> getShuttleCabDetails();
    public ShuttleCab getShuttleCabById(String cabId);

    List<ShuttleCab> getShuttleCabDetailsForOnlyCap();

    void updateShuttleCab(ShuttleCabUpdateRequest shuttleCabUpdateRequest);
}
