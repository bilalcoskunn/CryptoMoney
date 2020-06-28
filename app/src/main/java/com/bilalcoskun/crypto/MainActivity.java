package com.bilalcoskun.crypto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView btcText,ethText,xrpText,bchText,usdtText,bsvText,ltcText,eosText,bnbText,htText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcText = findViewById(R.id.btcText);
        ethText=findViewById(R.id.ethText);
        xrpText=findViewById(R.id.xrpText);
        usdtText=findViewById(R.id.bchText);
        bchText=findViewById(R.id.usdtText);
        bsvText=findViewById(R.id.bsvText);
        ltcText=findViewById(R.id.ltcText);
        eosText=findViewById(R.id.eosText);
        bnbText=findViewById(R.id.bnbText);
        htText=findViewById(R.id.htText);

        DownloadData downloadData = new DownloadData();
        try {
            String url = "https://api.coinranking.com/v1/public/coins";
            downloadData.execute(url);
        }catch (Exception e){

        }


    }

    private class DownloadData extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {

            String result="";
            URL url;
            HttpURLConnection httpURLConnection;

            try{
                url = new URL(strings[0]);
                httpURLConnection =(HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                while (data>0){
                    char character = (char) data;
                    result+=character;

                    data = inputStreamReader.read();

                }

                return result;
            }catch (Exception e){
                return null;
            }



        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //System.out.println("Alınan data:"+s);
/*
            try {
                JSONObject jsonObject = new JSONObject(s);

                String data =jsonObject.getString("data");

                JSONObject jsonObjectForCoins =new JSONObject(data);
                String coins = jsonObjectForCoins.getString("coins");


                JSONObject jsonObject1=new JSONObject(coins);
                String price=jsonObject1.getString("price");

                JSONObject bitcoin = new JSONObject(name);
                String btc = bitcoin.getString("bitcoin");

                btcText.setText("Bitcoin "+priceBitcoin);


            }catch (Exception e){

            }

*/

        }

    }

}
