package gr.hua.dit.android.sqlitedbexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ContactContract {

    //periexei th domh ths vashs (gia na kalw setters, getters)
    private String name;
    private String phone_number;
    DbHelper helper;

    public ContactContract(String name, String phone_number, Context context) {
        this.name = name;
        this.phone_number = phone_number;
        helper = new DbHelper(context);
    }

    public ContactContract(Context context){
        helper = new DbHelper(context);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

//    public long insert(){
//        ContentValues values = new ContentValues();
//        values.put(DbContactContract.FIELD_1, this.user);
//        values.put(DbContactContract.FIELD_2, this.user);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        long id = db.insert(DbContactContract.TABLE_NAME,null,values);
//        db.close();
//          if(result == -1){
//                throw new Exception("Insert failed!");
//          }
//        return id;
//    }
  }

