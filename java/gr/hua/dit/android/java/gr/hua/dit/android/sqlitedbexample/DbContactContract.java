package gr.hua.dit.android.sqlitedbexample;

public class DbContactContract {

    //ta pedia poy yparxoyn sthn DbHelper
    public static String DB_NAME = "ContactsDB";
    public static String TABLE_NAME = "Contacts";
    public static String FIELD_1 = "name";
    public static String FIELD_2 = "phone_number";
    private String SQL_QUERY = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_1+" TEXT, "+FIELD_2+" TEXT)";

}

//kalo einai na yparxei mia sthlh _rowid
//KEY_NAME
//KEY_PHONE