package com.wenigo.controllers;

import com.wenigo.Response.ShuttleCabResponse;
import com.wenigo.entities.ShuttleCab;
import com.wenigo.request.ShuttleCabUpdateRequest;
import com.wenigo.servieLayers.ShuttleCabServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wenigo.servieLayers.ShuttleCabService;

import java.util.List;

@RestController
public class Controller {
    @Autowired

    ShuttleCabService shuttleCabService;
    private static final Logger logger = LogManager.getLogger(Controller.class);

    @PostMapping("/saveCabDetails")
    public ResponseEntity<String> saveCabDetails(@RequestBody ShuttleCab shuttleCab){
        shuttleCabService.saveShuttleCabDetails(shuttleCab);
        return new ResponseEntity<>("saved successfullly!!!", HttpStatus.CREATED);
    }

    @GetMapping("/getAllCabDetails")
    public ResponseEntity<List<ShuttleCab>> getShuttleCabDetails(){
    List<ShuttleCab> shuttleCabs = shuttleCabService.getShuttleCabDetails();
        return new ResponseEntity<List<ShuttleCab>>(shuttleCabs,HttpStatus.OK);
    }

    @GetMapping("/getShuttleCabById/{cabId}")
    public ResponseEntity<ShuttleCab> getShuttleCabByID(@PathVariable String cabId){
        ShuttleCab shuttleCab = shuttleCabService.getShuttleCabById(cabId);
        return new ResponseEntity<>(shuttleCab,HttpStatus.OK);
    }

    @GetMapping("/getShuttleCabCapacities")
    public ResponseEntity<ShuttleCabResponse> getShuttleCabDetailsForCap(){
        logger.info("entered into method getShuttleCabCapacities");
        List<ShuttleCab> shuttleCabList = shuttleCabService.getShuttleCabDetailsForOnlyCap();
        ShuttleCabResponse shuttleCabResponse = new ShuttleCabResponse();
        shuttleCabResponse.setShuttleCabs(shuttleCabList);
        logger.info("Execution Completed method getShuttleCabCapacities");
        return new ResponseEntity<>(shuttleCabResponse,HttpStatus.OK);
    }

//    @PutMapping("/updateCabDetails")
//    public ResponseEntity<String> updateCabById(@RequestBody Shuttl eCabUpdateRequest shuttleCabUpdateRequest){
//        shuttleCabService.updateShuttleCab(shuttleCabUpdateRequest);
//        return new ResponseEntity<>("updated successfully",HttpStatus.OK);



}
