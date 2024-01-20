/**
 * Licensee: administrator(HTWG Konstanz)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateBlatt4DatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(blatt4teila.Blatt4PersistentManager.instance());
			blatt4teila.Blatt4PersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
