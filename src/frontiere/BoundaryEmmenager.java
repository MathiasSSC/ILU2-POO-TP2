package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder questionForce = new StringBuilder();
					questionForce.append("Bienvenue villageois " + nomVisiteur + "\nQuel est votre force ?");
					int force = Clavier.entrerEntier(questionForce.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {

		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Bienvenue Druide " + nomVisiteur + "\nQuel est votre force ?");
		int forceDruide = Clavier.entrerEntier(questionForce.toString());
		int effetPotionMax = 0; 
		int effetPotionMin = 0; 
		
		do {
			StringBuilder questionEffPotionMin = new StringBuilder();
			questionEffPotionMin.append("Quelle est la force de la potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(questionEffPotionMin.toString());
			
			StringBuilder questionEffPotionMax = new StringBuilder();
			questionEffPotionMax.append("Quelle est la force de la potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(questionEffPotionMax.toString());
			
			if(effetPotionMax < effetPotionMin) {
				System.out
				.println("Attention Druide, vous vous êtes  trompé entre le minimum et le maximum");
			}else{
				controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
			}
			
		}while(effetPotionMax < effetPotionMin);
	}
}
