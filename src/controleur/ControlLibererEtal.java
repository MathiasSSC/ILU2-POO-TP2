package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		return (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null);
	}
	
	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesVentes = new String [5];
		if(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) == null) {
			donneesVentes[0] = "true";
		} else {
			donneesVentes[0] = "false";
		}
		donneesVentes[1] = nomVendeur;
		donneesVentes[2] = produit;
		donneesVentes[3] = quantiteVendu;
		donneesVentes[4] = quantiteAVendre;
		
		String[] donneesEtal = null;
		return donneesEtal;
	}

}
