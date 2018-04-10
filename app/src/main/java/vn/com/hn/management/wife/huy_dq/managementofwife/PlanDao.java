package vn.com.hn.management.wife.huy_dq.managementofwife;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PlanDao {

    @Query("SELECT * FROM `plan`")
    List<Plan> getAll();

    @Query("SELECT * FROM `plan` WHERE id IN (:plansId)")
    List<Plan> loadAllByIds(int[] plansId);

    @Query("SELECT * FROM `plan` WHERE type LIKE :type")
    Plan findByType(String type);

    @Query("SELECT * FROM `plan` WHERE type LIKE :objective")
    Plan findByObjective(String objective);

    @Insert
    void insertAll(Plan... plans);

    @Delete
    void delete(Plan plan);
}
