package szallasok;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Stefyy on 2017.05.30..
 */
public class SzamolasService {
    public static long eltoltottNapokSzama(LocalDate date1, LocalDate date2){
        LocalDate erkezesNapja= date1;
        LocalDate tavozasNapja= date2;
        long napok=erkezesNapja.until(tavozasNapja, ChronoUnit.DAYS);
        return napok;
    }

    public static long osszesAdo(int fo1, int ado1, LocalDate date1,LocalDate date2){

        int fo = fo1;
        int ado= ado1;
        return (fo*ado)*eltoltottNapokSzama(date1,date2);
    }
    public static long osszesSzobaar(int fo2, int ar1, LocalDate date1,LocalDate date2){

        int fo = fo2;
        int ar = ar1;
        return (fo*ar)*eltoltottNapokSzama(date1,date2);
    }
    public static long fizetendo(int fo1, int ado1, int fo2, int ar1, LocalDate date1, LocalDate date2){
        return osszesAdo( fo1,  ado1, date1,date2)+osszesSzobaar(fo2, ar1,date1,date2);
    }
}
