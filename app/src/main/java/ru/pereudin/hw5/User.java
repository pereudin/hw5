package ru.pereudin.hw5;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String surname;

    public String age;

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
