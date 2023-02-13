package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface IMethodTest {

    default String getFechaHoy() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

}