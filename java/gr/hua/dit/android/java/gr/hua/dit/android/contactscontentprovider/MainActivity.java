package gr.hua.dit.android.contactscontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    public DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ContentResolver resolver = this.getContentResolver();

        findViewById(R.id.insertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
                String phone = ((EditText)findViewById(R.id.editTextTextPhoneNumber)).getText().toString();
                ContentValues values = new ContentValues();
                values.put("name",name);
                values.put("phone",phone);
                Uri result = resolver.insert(Uri.parse(ContactsContentProvider.CONTENT_URI+"/contacts"),values);
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //different botton
        findViewById(R.id.cpbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Cursor cursor = resolver.query(Uri.parse(ContactsContentProvider.CONTENT_URI+"/contacts"),null,null,null,null);
                if (cursor.moveToFirst()){
                    do{
                        Toast.makeText(MainActivity.this, cursor.getString(1), Toast.LENGTH_SHORT).show();
                    }while (cursor.moveToNext());
                }
            }
        });
    }
}