package gr.hua.dit.android.daoapp;

//domh antistoixh me toy table
//ta 3 pedia toy table
//annotation:

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CONTACTS")

public class Contact {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "NAME")
    public String name;

    @ColumnInfo(name = "PHONE_NUMBER")
    public String phone_number;

}
