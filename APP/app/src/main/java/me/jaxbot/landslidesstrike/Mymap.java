package me.jaxbot.landslidesstrike;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mymap extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    Marker marker;
    EditText destination;
    Button gobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymap);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        destination = (EditText) findViewById(R.id.destination);
        gobutton = (Button) findViewById(R.id.gobutton);
        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(destination.getText());
                String dest = String.valueOf(destination.getText());
                if (dest == null) {
                    Toast.makeText(Mymap.this, "Source and Destination cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    if (destination != null)

                        fetchLocation(str);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    //private void fetchLocation(String str)throws IOException

    private void fetchLocation(String str) throws IOException {

        Geocoder gc = new Geocoder(this);
        if (gc.isPresent()) {
            ArrayList<Address> list = (ArrayList<Address>) gc.getFromLocationName(str, 1);
            if (list != null) {
                Address ad = list.get(0);
                double latitude = ad.getLatitude();
                double longitude = ad.getLongitude();
                if (marker != null)
                    marker.remove();
                LatLng fetchedlocation = new LatLng(latitude, longitude);
                marker = mMap.addMarker(new MarkerOptions()
                        .position(fetchedlocation)
                        .draggable(true)
                        .title("Origin"));
                marker.setSnippet(String.valueOf(fetchedlocation));
                CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(fetchedlocation, 5);
                mMap.animateCamera(cam);

            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        if(marker!=null)
            marker.remove();
        marker=mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker Mmarker) {
                marker=Mmarker;
                LatLng position = Mmarker.getPosition();
                double longitude = position.longitude;
                double latitude = position.latitude;
                Geocoder gc=new Geocoder(getApplicationContext());
                if(gc.isPresent())
                {
                    List<Address> fromLocation=null;
                    try {
                        fromLocation = gc.getFromLocation(latitude, longitude, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(fromLocation!=null)
                    {
                        Address ad=fromLocation.get(0);
                        String locality = ad.getLocality();
                        Mmarker.setSnippet(locality);
                    }
                }

            }
        });
    }

}

