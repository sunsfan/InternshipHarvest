package DBUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sunsfan_storm.dao.Word;

public class DBUtil {
	public static void saveWord(String word) {
		Word w = new Word();
		w.setWord(word);
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(w);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
