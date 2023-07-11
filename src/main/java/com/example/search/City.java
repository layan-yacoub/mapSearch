package com.example.search;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cityName;

    @Column
    private int searchCount;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityName, int searchCount) {
        this.cityName = cityName;
        this.searchCount = searchCount;
    }
}
