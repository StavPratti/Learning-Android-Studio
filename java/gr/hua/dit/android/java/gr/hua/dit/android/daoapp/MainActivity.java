package gr.hua.dit.android.daoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

/*Room is a new way to create a database in your android apps.
Room Persistence Library is a library that adds an abstraction layer over SQLite
which simplifies the access to the database, reduces the boilerplate
and validates the SQL queries at runtime
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactsDatabase database = Room.databaseBuilder(MainActivity.this, ContactsDatabase.class, "CONTACTS_DB").build();
        final ContactsDao contactsdao = database.ContactsDao();

        findViewById(R.id.buttonInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameET = findViewById(R.id.editTextName);
                EditText idET = findViewById(R.id.editTextID);
                EditText phoneET = findViewById(R.id.editTextPhone);

                final Contact contact = new Contact();
                contact.id = Integer.parseInt(idET.getText().toString());
                contact.name = nameET.getText().toString();
                contact.phone_number = phoneET.getText().toString();

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        contactsdao.insertContacts(contact);

                    }

                });
                t.start();
            }

        });

        findViewById(R.id.buttonSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Contact> contacts = contactsdao.getAllContacts();
                        Log.d("DA0", contacts.toString());
                    }
                });
                t.start();
            }
        });
    }
}