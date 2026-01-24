package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.Entity.Booking;
import com.raghav.medicallabtestmanagementsystem.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("")
    public ResponseEntity<Booking> CreateBooking() {
        return new ResponseEntity<>( bookingService.CreateBooking(), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Booking>> getBookingByPatient() {
        return new ResponseEntity<>(bookingService.GetAllBookings(),HttpStatus.OK);

    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingByPatientAndPatientId(@PathVariable Long bookingId) {

    }
}
