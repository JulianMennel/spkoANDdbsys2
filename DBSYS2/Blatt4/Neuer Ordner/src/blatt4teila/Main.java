package blatt4teila;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import java.util.List;
import java.util.ListIterator;

public class Main {
    private static final int ROW_COUNT = 100;
    public static void main(String[] args) {
        try {
            PersistentSession session = Blatt4PersistentManager.instance().getSession();
            PersistentTransaction t = session.beginTransaction();

            //addData(session, t);
            //teilD(session, t);
            //teilE(session, t);
            teilF(session, t);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void addData(PersistentSession session, PersistentTransaction t) throws PersistentException {
            try {
                Studiengang ain = new Studiengang();
                Studiengang win = new Studiengang();

                ain.setAbschluss("Bachelor of Science");
                win.setAbschluss("Bachelor of Science");
                ain.setKuerzel("AIN");
                win.setKuerzel("WIN");
                ain.setName("Angewandte Informatik");
                win.setName("Wirtschafts Informatik");

                ain.save();
                win.save();

                Vorlesung prog1 = new Vorlesung();
                Vorlesung prog2 = new Vorlesung();
                Vorlesung dbsys1 = new Vorlesung();
                Vorlesung dbsys2 = new Vorlesung();
                Vorlesung mathe = new Vorlesung();

                Vorlesung thinf = new Vorlesung();
                Vorlesung statistik = new Vorlesung();
                Vorlesung proma = new Vorlesung();

                prog1.setName("Programmiertechnik 1");
                prog1.setEcts(6);
                prog1.setSws(2324);
                prog1.set_studiengang(win);

                prog2.setName("Programmiertechnik 2");
                prog2.setEcts(6);
                prog2.setSws(2324);
                prog2.set_studiengang(ain);

                dbsys1.setName("Datenbanksysteme 1");
                dbsys1.setEcts(6);
                dbsys1.setSws(2324);
                dbsys1.set_studiengang(ain);

                dbsys2.setName("Datenbanksysteme 2");
                dbsys2.setEcts(6);
                dbsys2.setSws(2324);
                dbsys2.set_studiengang(ain);

                mathe.setName("Mathematik");
                mathe.setEcts(6);
                mathe.setSws(2324);
                mathe.set_studiengang(win);

                thinf.setName("Theoretische Informatik");
                thinf.setEcts(6);
                thinf.setSws(2324);
                thinf.set_studiengang(win);

                statistik.setName("Statistik");
                statistik.setEcts(6);
                statistik.setSws(2324);
                statistik.set_studiengang(win);

                proma.setName("Projektmanagament");
                proma.setEcts(6);
                proma.setSws(2324);
                proma.set_studiengang(win);

                Vorlesung mathe12 = new Vorlesung();
                mathe12.setName("Mathematik");
                mathe12.setEcts(6);
                mathe12.setSws(2324);
                mathe12.set_studiengang(ain);

                Vorlesung prog12 = new Vorlesung();
                prog12.setName("Programmiertechnik 1");
                prog12.setEcts(6);
                prog12.setSws(2324);
                prog12.set_studiengang(ain);

                proma.save();
                statistik.save();
                thinf.save();
                mathe.save();
                dbsys2.save();
                dbsys1.save();
                prog2.save();
                prog1.save();
                prog12.save();
                mathe12.save();

                t.commit();
            }
            catch (PersistentException e) {
                t.rollback();
                e.printStackTrace();
            }
            finally {
                Blatt4PersistentManager.instance().disposePersistentManager();
            }
    }

    public static void teilD(PersistentSession session, PersistentTransaction t) throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery(null, null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println("Name: "+vorlesungs[i].getName() + ", ECTS: " + vorlesungs[i].getEcts() + ", Studiengang:" + vorlesungs[i].get_studiengang());
        }
    }

    public static void teilE(PersistentSession session, PersistentTransaction t) throws PersistentException {
        Studiengang[] studiengangs = Studiengang.listStudiengangByQuery(null, null);
        int length = Math.min(studiengangs.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            int sum = getECTSSum(studiengangs[i].getKuerzel());
            System.out.println("Name: "+studiengangs[i].getName() + ", Summe: " + sum);
        }
    }

    public static int getECTSSum(String Studiengang) throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery("StudiengangKuerzel = \'" + Studiengang + "\'", null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        int ectssum = 0;
        for (int i = 0; i < length; i++) {
            ectssum += vorlesungs[i].getEcts();
        }
        return ectssum;
    }

    public static void teilF(PersistentSession session, PersistentTransaction t) throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery("StudiengangKuerzel = \'AIN\'", null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        printSameStudiengang(vorlesungs);
    }

    public static void printSameStudiengang(Vorlesung[] VorlesungsListe) throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery("StudiengangKuerzel = \'WIN\'", null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            for (var vorlesung : VorlesungsListe) {
                if (vorlesung.getName().equals(vorlesungs[i].getName())) {
                    System.out.println(vorlesung.getName());
                }
            }
        }
    }
}
