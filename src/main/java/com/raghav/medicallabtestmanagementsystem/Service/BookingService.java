package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.Entity.Booking;
import com.raghav.medicallabtestmanagementsystem.Entity.Patient;
import com.raghav.medicallabtestmanagementsystem.Entity.Status;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import com.raghav.medicallabtestmanagementsystem.Repo.BookingRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.PatientRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final PatientRepository patientRepository ;
    private final UserRepo userRepo;
    private final BookingRepository bookingRepository;
    public Booking CreateBooking(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users users = userRepo.findByUsername(username);
        if (users == null) {
            throw new RuntimeException("User Not Found");
        }

        Patient patient =patientRepository.findByUser(users);
        if (patient == null) {

            throw new RuntimeException("Patient Not Found");
        }
        Booking booking = new Booking();
        booking.setPatient(patient);
        booking.setBookingId(UUID.randomUUID());
        booking.setBookedAt(LocalDateTime.now());
        booking.setBookingStatus(Status.BOOKED);
        return bookingRepository.save(booking);

    }

}
