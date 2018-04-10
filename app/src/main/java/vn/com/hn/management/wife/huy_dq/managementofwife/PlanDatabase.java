package vn.com.hn.management.wife.huy_dq.managementofwife;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Plan.class}, version = 1, exportSchema = false)
public abstract class PlanDatabase extends RoomDatabase {

    public abstract PlanDao planDao();

    public static PlanDatabase db;

    public static PlanDatabase instance(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context, PlanDatabase.class, "management-of-wife").build();
        }
        return db;
    }
}
