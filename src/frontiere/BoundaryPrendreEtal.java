package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désolé " + nomVendeur +
					" mais il faut être un habitant de notre village pour commencer ici\r\n");
		}else {
			System.out.println("Bonjour " + nomVendeur +
					" je vais regarder si je peux vous trouver une étal\r\n");
			if(!(controlPrendreEtal.resteEtals())) {
				System.out.println("Désolée " + nomVendeur +
						" je n'ai plus d'étal qui ne soit pas déjà occupé\r\n");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous !\r");
		System.out.println("Il me faudrait quelques renseignements \r");
		System.out.println("Quel produit souhaitez-vous vendre ?\r");
		String produit = scan.next();
		System.out.println("Combien souhaitez-vous en vendre ?\r");
		int nbProduit = scan.nextInt();
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal+1);
		}
	}
}
