package com.example.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "asset_office")
public class AssetOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    private Asset asset;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int count;
    private String receiptCode;
    private String status;
}