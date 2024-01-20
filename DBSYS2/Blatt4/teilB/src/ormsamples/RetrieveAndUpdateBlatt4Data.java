/**
 * Licensee: administrator(HTWG Konstanz)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateBlatt4Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = blatt4teila.Blatt4PersistentManager.instance().getSession().beginTransaction();
		try {
			blatt4teila.Vorlesung blatt4TeilAVorlesung = blatt4teila.Vorlesung.loadVorlesungByQuery(null, null);
			// Update the properties of the persistent object
			blatt4TeilAVorlesung.save();
			blatt4teila.Studiengang blatt4TeilAStudiengang = blatt4teila.Studiengang.loadStudiengangByQuery(null, null);
			// Update the properties of the persistent object
			blatt4TeilAStudiengang.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateBlatt4Data retrieveAndUpdateBlatt4Data = new RetrieveAndUpdateBlatt4Data();
			try {
				retrieveAndUpdateBlatt4Data.retrieveAndUpdateTestData();
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
