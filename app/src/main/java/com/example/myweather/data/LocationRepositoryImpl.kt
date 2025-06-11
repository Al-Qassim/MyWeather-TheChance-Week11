package com.example.myweather.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.os.Looper
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import com.example.myweather.logic.Repository.LocationRepository
import com.example.myweather.logic.entites.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.Locale

class LocationRepositoryImpl(val context: Context) : LocationRepository {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    @Suppress("MissingPermission")
    override suspend fun getLocation(): Location {
        if (!hasLocationPermission()) {
            throw SecurityException("Location permission not granted. Please grant ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION.")
        }
        if (!isLocationServiceEnabled()) {
            throw IllegalStateException("Location services are disabled on your device. Please enable them in settings.")
        }

        return suspendCancellableCoroutine { continuation ->
            val locationRequest = LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY,
                5000L
            )
                .setMinUpdateIntervalMillis(2000L)
                .setMaxUpdates(1)
                .build()

            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    val androidLocation = locationResult.lastLocation
                    if (androidLocation != null) {
                        val geocoder = Geocoder(context, Locale.getDefault())
                        val addresses =
                            geocoder.getFromLocation(androidLocation.latitude, androidLocation.longitude, 1)

                        val government = addresses?.firstOrNull()?.adminArea ?: "Unknown State"

                        continuation.resume(
                            Location(
                                latitude = androidLocation.latitude,
                                longitude = androidLocation.longitude,
                                city = government
                            )
                        ) { cause, _, _ -> {} }

                        fusedLocationClient.removeLocationUpdates(this)
                    }
                }
            }

            continuation.invokeOnCancellation {
                fusedLocationClient.removeLocationUpdates(locationCallback)
            }

            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        }
    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isLocationServiceEnabled(): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }
}