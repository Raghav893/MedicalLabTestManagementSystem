package com.raghav.medicallabtestmanagementsystem.Repo;

import com.raghav.medicallabtestmanagementsystem.Entity.Booking;
import com.raghav.medicallabtestmanagementsystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPatient(Patient patient);
}
