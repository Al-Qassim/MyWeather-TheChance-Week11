package com.example.myweather.logic.Repository

import com.example.myweather.logic.entites.Location

interface LocationRepository {
    suspend fun getLocation(): Location
}