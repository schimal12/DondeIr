package mx.itesm.edu.dondeir;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by harryHaller on 29/02/16.
 */
public class CargaPoisAsyncTask extends AsyncTask<String, Void, ArrayList<Sitio>> {

    private Context ct;
    private ProgressDialog dialogo;
    private GoogleMap googleMap;

    public CargaPoisAsyncTask(Context c, GoogleMap googleMap){
        ct = c;
        dialogo = new ProgressDialog(ct);
        this.googleMap = googleMap;
    }

    @Override
    protected ArrayList<Sitio> doInBackground(String... params) {
            // TODO Auto-generated method stub
            String archivo = params[0];
            AssetManager manager = ct.getAssets();
            BufferedReader lector = null;
            ArrayList<Sitio> resultado = new ArrayList<>();
            try{
                InputStreamReader input =  new InputStreamReader( manager.open(archivo + ".json") );

                lector = new BufferedReader(input);
                String data = "";
                while(lector.ready()){
                    data += lector.readLine();
                }
                lector.close();

                Log.i("Data", data);
                resultado = procesaJSON(data);
            }catch(Exception ex ){
                ex.printStackTrace();
            }


            return resultado;
    }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            dialogo.setTitle("Procesando...");
            dialogo.setCancelable(false);
            dialogo.show();
        }

    @Override
    protected void onPostExecute(ArrayList<Sitio> result) {
        if(result.size() > 0) {
            for (Sitio c : result) {
                if(c.getCategoria().equals("biblioteca")){
                    LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                    this.googleMap.addMarker(new MarkerOptions()
                            .position(latLng).title(c.getNombre())
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
                }else{
                    if(c.getCategoria().equals("cchina")){
                        LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                        this.googleMap.addMarker(new MarkerOptions()
                                .position(latLng).title(c.getNombre())
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                    }else{
                        if(c.getCategoria().equals("cines")){
                            LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                            this.googleMap.addMarker(new MarkerOptions()
                                    .position(latLng).title(c.getNombre())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        }else{
                            if(c.getCategoria().equals("plazas")){
                                LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                this.googleMap.addMarker(new MarkerOptions()
                                        .position(latLng).title(c.getNombre())
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                            }else{
                                if(c.getCategoria().equals("gasolinera")){
                                    LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                    this.googleMap.addMarker(new MarkerOptions()
                                            .position(latLng).title(c.getNombre())
                                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                                }else{
                                    if(c.getCategoria().equals("iglesia")){
                                        LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                        this.googleMap.addMarker(new MarkerOptions()
                                                .position(latLng).title(c.getNombre())
                                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
                                    }else{
                                        if(c.getCategoria().equals("librerias")){
                                            LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                            this.googleMap.addMarker(new MarkerOptions()
                                                    .position(latLng).title(c.getNombre())
                                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                                        }else{
                                            if(c.getCategoria().equals("mascota")){
                                                LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                                this.googleMap.addMarker(new MarkerOptions()
                                                        .position(latLng).title(c.getNombre())
                                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
                                            }else{
                                                if(c.getCategoria().equals("museo")){
                                                    LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                                    this.googleMap.addMarker(new MarkerOptions()
                                                            .position(latLng).title(c.getNombre())
                                                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                                                }else{
                                                    if(c.getCategoria().equals("teatros")){
                                                        LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                                        this.googleMap.addMarker(new MarkerOptions()
                                                                .position(latLng).title(c.getNombre())
                                                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                                                    }else{
                                                        if(c.getCategoria().equals("videojuegos")){
                                                            LatLng latLng = new LatLng(c.getLatitude(), c.getLongitude());
                                                            this.googleMap.addMarker(new MarkerOptions()
                                                                    .position(latLng).title(c.getNombre())
                                                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.googleMap.moveCamera(CameraUpdateFactory.zoomTo(8.0f));
        }
            if(dialogo != null && dialogo.isShowing()){
                dialogo.dismiss();
            }

    }


    public ArrayList<Sitio> procesaJSON(String datos){
        ArrayList<Sitio> data = new ArrayList<>();
        try{
            JSONObject object = new JSONObject(datos);
            JSONArray coleccion = object.getJSONArray("pois");
            for (int i = 0; i < coleccion.length(); i++) {
                JSONObject ob = coleccion.getJSONObject(i);
                String categoria = ob.getString("categoria");
                String titulo = ob.getString("name");
                double latitude = ob.getDouble("latitude");
                double longitude = ob.getDouble("longitude");

                Sitio sitio = new Sitio();
                sitio.setNombre(titulo);
                sitio.setLatitude(latitude);
                sitio.setLongitude(longitude);
                sitio.setCategoria(categoria);

                data.add(sitio);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return data;
    }
}


