package com.google.firebase.codelab.friendlychat;

import java.io.IOException;
import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Igor on 09/07/2017.
 */

class FetchData extends AsyncTask<Void, Void, Void> {
    private String url = "http://www.ufpi.br/edital-praec";
    private String ultimo_edital = "";

    @Override
    protected Void doInBackground(Void... params) {
        try{
            Document doc = Jsoup.connect(url).get();

            Elements links = doc.select("p > a");

            System.out.println("O mais novo edital é: " + links.get(0).text());
            ultimo_edital = links.get(0).attr("href");
            System.out.println("Link: " + ultimo_edital);

        }
        catch(IOException e){
            System.out.println("Erro " + e.toString());
            e.printStackTrace();
        }
        return null;
    }

    public String getUltimo_edital(){
        return this.ultimo_edital;
    }

    public void setUltimo_edital(String u){
        this.ultimo_edital = u;
    }

    public String getUrl(String u){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}
