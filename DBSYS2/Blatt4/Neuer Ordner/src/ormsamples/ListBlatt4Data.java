/**
 * Licensee: Julian Mennel(HTWG Konstanz)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListBlatt4Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Vorlesung...");
		blatt4teila.Vorlesung[] blatt4TeilAVorlesungs = blatt4teila.Vorlesung.listVorlesungByQuery(null, null);
		int length = Math.min(blatt4TeilAVorlesungs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(blatt4TeilAVorlesungs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Studiengang...");
		blatt4teila.Studiengang[] blatt4TeilAStudiengangs = blatt4teila.Studiengang.listStudiengangByQuery(null, null);
		length = Math.min(blatt4TeilAStudiengangs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(blatt4TeilAStudiengangs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListBlatt4Data listBlatt4Data = new ListBlatt4Data();
			try {
				listBlatt4Data.listTestData();
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
