package mx.itesm.edu.dondeir;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by harryHaller on 29/02/16.
 */
public class CargaMenuAsyncTask extends AsyncTask<String, Void, ArrayList<Item>> {

    private Context ct;
    private ProgressDialog dialogo;
    private ArrayAdapter<Item> adaptador;

    public CargaMenuAsyncTask( Context c, ArrayAdapter<Item> ad){
            ct = c;
            dialogo = new ProgressDialog(ct);
            adaptador = ad;
    }

    @Override
    protected ArrayList<Item> doInBackground(String... params) {
            // TODO Auto-generated method stub
            String archivo = params[0];
            AssetManager manager = ct.getAssets();
            BufferedReader lector = null;
            ArrayList<Item> resultado = new ArrayList<Item>();
            try{
            InputStreamReader input =  new InputStreamReader( manager.open(params[0] + ".json") );

            lector = new BufferedReader(input);
            String data = "";
            while(lector.ready()){
                data += lector.readLine();
            }
            lector.close();
            //Toast.makeText(ct, data, Toast.LENGTH_LONG).show();
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
    protected void onPostExecute(ArrayList<Item> result) {
            adaptador.clear();

            for(Item c :result ){
                 adaptador.add(c);
            }
            adaptador.notifyDataSetChanged();
            if(dialogo != null && dialogo.isShowing()){
                dialogo.dismiss();
            }

    }


    public ArrayList<Item> procesaJSON(String datos){
            ArrayList<Item> data = new ArrayList<Item>();
            try{
                JSONObject object = new JSONObject(datos);
                JSONArray coleccion = object.getJSONArray("menu");
                for (int i = 0; i < coleccion.length(); i++) {
                    JSONObject ob = coleccion.getJSONObject(i);
                    String titulo = ob.getString("nombre");
                    String archivo = ob.getString("archivo");

                    Item c = new Item();
                    c.setTitulo(titulo);
                    c.setArchivo(archivo);

                    data.add(c);


                }
            }catch(Exception ex){
            ex.printStackTrace();
            }

            return data;

            }
}


