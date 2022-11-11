package com.example.kapasitasruang;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView kode_ruang, kapasitas;
    private Database SQLite = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        kode_ruang = findViewById(R.id.kode_ruang);
        kapasitas = findViewById(R.id.kapasitas);

        getDatabase();
    }

    private void getDatabase() {
        try {
            SQLiteDatabase db = SQLite.getReadableDatabase();
            Cursor c = db.rawQuery("select * from ruangan", null);
            c.moveToFirst();
            kode_ruang.setText(String.valueOf(c.getString(1)));
            kapasitas.setText(String.valueOf(c.getString(2)));
            db.close();
        }catch  (Exception e){
            Log.e("Err : ",e.getMessage());
        }
    }

}