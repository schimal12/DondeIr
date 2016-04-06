package mx.itesm.edu.dondeir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback{

    private TextView textView;
    private Item item;
    private GoogleMap googleMap;
    private Button hybrid;
    private Button satellite;
    private Button terrain;
    private Button normal;
    private Button none;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item = (Item)getIntent().getSerializableExtra("item");
        textView = (TextView)findViewById(R.id.textView);

        textView.setText(item.getTitulo());
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LatLng latLng = new LatLng(19.2835851, -99.1375987);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        this.googleMap.addMarker(new MarkerOptions().position(latLng).title("Le Tec").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));

        CargaPoisAsyncTask cargaPoisAsyncTask = new CargaPoisAsyncTask(this, this.googleMap);
        cargaPoisAsyncTask.execute(item.getArchivo());
    }

    public void cambiarHybrid(View v){
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    public void cambiarSatellite(View v){
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
    public void cambiarNormal(View v){
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    public void cambiarTerrain(View v){
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
    public void cambiarNone(View v){
        googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
    }
}
