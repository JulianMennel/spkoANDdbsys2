/**
 * Licensee: Julian Mennel(HTWG Konstanz)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateBlatt4Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = blatt4teila.Blatt4PersistentManager.instance().getSession().beginTransaction();
		try {
			blatt4teila.Vorlesung blatt4TeilAVorlesung = blatt4teila.Vorlesung.createVorlesung();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : sws, ects, _studiengang
			blatt4TeilAVorlesung.save();
			blatt4teila.Studiengang blatt4TeilAStudiengang = blatt4teila.Studiengang.createStudiengang();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _vorlesung, kuerzel
			blatt4TeilAStudiengang.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateBlatt4Data createBlatt4Data = new CreateBlatt4Data();
			try {
				createBlatt4Data.createTestData();
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
