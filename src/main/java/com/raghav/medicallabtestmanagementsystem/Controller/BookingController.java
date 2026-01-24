package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.Entity.Booking;
import com.raghav.medicallabtestmanagementsystem.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("")
    public ResponseEntity<Booking> CreateBooking() {
        return new ResponseEntity<>( bookingService.CreateBooking(), HttpStatus.CREATED);
    }
}
