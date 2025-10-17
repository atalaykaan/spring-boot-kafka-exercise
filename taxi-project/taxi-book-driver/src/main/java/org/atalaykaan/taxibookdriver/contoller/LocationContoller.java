package org.atalaykaan.taxibookdriver.contoller;

import lombok.AllArgsConstructor;
import org.atalaykaan.taxibookdriver.dto.LocationResponseDto;
import org.atalaykaan.taxibookdriver.service.LocationProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location")
@AllArgsConstructor
public class LocationContoller {

    private final LocationProducerService locationProducerService;

    @PutMapping
    public ResponseEntity<LocationResponseDto> updateLocation() {

        return ResponseEntity.ok(locationProducerService.sendMessage());
    }
}
