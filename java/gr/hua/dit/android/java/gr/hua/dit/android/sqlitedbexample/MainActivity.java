package gr.hua.dit.android.sqlitedbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    DbHelper helper = new DbHelper(MainActivity.this);
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper = new DbHelper(MainActivity.this);

        findViewById(R.id.mybutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //me to getText pairnw to periexomeno twn text
                String name = ((EditText)findViewById(R.id.myedittext)).getText().toString();
                String phone = ((EditText)findViewById(R.id.myedittext2)).getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContactContract contact = new ContactContract(name,phone);
                long id = helper.insertContact(contact); //the method in DbHelper poy exei to idio orisma
                Toast.makeText(MainActivity.this, id+"", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

        findViewById(R.id.mybutton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor results = db.query("_ROWID", new String[] {DbHelper.TABLE_NAME}, DbHelper.FIELD_1, new String[] {"1234"}, DbHelper.FIELD_2+"=?",
                null,
                null,
                null);

        if(results.moveToFirst()){
            do{
                Toast.makeText(MainActivity.this,""+results.getString(0), Toast.LENGTH_SHORT).show();
            }while(results.moveToNext());

                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}
