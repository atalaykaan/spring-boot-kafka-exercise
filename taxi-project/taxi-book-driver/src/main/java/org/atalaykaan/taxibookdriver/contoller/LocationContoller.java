package org.atalaykaan.taxibookdriver.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/location")
public class LocationContoller {

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateLocation() {

        return ResponseEntity.ok(Map.of("location", "locationValue"));
    }
}
