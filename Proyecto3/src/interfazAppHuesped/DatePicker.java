package interfazAppHuesped;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

class DatePicker extends JSpinner {

    public DatePicker(LocalDate initialDate) {

        super(new SpinnerDateModel(java.sql.Date.valueOf(initialDate), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(this, "yyyy-MM-dd");
        this.setEditor(dateEditor);
    }

    public LocalDate getDate() {
        
        return ((java.util.Date) this.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}