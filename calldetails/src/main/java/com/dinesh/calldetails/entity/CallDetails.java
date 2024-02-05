package com.dinesh.calldetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "calldetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallDetails {
    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    long calledBy;
    @Column(nullable = false)
    long calledTo;
    @Column(nullable = false)
    Date calledOn;
    @Column(nullable = false)
    int duration;
}
