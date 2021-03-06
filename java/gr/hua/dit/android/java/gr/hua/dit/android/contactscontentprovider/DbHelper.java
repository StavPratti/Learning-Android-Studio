package gr.hua.dit.android.contactscontentprovider;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//san th prohgoymenh vash
public class DbHelper extends SQLiteOpenHelper {
    public static String DB_NAME = "ContactsDB";
    public static String TABLE_NAME = "Contacts";
    public static String FIELD_1 = "name";
    public static String FIELD_2 = "phone_number";
    private String SQL_QUERY = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_1+" TEXT, "+FIELD_2+" TEXT)";
    //to row id to vazei apo monh ths h SQLite

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertContact(ContactContract contact){
        ContentValues values = new ContentValues();
        values.put(FIELD_1,contact.getName());
        values.put(FIELD_2,contact.getPhone_number());
        long id = this.getWritableDatabase().insert(TABLE_NAME,null,values);
        return id; //TO KAINOURGIO ID POU DHMIOURGHUHKE ME TO NEO INSERT
    }

    public Cursor selectAll(){ //epistrefei ola ta contents
        return this.getReadableDatabase().query(TABLE_NAME,null,null,null,null,null,null);
    }

    public Cursor selectContactById(long id){
        return this.getReadableDatabase().query(TABLE_NAME,null,"rowid=?",new String[]{id+""},null,null,null);
    }
}
