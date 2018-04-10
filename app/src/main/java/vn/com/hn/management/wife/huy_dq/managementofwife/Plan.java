package vn.com.hn.management.wife.huy_dq.managementofwife;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity
public class Plan {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "type")
    private boolean type;

    @ColumnInfo(name = "objective")
    private boolean objective;

    @ColumnInfo(name = "details_note")
    private String detailsNote;

    @ColumnInfo(name = "paying_date")
    @TypeConverters({TimeStampConverter.class})
    private Date payingDate;

    @ColumnInfo(name = "paying_method")
    private String payingMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isObjective() {
        return objective;
    }

    public void setObjective(boolean objective) {
        this.objective = objective;
    }

    public String getDetailsNote() {
        return detailsNote;
    }

    public void setDetailsNote(String detailsNote) {
        this.detailsNote = detailsNote;
    }

    public Date getPayingDate() {
        return payingDate;
    }

    public void setPayingDate(Date payingDate) {
        this.payingDate = payingDate;
    }

    public String getPayingMethod() {
        return payingMethod;
    }

    public void setPayingMethod(String payingMethod) {
        this.payingMethod = payingMethod;
    }
}
