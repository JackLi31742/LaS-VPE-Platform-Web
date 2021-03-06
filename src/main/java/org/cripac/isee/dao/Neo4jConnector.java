package org.cripac.isee.dao;

import java.util.NoSuchElementException;

import org.cripac.isee.entity.Attributes;
import org.cripac.isee.entity.Link;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;
import org.springframework.stereotype.Repository;

@Repository 
public class Neo4jConnector implements GraphDatabaseConnectorDao {

	Driver driver = GraphDatabase.driver( "bolt://172.18.33.39:7687");
    Session session = driver.session();
	
    protected void finalize() throws Throwable {
    	try {
    		session.close();
    		driver.close();
    	} finally {
    		super.finalize();
    	}
    }
    
	@Override
	public void setTrackSavingPath(String id, String path) {
		// Set path to an existing node or one newly created.
		session.run("MERGE (p:Person {id: {id}}) SET p.path={path};", Values.parameters("id", id, "path", path));
	}

	@Override
	public String getTrackletSavingDir(String id) throws NoSuchElementException {
		// Return path of an existing node, otherwise, return nothing.
		StatementResult result = session.run("MATCH (p:Person {id: {id}}) RETURN p.path;", Values.parameters("id", id));
		if (result.hasNext()) {
			// Just return the first match.
			Record record = result.next();
			return record.get("p.path").asString();
		}
		// No match.
		throw new NoSuchElementException();
	}

	@Override
	public void setPedestrianSimilarity(String idA, String idB, float similarity) {
		// Directed relationship from idA to idB.
		// If one of idA and idB does not exist, do nothing.
		// If relationship already exists, change the value; Otherwise, create a relationship and set the value.
		session.run("MATCH (p1:Person {id: {id1}}), (p2:Person {id: {id2}}) MERGE (p1)-[s:Similar]->(p2) SET s.similarity={sim};", Values.parameters("id1", idA, "id2", idB, "sim", similarity));
	}

	@Override
	public float getPedestrianSimilarity(String idA, String idB) throws NoSuchElementException {
		// Match the whole pattern and return the similarity, if the pattern exists.
		StatementResult result = session.run("MATCH (p1:Person {id: {id1}})-[s:Similar]->(p2:Person {id: {id2}}) RETURN s.similarity;", Values.parameters("id1", idA, "id2", idB));
		if (result.hasNext()) {
			// Just return the first match.
			Record record = result.next();
			return record.get("s.similarity").asFloat();
		}
		// No match.
		throw new NoSuchElementException();
	}

	@Override
	public void setPedestrianAttributes(String id, Attributes attr) {
		// Set attributes to an existing node or one newly created.
		session.run("MERGE (p:Person {id: {id}}) SET "
				+ "p.genderMale = {genderMale}, "
				+ "p.genderFemale = {genderFemale}, "
				+ "p.genderOther = {genderOther}, "
				+ "p.ageSixteen = {ageSixteen}, "
				+ "p.ageThirty = {ageThirty}, "
				+ "p.ageFortyFive = {ageFortyFive}, "
				+ "p.ageSixty = {ageSixty}, "
				+ "p.ageOlderSixty = {ageOlderSixty}, "
				+ "p.weightVeryFat = {weightVeryFat}, "
				+ "p.weightLittleFat = {weightLittleFat}, "
				+ "p.weightNormal = {weightNormal}, "
				+ "p.weightLittleThin = {weightLittleThin}, "
				+ "p.weightVeryThin = {weightVeryThin}, "
				+ "p.roleClient = {roleClient}, "
				+ "p.roleUniform = {roleUniform}, "
				+ "p.hairStyleNull = {hairStyleNull}, "
				+ "p.hairStyleLong = {hairStyleLong}, "
				+ "p.headShoulderBlackHair = {headShoulderBlackHair}, "
				+ "p.headShouldWithHat = {headShouldWithHat}, "
				+ "p.headShouldGlasses = {headShouldGlasses}, "
				+ "p.headShouldSunglasses = {headShouldSunglasses}, "
				+ "p.headShouldScarf = {headShouldScarf}, "
				+ "p.headShouldMask = {headShouldMask}, "
				+ "p.upperShirt = {upperShirt}, "
				+ "p.upperSweater = {upperSweater}, "
				+ "p.upperVest = {upperVest}, "
				+ "p.upperTshirt = {upperTshirt}, "
				+ "p.upperCotton = {upperCotton}, "
				+ "p.upperJacket = {upperJacket}, "
				+ "p.upperSuit = {upperSuit}, "
				+ "p.upperHoodie = {upperHoodie}, "
				+ "p.upperCotta = {upperCotta}, "
				+ "p.upperOhter = {upperOhter}, "
				+ "p.upperBlack = {upperBlack}, "
				+ "p.upperWhite = {upperWhite}, "
				+ "p.upperGray = {upperGray}, "
				+ "p.upperRed = {upperRed}, "
				+ "p.upperGreen = {upperGreen}, "
				+ "p.upperBlue = {upperBlue}, "
				+ "p.upperSilvery = {upperSilvery}, "
				+ "p.upperYellow = {upperYellow}, "
				+ "p.upperBrown = {upperBrown}, "
				+ "p.upperPurple = {upperPurple}, "
				+ "p.upperPink = {upperPink}, "
				+ "p.upperOrange = {upperOrange}, "
				+ "p.upperMixColor = {upperMixColor}, "
				+ "p.upperOtherColor = {upperOtherColor}, "
				+ "p.lowerPants = {lowerPants}, "
				+ "p.lowerShortPants = {lowerShortPants}, "
				+ "p.lowerSkirt = {lowerSkirt}, "
				+ "p.lowerShortSkirt = {lowerShortSkirt}, "
				+ "p.lowerLongSkirt = {lowerLongSkirt}, "
				+ "p.lowerOnePiece = {lowerOnePiece}, "
				+ "p.lowerJean = {lowerJean}, "
				+ "p.lowerTightPants = {lowerTightPants}, "
				+ "p.lowerBlack = {lowerBlack}, "
				+ "p.lowerWhite = {lowerWhite}, "
				+ "p.lowerGray = {lowerGray}, "
				+ "p.lowerRed = {lowerRed}, "
				+ "p.lowerGreen = {lowerGreen}, "
				+ "p.lowerBlue = {lowerBlue}, "
				+ "p.lowerSilver = {lowerSilver}, "
				+ "p.lowerYellow = {lowerYellow}, "
				+ "p.lowerBrown = {lowerBrown}, "
				+ "p.lowerPurple = {lowerPurple}, "
				+ "p.lowerPink = {lowerPink}, "
				+ "p.lowerOrange = {lowerOrange}, "
				+ "p.lowerMixColor = {lowerMixColor}, "
				+ "p.lowerOtherColor = {lowerOtherColor}, "
				+ "p.shoesLeather = {shoesLeather}, "
				+ "p.shoesSport = {shoesSport}, "
				+ "p.shoesBoot = {shoesBoot}, "
				+ "p.shoesCloth = {shoesCloth}, "
				+ "p.shoesShandle = {shoesShandle}, "
				+ "p.shoesCasual = {shoesCasual}, "
				+ "p.shoesOther = {shoesOther}, "
				+ "p.shoesBlack = {shoesBlack}, "
				+ "p.shoesWhite = {shoesWhite}, "
				+ "p.shoesGray = {shoesGray}, "
				+ "p.shoesRed = {shoesRed}, "
				+ "p.shoesGreen = {shoesGreen}, "
				+ "p.shoesBlue = {shoesBlue}, "
				+ "p.shoesSilver = {shoesSilver}, "
				+ "p.shoesYellow = {shoesYellow}, "
				+ "p.shoesBrown = {shoesBrown}, "
				+ "p.shoesPurple = {shoesPurple}, "
				+ "p.shoesPink = {shoesPink}, "
				+ "p.shoesOrange = {shoesOrange}, "
				+ "p.shoesMixColor = {shoesMixColor}, "
				+ "p.shoesOtherColor = {shoesOtherColor}, "
				+ "p.accessoryBackPack = {accessoryBackPack}, "
				+ "p.accessorySholderBag = {accessorySholderBag}, "
				+ "p.accessoryHandBag = {accessoryHandBag}, "
				+ "p.accessoryWaistBag = {accessoryWaistBag}, "
				+ "p.accessoryBox = {accessoryBox}, "
				+ "p.accessoryPlasticBag = {accessoryPlasticBag}, "
				+ "p.accessoryPaperBag = {accessoryPaperBag}, "
				+ "p.accessoryCart = {accessoryCart}, "
				+ "p.accessoryKid = {accessoryKid}, "
				+ "p.accessoryOther = {accessoryOther}, "
				+ "p.actionCalling = {actionCalling}, "
				+ "p.actionArmStretching = {actionArmStretching}, "
				+ "p.actionChatting = {actionChatting}, "
				+ "p.actionGathering = {actionGathering}, "
				+ "p.actionLying = {actionLying}, "
				+ "p.actionCrouching = {actionCrouching}, "
				+ "p.actionRunning = {actionRunning}, "
				+ "p.actionHolding = {actionHolding}, "
				+ "p.actionPushing = {actionPushing}, "
				+ "p.actionPulling = {actionPulling}, "
				+ "p.actionNipThing = {actionNipThing}, "
				+ "p.actionPicking = {actionPicking}, "
				+ "p.actionOther = {actionOther}, "
				+ "p.viewAngleLeft = {viewAngleLeft}, "
				+ "p.viewAngleRight = {viewAngleRight}, "
				+ "p.viewAngleFront = {viewAngleFront}, "
				+ "p.viewAngleBack = {viewAngleBack}, "
				+ "p.occlusionLeft = {occlusionLeft}, "
				+ "p.occlusionRight = {occlusionRight}, "
				+ "p.occlusionUp = {occlusionUp}, "
				+ "p.occlusionDown = {occlusionDown}, "
				+ "p.occlusionEnvironment = {occlusionEnvironment}, "
				+ "p.occlusionAccessory = {occlusionAccessory}, "
				+ "p.occlusionObject = {occlusionObject}, "
				+ "p.occlusionOther = {occlusionOther};",
				Values.parameters(
						"id", id,
						"genderMale", attr.genderMale, 
						"genderFemale", attr.genderFemale, 
						"genderOther", attr.genderOther, 
						"ageSixteen", attr.ageSixteen, 
						"ageThirty", attr.ageThirty, 
						"ageFortyFive", attr.ageFortyFive, 
						"ageSixty", attr.ageSixty, 
						"ageOlderSixty", attr.ageOlderSixty, 
						"weightVeryFat", attr.weightVeryFat, 
						"weightLittleFat", attr.weightLittleFat, 
						"weightNormal", attr.weightNormal, 
						"weightLittleThin", attr.weightLittleThin, 
						"weightVeryThin", attr.weightVeryThin, 
						"roleClient", attr.roleClient, 
						"roleUniform", attr.roleUniform, 
						"hairStyleNull", attr.hairStyleNull, 
						"hairStyleLong", attr.hairStyleLong, 
						"headShoulderBlackHair", attr.headShoulderBlackHair, 
						"headShouldWithHat", attr.headShouldWithHat, 
						"headShouldGlasses", attr.headShouldGlasses, 
						"headShouldSunglasses", attr.headShouldSunglasses, 
						"headShouldScarf", attr.headShouldScarf, 
						"headShouldMask", attr.headShouldMask, 
						"upperShirt", attr.upperShirt, 
						"upperSweater", attr.upperSweater, 
						"upperVest", attr.upperVest, 
						"upperTshirt", attr.upperTshirt, 
						"upperCotton", attr.upperCotton, 
						"upperJacket", attr.upperJacket, 
						"upperSuit", attr.upperSuit, 
						"upperHoodie", attr.upperHoodie, 
						"upperCotta", attr.upperCotta, 
						"upperOhter", attr.upperOhter, 
						"upperBlack", attr.upperBlack, 
						"upperWhite", attr.upperWhite, 
						"upperGray", attr.upperGray, 
						"upperRed", attr.upperRed, 
						"upperGreen", attr.upperGreen, 
						"upperBlue", attr.upperBlue, 
						"upperSilvery", attr.upperSilvery, 
						"upperYellow", attr.upperYellow, 
						"upperBrown", attr.upperBrown, 
						"upperPurple", attr.upperPurple, 
						"upperPink", attr.upperPink, 
						"upperOrange", attr.upperOrange, 
						"upperMixColor", attr.upperMixColor, 
						"upperOtherColor", attr.upperOtherColor, 
						"lowerPants", attr.lowerPants, 
						"lowerShortPants", attr.lowerShortPants, 
						"lowerSkirt", attr.lowerSkirt, 
						"lowerShortSkirt", attr.lowerShortSkirt, 
						"lowerLongSkirt", attr.lowerLongSkirt, 
						"lowerOnePiece", attr.lowerOnePiece, 
						"lowerJean", attr.lowerJean, 
						"lowerTightPants", attr.lowerTightPants, 
						"lowerBlack", attr.lowerBlack, 
						"lowerWhite", attr.lowerWhite, 
						"lowerGray", attr.lowerGray, 
						"lowerRed", attr.lowerRed, 
						"lowerGreen", attr.lowerGreen, 
						"lowerBlue", attr.lowerBlue, 
						"lowerSilver", attr.lowerSilver, 
						"lowerYellow", attr.lowerYellow, 
						"lowerBrown", attr.lowerBrown, 
						"lowerPurple", attr.lowerPurple, 
						"lowerPink", attr.lowerPink, 
						"lowerOrange", attr.lowerOrange, 
						"lowerMixColor", attr.lowerMixColor, 
						"lowerOtherColor", attr.lowerOtherColor, 
						"shoesLeather", attr.shoesLeather, 
						"shoesSport", attr.shoesSport, 
						"shoesBoot", attr.shoesBoot, 
						"shoesCloth", attr.shoesCloth, 
						"shoesShandle", attr.shoesShandle, 
						"shoesCasual", attr.shoesCasual, 
						"shoesOther", attr.shoesOther, 
						"shoesBlack", attr.shoesBlack, 
						"shoesWhite", attr.shoesWhite, 
						"shoesGray", attr.shoesGray, 
						"shoesRed", attr.shoesRed, 
						"shoesGreen", attr.shoesGreen, 
						"shoesBlue", attr.shoesBlue, 
						"shoesSilver", attr.shoesSilver, 
						"shoesYellow", attr.shoesYellow, 
						"shoesBrown", attr.shoesBrown, 
						"shoesPurple", attr.shoesPurple, 
						"shoesPink", attr.shoesPink, 
						"shoesOrange", attr.shoesOrange, 
						"shoesMixColor", attr.shoesMixColor, 
						"shoesOtherColor", attr.shoesOtherColor, 
						"accessoryBackPack", attr.accessoryBackPack, 
						"accessorySholderBag", attr.accessorySholderBag, 
						"accessoryHandBag", attr.accessoryHandBag, 
						"accessoryWaistBag", attr.accessoryWaistBag, 
						"accessoryBox", attr.accessoryBox, 
						"accessoryPlasticBag", attr.accessoryPlasticBag, 
						"accessoryPaperBag", attr.accessoryPaperBag, 
						"accessoryCart", attr.accessoryCart, 
						"accessoryKid", attr.accessoryKid, 
						"accessoryOther", attr.accessoryOther, 
						"actionCalling", attr.actionCalling, 
						"actionArmStretching", attr.actionArmStretching, 
						"actionChatting", attr.actionChatting, 
						"actionGathering", attr.actionGathering, 
						"actionLying", attr.actionLying, 
						"actionCrouching", attr.actionCrouching, 
						"actionRunning", attr.actionRunning, 
						"actionHolding", attr.actionHolding, 
						"actionPushing", attr.actionPushing, 
						"actionPulling", attr.actionPulling, 
						"actionNipThing", attr.actionNipThing, 
						"actionPicking", attr.actionPicking, 
						"actionOther", attr.actionOther, 
						"viewAngleLeft", attr.viewAngleLeft, 
						"viewAngleRight", attr.viewAngleRight, 
						"viewAngleFront", attr.viewAngleFront, 
						"viewAngleBack", attr.viewAngleBack, 
						"occlusionLeft", attr.occlusionLeft, 
						"occlusionRight", attr.occlusionRight, 
						"occlusionUp", attr.occlusionUp, 
						"occlusionDown", attr.occlusionDown, 
						"occlusionEnvironment", attr.occlusionEnvironment, 
						"occlusionAccessory", attr.occlusionAccessory, 
						"occlusionObject", attr.occlusionObject, 
						"occlusionOther", attr.occlusionOther
						));
	}

	@Override
	public Attributes getPedestrianAttributes(String id) throws NoSuchElementException {
		// Return attributes of an existing node, otherwise, return nothing.
		StatementResult result = session.run("MATCH (p:Person {id: {id}}) RETURN "
				+ "p.genderMale, "
				+ "p.genderFemale, "
				+ "p.genderOther, "
				+ "p.ageSixteen, "
				+ "p.ageThirty, "
				+ "p.ageFortyFive, "
				+ "p.ageSixty, "
				+ "p.ageOlderSixty, "
				+ "p.weightVeryFat, "
				+ "p.weightLittleFat, "
				+ "p.weightNormal, "
				+ "p.weightLittleThin, "
				+ "p.weightVeryThin, "
				+ "p.roleClient, "
				+ "p.roleUniform, "
				+ "p.hairStyleNull, "
				+ "p.hairStyleLong, "
				+ "p.headShoulderBlackHair, "
				+ "p.headShouldWithHat, "
				+ "p.headShouldGlasses, "
				+ "p.headShouldSunglasses, "
				+ "p.headShouldScarf, "
				+ "p.headShouldMask, "
				+ "p.upperShirt, "
				+ "p.upperSweater, "
				+ "p.upperVest, "
				+ "p.upperTshirt, "
				+ "p.upperCotton, "
				+ "p.upperJacket, "
				+ "p.upperSuit, "
				+ "p.upperHoodie, "
				+ "p.upperCotta, "
				+ "p.upperOhter, "
				+ "p.upperBlack, "
				+ "p.upperWhite, "
				+ "p.upperGray, "
				+ "p.upperRed, "
				+ "p.upperGreen, "
				+ "p.upperBlue, "
				+ "p.upperSilvery, "
				+ "p.upperYellow, "
				+ "p.upperBrown, "
				+ "p.upperPurple, "
				+ "p.upperPink, "
				+ "p.upperOrange, "
				+ "p.upperMixColor, "
				+ "p.upperOtherColor, "
				+ "p.lowerPants, "
				+ "p.lowerShortPants, "
				+ "p.lowerSkirt, "
				+ "p.lowerShortSkirt, "
				+ "p.lowerLongSkirt, "
				+ "p.lowerOnePiece, "
				+ "p.lowerJean, "
				+ "p.lowerTightPants, "
				+ "p.lowerBlack, "
				+ "p.lowerWhite, "
				+ "p.lowerGray, "
				+ "p.lowerRed, "
				+ "p.lowerGreen, "
				+ "p.lowerBlue, "
				+ "p.lowerSilver, "
				+ "p.lowerYellow, "
				+ "p.lowerBrown, "
				+ "p.lowerPurple, "
				+ "p.lowerPink, "
				+ "p.lowerOrange, "
				+ "p.lowerMixColor, "
				+ "p.lowerOtherColor, "
				+ "p.shoesLeather, "
				+ "p.shoesSport, "
				+ "p.shoesBoot, "
				+ "p.shoesCloth, "
				+ "p.shoesShandle, "
				+ "p.shoesCasual, "
				+ "p.shoesOther, "
				+ "p.shoesBlack, "
				+ "p.shoesWhite, "
				+ "p.shoesGray, "
				+ "p.shoesRed, "
				+ "p.shoesGreen, "
				+ "p.shoesBlue, "
				+ "p.shoesSilver, "
				+ "p.shoesYellow, "
				+ "p.shoesBrown, "
				+ "p.shoesPurple, "
				+ "p.shoesPink, "
				+ "p.shoesOrange, "
				+ "p.shoesMixColor, "
				+ "p.shoesOtherColor, "
				+ "p.accessoryBackPack, "
				+ "p.accessorySholderBag, "
				+ "p.accessoryHandBag, "
				+ "p.accessoryWaistBag, "
				+ "p.accessoryBox, "
				+ "p.accessoryPlasticBag, "
				+ "p.accessoryPaperBag, "
				+ "p.accessoryCart, "
				+ "p.accessoryKid, "
				+ "p.accessoryOther, "
				+ "p.actionCalling, "
				+ "p.actionArmStretching, "
				+ "p.actionChatting, "
				+ "p.actionGathering, "
				+ "p.actionLying, "
				+ "p.actionCrouching, "
				+ "p.actionRunning, "
				+ "p.actionHolding, "
				+ "p.actionPushing, "
				+ "p.actionPulling, "
				+ "p.actionNipThing, "
				+ "p.actionPicking, "
				+ "p.actionOther, "
				+ "p.viewAngleLeft, "
				+ "p.viewAngleRight, "
				+ "p.viewAngleFront, "
				+ "p.viewAngleBack, "
				+ "p.occlusionLeft, "
				+ "p.occlusionRight, "
				+ "p.occlusionUp, "
				+ "p.occlusionDown, "
				+ "p.occlusionEnvironment, "
				+ "p.occlusionAccessory, "
				+ "p.occlusionObject, "
				+ "p.occlusionOther;",
				Values.parameters("id", id));
		if (result.hasNext()) {
			// Just return the first match.
			Attributes attr = new Attributes();
			Record record = result.next();
			
			attr.genderMale = record.get("p.genderMale").asFloat();
			attr.genderFemale = record.get("p.genderFemale").asFloat();
			attr.genderOther = record.get("p.genderOther").asFloat();
			attr.ageSixteen = record.get("p.ageSixteen").asFloat();
			attr.ageThirty = record.get("p.ageThirty").asFloat();
			attr.ageFortyFive = record.get("p.ageFortyFive").asFloat();
			attr.ageSixty = record.get("p.ageSixty").asFloat();
			attr.ageOlderSixty = record.get("p.ageOlderSixty").asFloat();
			attr.weightVeryFat = record.get("p.weightVeryFat").asFloat();
			attr.weightLittleFat = record.get("p.weightLittleFat").asFloat();
			attr.weightNormal = record.get("p.weightNormal").asFloat();
			attr.weightLittleThin = record.get("p.weightLittleThin").asFloat();
			attr.weightVeryThin = record.get("p.weightVeryThin").asFloat();
			attr.roleClient = record.get("p.roleClient").asFloat();
			attr.roleUniform = record.get("p.roleUniform").asFloat();
			attr.hairStyleNull = record.get("p.hairStyleNull").asFloat();
			attr.hairStyleLong = record.get("p.hairStyleLong").asFloat();
			attr.headShoulderBlackHair = record.get("p.headShoulderBlackHair").asFloat();
			attr.headShouldWithHat = record.get("p.headShouldWithHat").asFloat();
			attr.headShouldGlasses = record.get("p.headShouldGlasses").asFloat();
			attr.headShouldSunglasses = record.get("p.headShouldSunglasses").asFloat();
			attr.headShouldScarf = record.get("p.headShouldScarf").asFloat();
			attr.headShouldMask = record.get("p.headShouldMask").asFloat();
			attr.upperShirt = record.get("p.upperShirt").asFloat();
			attr.upperSweater = record.get("p.upperSweater").asFloat();
			attr.upperVest = record.get("p.upperVest").asFloat();
			attr.upperTshirt = record.get("p.upperTshirt").asFloat();
			attr.upperCotton = record.get("p.upperCotton").asFloat();
			attr.upperJacket = record.get("p.upperJacket").asFloat();
			attr.upperSuit = record.get("p.upperSuit").asFloat();
			attr.upperHoodie = record.get("p.upperHoodie").asFloat();
			attr.upperCotta = record.get("p.upperCotta").asFloat();
			attr.upperOhter = record.get("p.upperOhter").asFloat();
			attr.upperBlack = record.get("p.upperBlack").asFloat();
			attr.upperWhite = record.get("p.upperWhite").asFloat();
			attr.upperGray = record.get("p.upperGray").asFloat();
			attr.upperRed = record.get("p.upperRed").asFloat();
			attr.upperGreen = record.get("p.upperGreen").asFloat();
			attr.upperBlue = record.get("p.upperBlue").asFloat();
			attr.upperSilvery = record.get("p.upperSilvery").asFloat();
			attr.upperYellow = record.get("p.upperYellow").asFloat();
			attr.upperBrown = record.get("p.upperBrown").asFloat();
			attr.upperPurple = record.get("p.upperPurple").asFloat();
			attr.upperPink = record.get("p.upperPink").asFloat();
			attr.upperOrange = record.get("p.upperOrange").asFloat();
			attr.upperMixColor = record.get("p.upperMixColor").asFloat();
			attr.upperOtherColor = record.get("p.upperOtherColor").asFloat();
			attr.lowerPants = record.get("p.lowerPants").asFloat();
			attr.lowerShortPants = record.get("p.lowerShortPants").asFloat();
			attr.lowerSkirt = record.get("p.lowerSkirt").asFloat();
			attr.lowerShortSkirt = record.get("p.lowerShortSkirt").asFloat();
			attr.lowerLongSkirt = record.get("p.lowerLongSkirt").asFloat();
			attr.lowerOnePiece = record.get("p.lowerOnePiece").asFloat();
			attr.lowerJean = record.get("p.lowerJean").asFloat();
			attr.lowerTightPants = record.get("p.lowerTightPants").asFloat();
			attr.lowerBlack = record.get("p.lowerBlack").asFloat();
			attr.lowerWhite = record.get("p.lowerWhite").asFloat();
			attr.lowerGray = record.get("p.lowerGray").asFloat();
			attr.lowerRed = record.get("p.lowerRed").asFloat();
			attr.lowerGreen = record.get("p.lowerGreen").asFloat();
			attr.lowerBlue = record.get("p.lowerBlue").asFloat();
			attr.lowerSilver = record.get("p.lowerSilver").asFloat();
			attr.lowerYellow = record.get("p.lowerYellow").asFloat();
			attr.lowerBrown = record.get("p.lowerBrown").asFloat();
			attr.lowerPurple = record.get("p.lowerPurple").asFloat();
			attr.lowerPink = record.get("p.lowerPink").asFloat();
			attr.lowerOrange = record.get("p.lowerOrange").asFloat();
			attr.lowerMixColor = record.get("p.lowerMixColor").asFloat();
			attr.lowerOtherColor = record.get("p.lowerOtherColor").asFloat();
			attr.shoesLeather = record.get("p.shoesLeather").asFloat();
			attr.shoesSport = record.get("p.shoesSport").asFloat();
			attr.shoesBoot = record.get("p.shoesBoot").asFloat();
			attr.shoesCloth = record.get("p.shoesCloth").asFloat();
			attr.shoesShandle = record.get("p.shoesShandle").asFloat();
			attr.shoesCasual = record.get("p.shoesCasual").asFloat();
			attr.shoesOther = record.get("p.shoesOther").asFloat();
			attr.shoesBlack = record.get("p.shoesBlack").asFloat();
			attr.shoesWhite = record.get("p.shoesWhite").asFloat();
			attr.shoesGray = record.get("p.shoesGray").asFloat();
			attr.shoesRed = record.get("p.shoesRed").asFloat();
			attr.shoesGreen = record.get("p.shoesGreen").asFloat();
			attr.shoesBlue = record.get("p.shoesBlue").asFloat();
			attr.shoesSilver = record.get("p.shoesSilver").asFloat();
			attr.shoesYellow = record.get("p.shoesYellow").asFloat();
			attr.shoesBrown = record.get("p.shoesBrown").asFloat();
			attr.shoesPurple = record.get("p.shoesPurple").asFloat();
			attr.shoesPink = record.get("p.shoesPink").asFloat();
			attr.shoesOrange = record.get("p.shoesOrange").asFloat();
			attr.shoesMixColor = record.get("p.shoesMixColor").asFloat();
			attr.shoesOtherColor = record.get("p.shoesOtherColor").asFloat();
			attr.accessoryBackPack = record.get("p.accessoryBackPack").asFloat();
			attr.accessorySholderBag = record.get("p.accessorySholderBag").asFloat();
			attr.accessoryHandBag = record.get("p.accessoryHandBag").asFloat();
			attr.accessoryWaistBag = record.get("p.accessoryWaistBag").asFloat();
			attr.accessoryBox = record.get("p.accessoryBox").asFloat();
			attr.accessoryPlasticBag = record.get("p.accessoryPlasticBag").asFloat();
			attr.accessoryPaperBag = record.get("p.accessoryPaperBag").asFloat();
			attr.accessoryCart = record.get("p.accessoryCart").asFloat();
			attr.accessoryKid = record.get("p.accessoryKid").asFloat();
			attr.accessoryOther = record.get("p.accessoryOther").asFloat();
			attr.actionCalling = record.get("p.actionCalling").asFloat();
			attr.actionArmStretching = record.get("p.actionArmStretching").asFloat();
			attr.actionChatting = record.get("p.actionChatting").asFloat();
			attr.actionGathering = record.get("p.actionGathering").asFloat();
			attr.actionLying = record.get("p.actionLying").asFloat();
			attr.actionCrouching = record.get("p.actionCrouching").asFloat();
			attr.actionRunning = record.get("p.actionRunning").asFloat();
			attr.actionHolding = record.get("p.actionHolding").asFloat();
			attr.actionPushing = record.get("p.actionPushing").asFloat();
			attr.actionPulling = record.get("p.actionPulling").asFloat();
			attr.actionNipThing = record.get("p.actionNipThing").asFloat();
			attr.actionPicking = record.get("p.actionPicking").asFloat();
			attr.actionOther = record.get("p.actionOther").asFloat();
			attr.viewAngleLeft = record.get("p.viewAngleLeft").asFloat();
			attr.viewAngleRight = record.get("p.viewAngleRight").asFloat();
			attr.viewAngleFront = record.get("p.viewAngleFront").asFloat();
			attr.viewAngleBack = record.get("p.viewAngleBack").asFloat();
			attr.occlusionLeft = record.get("p.occlusionLeft").asFloat();
			attr.occlusionRight = record.get("p.occlusionRight").asFloat();
			attr.occlusionUp = record.get("p.occlusionUp").asFloat();
			attr.occlusionDown = record.get("p.occlusionDown").asFloat();
			attr.occlusionEnvironment = record.get("p.occlusionEnvironment").asFloat();
			attr.occlusionAccessory = record.get("p.occlusionAccessory").asFloat();
			attr.occlusionObject = record.get("p.occlusionObject").asFloat();
			attr.occlusionOther = record.get("p.occlusionOther").asFloat();
			
			return attr;
		}
		// No match.
		throw new NoSuchElementException();
	}

	@Override
	public Link[] getLinkedPedestrians(String id) throws NoSuchElementException {
		// Match the whole pattern and, return the number of matches.
		StatementResult result = session.run("MATCH (p1:Person {id: {id}})-[s:Similar]->(p2:Person) RETURN count(*) AS num;", Values.parameters("id", id));
		int num = 0;
		if (result.hasNext()) {
			Record record = result.next();
			num = record.get("num").asInt();
		}
		Link[] links = new Link[num];
		if (num == 0) {
			return links;
		}
		
		// Match the whole pattern and, return the other node and the similarity for each match.
		// Results are sorted in descending order.
		result = session.run("MATCH (p1:Person {id: {id}})-[s:Similar]->(p2:Person) WITH s.similarity AS sim, p2.id AS id2 ORDER BY sim DESC RETURN sim, id2;", Values.parameters("id", id));
		int i = 0;
		while (result.hasNext()) {
			Record record = result.next();
			links[i++] = new Link(id, record.get("id2").asString(), record.get("sim").asFloat());
		}
		return links;
	}

}
