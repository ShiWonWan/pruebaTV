package com.example.pruebatv;

import android.os.Bundle;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FragmentPrincipal extends BrowseSupportFragment {
    private List<Movie> mMovies = new ArrayList<Movie>();
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        leerDatos();
        iniciarInterfazUsuario();
        cargarListas();
    }
    private void iniciarInterfazUsuario(){
        setTitle("Videoteca2");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
    }
    private void leerDatos(){
        //MovieList.list = new ArrayList<Movie>();
        String json = Utils.loadJSONFromResource(getActivity(), R.raw.movies);
        Gson gson = new Gson();
        Type collection = new TypeToken<ArrayList<Movie>>(){}.getType();
        //MovieList.list = gson.fromJson(json, collection)
        mMovies= gson.fromJson(json, collection);
    }

    private void cargarListas() {
        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        CardPresenter presenter = new CardPresenter();
        List<String> categories = getCategorias();
        if(categories == null || categories.isEmpty())
            return;
        for(String categoria: categories){
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(presenter);
            for (Movie movie : mMovies){
                if (categoria.equalsIgnoreCase(movie.getCategoria()))
                    listRowAdapter.add(movie);
            }
            if (listRowAdapter.size() > 0 ){
                HeaderItem header = new HeaderItem(rowsAdapter.size()-1, categoria);
                rowsAdapter.add(new ListRow(header, listRowAdapter));
            }
        }
        setAdapter(rowsAdapter);

    }
        private List<String> getCategorias(){
            if(mMovies == null)
                return null;
            List<String> categories = new ArrayList<String>();
            for(Movie movie : mMovies){
                if (!categories.contains(movie.getCategoria())){
                    categories.add(movie.getCategoria());
                }
            }
            return categories;
        }
}

