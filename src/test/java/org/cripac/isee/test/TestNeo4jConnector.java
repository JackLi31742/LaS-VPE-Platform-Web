package org.cripac.isee.test;

import org.cripac.isee.dao.Neo4jConnector;
import org.cripac.isee.entity.Attributes;
import org.cripac.isee.entity.Link;

public class TestNeo4jConnector {

	public static void main(String[] args) {

		// For testing time consumption.
		long t1;
		long t2;
		long t;

		// Creating connector.
		t1 = System.nanoTime();
		Neo4jConnector dbConnector = new Neo4jConnector();
		t2 = System.nanoTime();
		System.out.printf("Time consumption of creating Neo4jConnector: %.3f ms\n", (t2 - t1) / 1000000.);

		// Creating nodes.
		t = System.nanoTime();
		for (int i = 1; i <= 1000; ++i) {
			String id = "" + i;
			String path = "/path/to/" + i;

			Attributes attr = getPlainAttr((float) i);

			// Attributes attr = new Attributes(); attr.genderMale = i;
			// attr.genderFemale = i; attr.genderOther = i;

			dbConnector.setTrackSavingPath(id, path);
			dbConnector.setPedestrianAttributes(id, attr);

			if (i % 50 == 0) {
				System.out.printf("Time consumption of creating a node (averaged over 50 times): %.3f ms\n",
						(System.nanoTime() - t) / 50. / 1000000.);
				t = System.nanoTime();
			}
		}

		// Creating relationships.
		t = System.nanoTime();
		for (int i = 1; i <= 975; ++i) {
			String id1 = "" + i;

			for (int j = 1; j <= 5; ++j) {
				String id2 = "" + (int) (i + j);
				dbConnector.setPedestrianSimilarity(id1, id2, (float) i);
			}

			if (i % 50 == 0) {
				System.out.printf("Time consumption of creating 5 relationships (averaged over 50 times): %.3f ms\n",
						(System.nanoTime() - t) / 50. / 1000000.);
				t = System.nanoTime();
			}
		}

		try {
			System.out.printf("Now sleeping for %d seconds\n", 20);
			Thread.sleep(1000 * 20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting paths.
		t = System.nanoTime();
		for (int i = 599; i <= 608; ++i) {
			String id = "" + i;
			String path = dbConnector.getTrackletSavingDir(id);
			System.out.println(id + ".path: " + path);
		}
		System.out.printf("Time consumption of getting a path (averaged over 10 times): %.3f ms\n",
				(System.nanoTime() - t) / 10. / 1000000.);

		// Getting attributes.
		t = System.nanoTime();
		for (int i = 699; i <= 708; ++i) {
			String id = "" + i;
			Attributes obtained_attr = dbConnector.getPedestrianAttributes(id);
			System.out.println(String.format("%1$s.genderMale: %2$f, %1$s.genderFemale: %3$f, %1$s.genderOther: %4$f",
					id, obtained_attr.genderMale, obtained_attr.genderFemale, obtained_attr.genderOther));
		}
		System.out.printf("Time consumption of getting attributes of a person (averaged over 10 times): %.3f ms\n",
				(System.nanoTime() - t) / 10. / 1000000.);

		// Getting links.
		t = 0;
		for (int i = 399; i <= 403; ++i) {
			String id = "" + i;
			t1 = System.nanoTime();
			Link[] links = dbConnector.getLinkedPedestrians(id);
			t += System.nanoTime() - t1;
			printLink(links);
		}
		System.out.printf("Time consumption of getting links for one node (averaged over 5 times): %.3f ms\n",
				t / 5. / 1000000.);

	}

	// Return an attr whose fields are set to a number.
	public static Attributes getPlainAttr(float i) {
		Attributes attr = new Attributes();
		attr.genderMale = i;
		attr.genderFemale = i;
		attr.genderOther = i;
		attr.ageSixteen = i;
		attr.ageThirty = i;
		attr.ageFortyFive = i;
		attr.ageSixty = i;
		attr.ageOlderSixty = i;
		attr.weightVeryFat = i;
		attr.weightLittleFat = i;
		attr.weightNormal = i;
		attr.weightLittleThin = i;
		attr.weightVeryThin = i;
		attr.roleClient = i;
		attr.roleUniform = i;
		attr.hairStyleNull = i;
		attr.hairStyleLong = i;
		attr.headShoulderBlackHair = i;
		attr.headShouldWithHat = i;
		attr.headShouldGlasses = i;
		attr.headShouldSunglasses = i;
		attr.headShouldScarf = i;
		attr.headShouldMask = i;
		attr.upperShirt = i;
		attr.upperSweater = i;
		attr.upperVest = i;
		attr.upperTshirt = i;
		attr.upperCotton = i;
		attr.upperJacket = i;
		attr.upperSuit = i;
		attr.upperHoodie = i;
		attr.upperCotta = i;
		attr.upperOhter = i;
		attr.upperBlack = i;
		attr.upperWhite = i;
		attr.upperGray = i;
		attr.upperRed = i;
		attr.upperGreen = i;
		attr.upperBlue = i;
		attr.upperSilvery = i;
		attr.upperYellow = i;
		attr.upperBrown = i;
		attr.upperPurple = i;
		attr.upperPink = i;
		attr.upperOrange = i;
		attr.upperMixColor = i;
		attr.upperOtherColor = i;
		attr.lowerPants = i;
		attr.lowerShortPants = i;
		attr.lowerSkirt = i;
		attr.lowerShortSkirt = i;
		attr.lowerLongSkirt = i;
		attr.lowerOnePiece = i;
		attr.lowerJean = i;
		attr.lowerTightPants = i;
		attr.lowerBlack = i;
		attr.lowerWhite = i;
		attr.lowerGray = i;
		attr.lowerRed = i;
		attr.lowerGreen = i;
		attr.lowerBlue = i;
		attr.lowerSilver = i;
		attr.lowerYellow = i;
		attr.lowerBrown = i;
		attr.lowerPurple = i;
		attr.lowerPink = i;
		attr.lowerOrange = i;
		attr.lowerMixColor = i;
		attr.lowerOtherColor = i;
		attr.shoesLeather = i;
		attr.shoesSport = i;
		attr.shoesBoot = i;
		attr.shoesCloth = i;
		attr.shoesShandle = i;
		attr.shoesCasual = i;
		attr.shoesOther = i;
		attr.shoesBlack = i;
		attr.shoesWhite = i;
		attr.shoesGray = i;
		attr.shoesRed = i;
		attr.shoesGreen = i;
		attr.shoesBlue = i;
		attr.shoesSilver = i;
		attr.shoesYellow = i;
		attr.shoesBrown = i;
		attr.shoesPurple = i;
		attr.shoesPink = i;
		attr.shoesOrange = i;
		attr.shoesMixColor = i;
		attr.shoesOtherColor = i;
		attr.accessoryBackPack = i;
		attr.accessorySholderBag = i;
		attr.accessoryHandBag = i;
		attr.accessoryWaistBag = i;
		attr.accessoryBox = i;
		attr.accessoryPlasticBag = i;
		attr.accessoryPaperBag = i;
		attr.accessoryCart = i;
		attr.accessoryKid = i;
		attr.accessoryOther = i;
		attr.actionCalling = i;
		attr.actionArmStretching = i;
		attr.actionChatting = i;
		attr.actionGathering = i;
		attr.actionLying = i;
		attr.actionCrouching = i;
		attr.actionRunning = i;
		attr.actionHolding = i;
		attr.actionPushing = i;
		attr.actionPulling = i;
		attr.actionNipThing = i;
		attr.actionPicking = i;
		attr.actionOther = i;
		attr.viewAngleLeft = i;
		attr.viewAngleRight = i;
		attr.viewAngleFront = i;
		attr.viewAngleBack = i;
		attr.occlusionLeft = i;
		attr.occlusionRight = i;
		attr.occlusionUp = i;
		attr.occlusionDown = i;
		attr.occlusionEnvironment = i;
		attr.occlusionAccessory = i;
		attr.occlusionObject = i;
		attr.occlusionOther = i;
		return attr;
	}

	static void printLink(Link[] links) {
		System.out.printf("-------------- Links for Node id: %s --------------\n", links[0].getId1());
		for (int i = 0; i < links.length; ++i) {
			System.out.println("idA: " + links[i].getId1() + ", " + "idB: " + links[i].getId2() + ", " + "similarity: "
					+ links[i].getSimilarity());
		}
		System.out.println("--------------------------------------------------");
	}

}
