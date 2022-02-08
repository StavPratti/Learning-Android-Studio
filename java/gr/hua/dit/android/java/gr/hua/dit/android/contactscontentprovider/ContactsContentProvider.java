package gr.hua.dit.android.contactscontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Console;

public class ContactsContentProvider extends ContentProvider {

    //kai ayta ua mpoyne sthn DbContactContract
    private UriMatcher uriMatcher;
    private DbHelper dbHelper;
    private static String AUTHORITY = "gr.hua.dit.android.contactscontentprovider";
    public static String CONTENT_URI = "content://"+AUTHORITY;
    public static String PATH = DbHelper.TABLE_NAME;

//    static{
//        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//        uriMatcher.addURI(AUTHORITY,"contacts",1);
//        uriMatcher.addURI(AUTHORITY,"contacts/#",2);
//    }

    @Override
    public boolean onCreate() { //kalytera arxikopoiw sthn onCreate
        //dbHelper = new DbHelper(getContext());
        //return true;
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"contacts",1);
        uriMatcher.addURI(AUTHORITY,"contacts/#",2);
        DbHelper helper = new DbHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor result = null; //null an kati paei strava
        switch (uriMatcher.match(uri)){
            case 1: //select * from contacts
                result = dbHelper.selectAll();
                //cursor = database.query(ContactContract.TABLE_NAME, null,null, null, null, null, null);
                break;
            case 2: //select * from contacts where row_id = ?
                result = dbHelper.selectContactById(Integer.parseInt(uri.getLastPathSegment()));
                break;
        }
        return result;
        //return cursor;
        //STA SXOLIA O KWDIKAS POU UA EIXAME AN EIXAME FTIAKSEI DbContactContract MALLON
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Uri result = null;
        switch(uriMatcher.match(uri)){
            case 1:
                ContactContract contact = new ContactContract(values.getAsString("name"),values.getAsString("phone"));
                long id = dbHelper.insertContact(contact); //the new id
                result = Uri.parse(AUTHORITY+"/contacts/"+id);
                break;
        }
        return result;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
