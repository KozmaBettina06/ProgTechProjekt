import org.junit.Test;
import szallasok.SzallasokService;
import szallasok.SzamolasService;

import java.time.LocalDate;


/**
 * Created by Stefyy on 2017.05.30..
 */
public class Teszt {

    @Test
    public void eltoltottNapokSzamaTeszt()
    {
        org.junit.Assert.assertEquals(2, SzamolasService.eltoltottNapokSzama(LocalDate.of(2017,6,10),LocalDate.of(2017,6,12)));
    }
    @Test
    public void osszesAdoTeszt()
    {
        org.junit.Assert.assertEquals(600,SzamolasService.osszesAdo(2, 150, LocalDate.of(2017, 6, 10), LocalDate.of(2017, 6, 12)));
    }
    @Test
    public void osszesSzobaarTeszt()
    {
        org.junit.Assert.assertEquals(18000,SzamolasService.osszesSzobaar(2, 9000, LocalDate.of(2017, 6, 10), LocalDate.of(2017, 6, 11)));
    }
    @Test
    public void fizetendoTeszt()
    {
        org.junit.Assert.assertEquals(18300,SzamolasService.fizetendo(2,150,2,9000,LocalDate.of(2017, 6, 10), LocalDate.of(2017, 6, 11)));
    }
}
