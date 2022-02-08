package gr.hua.dit.android.dbclassexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SQLiteDatabase database = new SQLiteDatabase();
        //database.execSQL();

        DbHelper helper = new DbHelper(MainActivity.this);
        SQLiteDatabase database = helper.getWritableDatabase();
        //database.execSQL(INSERT INTO etc); //BAD technique, instead use the following :
//        ContentValues values = new ContentValues();
//        values.put(DbHelper.FIELD_1, "Jack");
//        values.put(DbHelper.FIELD_2, "Smith");
//        database.insert(DbHelper.TABLE_NAME, null, values);

        ContractTest test = new ContractTest("Jack", "Smith");
        long id = helper.insertRecord(test);
        if(id <= 0){
            Toast.makeText(this, "Problem !", Toast.LENGTH_SHORT).show();
        }

        database = helper.getReadableDatabase();
        Cursor cursor = database.query(DbHelper.TABLE_NAME, new String[]{DbHelper.FIELD_1}, DbHelper.FIELD_2 + "=?", new String[]{"Doe"}, null, null, null);
        //o cursor einai deikths se grammes toy table
        if (cursor.moveToFirst()) {
            do {
                //cursor.moveToFirst();
                Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();
                //cursor.moveToNext();
            } while (cursor.moveToNext());
        }
    }
}