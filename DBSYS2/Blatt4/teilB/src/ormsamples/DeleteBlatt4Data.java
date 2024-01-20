/**
 * Licensee: administrator(HTWG Konstanz)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteBlatt4Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = blatt4teila.Blatt4PersistentManager.instance().getSession().beginTransaction();
		try {
			blatt4teila.Vorlesung blatt4TeilAVorlesung = blatt4teila.Vorlesung.loadVorlesungByQuery(null, null);
			blatt4TeilAVorlesung.delete();
			blatt4teila.Studiengang blatt4TeilAStudiengang = blatt4teila.Studiengang.loadStudiengangByQuery(null, null);
			blatt4TeilAStudiengang.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteBlatt4Data deleteBlatt4Data = new DeleteBlatt4Data();
			try {
				deleteBlatt4Data.deleteTestData();
			}
			finally {
				blatt4teila.Blatt4PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
