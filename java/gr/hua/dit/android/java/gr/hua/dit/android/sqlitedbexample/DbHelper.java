package gr.hua.dit.android.sqlitedbexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//ypoxrewtika o DbHelper prepei na ylopoiei thn onCreate, thn onUpgrade kai ton constructor,
//o opoios exei ws orismata to onoma toy pinaka, ton cursor factory (=null) kai thn version (=1), ta grafw egw me to xeri
//orizw tis metavlhtes ws public static gia na mporei na tis xrhsimopoihsei h MainActivity

public class DbHelper extends SQLiteOpenHelper { //klhronomei kai prepei na ylopoihsei kapoies meuodous

    public static String DB_NAME = "ContactsDB";
    public static String TABLE_NAME = "Contacts";
    public static String FIELD_1 = "name";
    public static String FIELD_2 = "phone_number";
    private String SQL_QUERY = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_1+" TEXT, "+FIELD_2+" TEXT)"; //TEXT instead of VARCHAR
    //to pairnw aytoysio gia na to grafw gia insert px

    //svhnw ta tria teleytaia orismata gt ta egrapsa mesa me to xeri
    public DbHelper(@Nullable Context context) { //o prwtos kai pio aplos constructor prepei na ylopoiuhuei
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_QUERY); //db einai ena object sta orismata ths meuodoy
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //ylopoihsh meuodoy gia insert opoy mesa ftiaxnw ta content values poy ua xreiastei ws orisma sth MainActivity otan kanw insert
    public long insertContact(ContactContract contact){
        ContentValues values = new ContentValues();
        values.put(FIELD_1,contact.getName());
        values.put(FIELD_2,contact.getPhone_number());
        long id = this.getWritableDatabase().insert(TABLE_NAME,null,values); //null and values are standard
        return id; //for check, the id increament, each eggrafh +1
    }
}
