package com.raghav.medicallabtestmanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false,unique = true)
    private UUID BookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    private  Patient patient;

    @Enumerated(EnumType.STRING)
    private Status bookingStatus;

    @Column(nullable = false)
    private LocalDateTime BookedAt;


}
