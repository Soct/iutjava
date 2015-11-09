
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutilsJDBC {
	public static Connection openConnection(final String url) {
		Connection co = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("il manque le driver oracle");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("impossible de se connecter � l'url : " + url);
			System.exit(1);
		}
		return co;
	}

	public static ResultSet exec1Requete(final String requete, final Connection co, final int type) {
		ResultSet res = null;
		try {
			Statement st;
			if (type == 0) {
				st = co.createStatement();
			} else {
				st = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
			;
			res = st.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Probl�me lors de l'ex�cution de la requete : " + requete);
		}
		;
		return res;
	}

	public static void closeConnection(final Connection co) {
		try {
			co.close();
			System.out.println("Connexion ferm�e!");
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la connexion");
		}
	}

	public static void afficher(final ResultSet resul) {
		try {
			int cpt = 1;
			while (resul.next() && cpt <11) {
				System.out.print(cpt + " : ");
				for (int i = 3; i >= 2; i--) {

					System.out.print(resul.getString(i) + "\t");

				}
				System.out.print("\n");
				cpt++;
			}
		} catch (SQLException e) {

		}
		
	}

	public static void afficher2(final ResultSet resul) {
		try {
			while (resul.next()) {
				for (int i = 3; i >= 2; i--) {

					System.out.print(resul.getString(i) + "\t");

				}
				System.out.print("\n");
			}
		} catch (SQLException e) {

		}
	}

	public static void afficher3(final ResultSet resul) {
		try {
			int cpt = 1;
			while (resul.next()) {
				System.out.print(cpt + " : ");
				for (int i = 2; i >= 2; i--) {

					System.out.print(resul.getString(i) + "\t");

				}
				System.out.print("\n");
				cpt++;
			}
		} catch (SQLException e) {

		}
	}

	public static void afficherNomFilm(final ResultSet resul) {
		try {
			while (resul.next()) {
				for (int i = 2; i >= 2; i--) {
					System.out.print(resul.getString(i) + "\t");
				}
				System.out.print("\n");
			}
		} catch (SQLException e) {

		}
	}

	public static void afficher4(final ResultSet resul) {
		int cpt = 1;
		try {
			while (resul.next()) {
				for (int i = 1; i >= 1; i--) {
					System.out.print(cpt + " : " + resul.getString(i) + "\t");
				}
				System.out.print("\n");
				cpt++;
			}
		} catch (SQLException e) {

		}
	}
	public static int acteur(int j, final ResultSet resul){
		try {
			int cpt = 1;
			int i = 1;
			while (resul.next()) {
					if (cpt == j){
						return resul.getInt(i);
					}	
				cpt++;
			}
		} catch (SQLException e) {

		}
		return 0;
	}
	
	public static int film(int j, final ResultSet resul){
		try {
			int cpt = 1;
			int i = 1;
			while (resul.next()) {
					if (cpt == j){
						return resul.getInt(i);
					}	
				cpt++;
			}
		} catch (SQLException e) {

		}
		return 0;
	}

	public static void main(final String[] args) {
		String url = "jdbc:oracle:thin:mpheulp/plopplop@oracle.iut-orsay.fr:1521:etudom";
		Connection co = OutilsJDBC.openConnection(url);
		System.out.println("connexion ouverte");
			//EXO 2
		//String requete = "SELECT * FROM ens2004.FILM";
			//EXO 3
		//String requete = "SELECT * FROM ens2004.INDIVIDU WHERE NOMINDIVIDU = 'FONDA'";
			//EXO 4
		//String requete = "SELECT Titre FROM ens2004.FILM fi, ens2004.INDIVIDU iv WHERE fi.REALISATEUR = iv.NUMINDIVIDU AND iv.NOMINDIVIDU = 'ROBERTS' AND iv.PRENOMINDIVIDU = 'STEPHEN'";
			//EXO 5
		System.out.println("Entrez votre nom d'acteur");
		String acteur = Saisie.chaine();
		acteur = acteur.toUpperCase();
		int choix;
		String requete = "SELECT * FROM ens2004.INDIVIDU WHERE NOMINDIVIDU = '" + acteur + "'";
		
		ResultSet resultat = OutilsJDBC.exec1Requete(requete, co, 0);
		System.out.println("Voici les diff�rent acteur(s) :");
		afficher(resultat);
		
		System.out.println("Choisissez un acteur : ");
		choix = Saisie.entier();
		resultat = OutilsJDBC.exec1Requete(requete, co, 0);
		choix = acteur(choix, resultat);
		requete = "SELECT Titre FROM ens2004.FILM fi, ens2004.ACTEUR ac WHERE fi.NUMFILM = ac.NUMFILM AND NUMINDIVIDU = '" + choix + "' ORDER BY Titre ";
		resultat = OutilsJDBC.exec1Requete(requete, co, 0);
		
		System.out.println("Voici la liste des films : ");
		afficher4(resultat);
		
		System.out.println("Choisissez un film : ");
		int choix2;
		choix2 = Saisie.entier();
		requete = "SELECT fi.NUMFILM FROM ens2004.FILM fi, ens2004.ACTEUR ac WHERE fi.NUMFILM = ac.NUMFILM AND NUMINDIVIDU = '" + choix + "' ORDER BY Titre ";
		resultat = OutilsJDBC.exec1Requete(requete, co, 0);
		choix2 = film(choix2, resultat);
		System.out.println(choix2);


		System.out.println("Voici les num�ro des exemplaire(s) disponible(s) :");
		requete = "SELECT NUMEXEMPLAIRE FROM ens2004.EXEMPLAIRE WHERE NUMFILM = '" + choix2 + "'";
		resultat = OutilsJDBC.exec1Requete(requete, co, 0);
		afficher4(resultat);
			//EXO 2
		//afficher(resultat);
			//EXO 3
		//afficher(resultat);
			//EXO 4
		//afficher4(resultat);
			//EXO 5
		
		// On ferme la connection
		OutilsJDBC.closeConnection(co);

	};
}
