/***********************************************************************
 * This file is part of LaS-VPE Platform.
 *
 * LaS-VPE Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LaS-VPE Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LaS-VPE Platform.  If not, see <http://www.gnu.org/licenses/>.
 ************************************************************************/

package org.cripac.isee.entity;

import java.io.Serializable;

import org.cripac.isee.dao.Tracklet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * The Attribute class stores all the pre-defined attributes of a pedestrian at
 * one moment in a track. In other words, each attribute object correspond to
 * one bounding box in a track.
 * <p>
 * <p>
 * TODO Fill the pre-defined attributes. </p>
 *
 * @author Ken Yu, CRIPAC, 2016
 */
public class Attributes implements Serializable {


    @SerializedName("tracklet_id")
    public Tracklet.Identifier trackletID;

    @SerializedName("gender_male")
    public float genderMale;

    @SerializedName("gender_female")
    public float genderFemale;

    @SerializedName("gender_other")
    public float genderOther;

    @SerializedName("age_16")
    public float ageSixteen;

    @SerializedName("age_30")
    public float ageThirty;

    @SerializedName("age_45")
    public float ageFortyFive;

    @SerializedName("age_60")
    public float ageSixty;

	// houjing
    @SerializedName("age_older_60")
    public float ageOlderSixty;

    @SerializedName("weight_very_fat")
    public float weightVeryFat;

    @SerializedName("weight_little_fat")
    public float weightLittleFat;

    @SerializedName("weight_normal")
    public float weightNormal;

    @SerializedName("weight_little_thin")
    public float weightLittleThin;

    @SerializedName("weight_very_thin")
    public float weightVeryThin;

    @SerializedName("role_client")
    public float roleClient;

    @SerializedName("role_uniform")
    public float roleUniform;

    @SerializedName("hair_style_null")
    public float hairStyleNull;

    @SerializedName("hair_style_long")
    public float hairStyleLong;

    @SerializedName("head_shoulder_black_hair")
    public float headShoulderBlackHair;

    @SerializedName("head_shoulder_with_hat")
    public float headShouldWithHat;

    @SerializedName("head_shoulder_glasses")
    public float headShouldGlasses;

    @SerializedName("head_shoulder_sunglasses")
    public float headShouldSunglasses;

    @SerializedName("head_shoulder_scarf")
    public float headShouldScarf;

    @SerializedName("head_shoulder_mask")
    public float headShouldMask;

    @SerializedName("upper_shirt")
    public float upperShirt;

    @SerializedName("upper_sweater")
    public float upperSweater;

    @SerializedName("upper_vest")
    public float upperVest;

    @SerializedName("upper_tshirt")
    public float upperTshirt;

    @SerializedName("upper_cotton")
    public float upperCotton;

    @SerializedName("upper_jacket")
    public float upperJacket;

    @SerializedName("upper_suit")
    public float upperSuit;

    @SerializedName("upper_hoodie")
    public float upperHoodie;

    @SerializedName("upper_cotta")
    public float upperCotta;

    @SerializedName("upper_other")
    public float upperOhter;

    @SerializedName("upper_black")
    public float upperBlack;

    @SerializedName("upper_white")
    public float upperWhite;

    @SerializedName("upper_gray")
    public float upperGray;

    @SerializedName("upper_red")
    public float upperRed;

    @SerializedName("upper_green")
    public float upperGreen;

    @SerializedName("upper_blue")
    public float upperBlue;

    @SerializedName("upper_silvery")
    public float upperSilvery;

    @SerializedName("upper_yellow")
    public float upperYellow;

    @SerializedName("upper_brown")
    public float upperBrown;

    @SerializedName("upper_purple")
    public float upperPurple;

    @SerializedName("upper_pink")
    public float upperPink;

    @SerializedName("upper_orange")
    public float upperOrange;

    @SerializedName("upper_mix_color")
    public float upperMixColor;

    @SerializedName("upper_other_color")
    public float upperOtherColor;

    @SerializedName("lower_pants")
    public float lowerPants;

    @SerializedName("lower_short_pants")
    public float lowerShortPants;

    @SerializedName("lower_skirt")
    public float lowerSkirt;

    @SerializedName("lower_short_skirt")
    public float lowerShortSkirt;

    @SerializedName("lower_long_skirt")
    public float lowerLongSkirt;

    @SerializedName("lower_one_piece")
    public float lowerOnePiece;

    @SerializedName("lower_jean")
    public float lowerJean;

    @SerializedName("lower_tight_pants")
    public float lowerTightPants;

    @SerializedName("lower_black")
    public float lowerBlack;

    @SerializedName("lower_white")
    public float lowerWhite;

    @SerializedName("lower_gray")
    public float lowerGray;

    @SerializedName("lower_red")
    public float lowerRed;

    @SerializedName("lower_green")
    public float lowerGreen;

    @SerializedName("lower_blue")
    public float lowerBlue;

    @SerializedName("lower_silver")
    public float lowerSilver;

    @SerializedName("lower_yellow")
    public float lowerYellow;

    @SerializedName("lower_brown")
    public float lowerBrown;

    @SerializedName("lower_purple")
    public float lowerPurple;

    @SerializedName("lower_pink")
    public float lowerPink;

    @SerializedName("lower_orange")
    public float lowerOrange;

    @SerializedName("lower_mix_color")
    public float lowerMixColor;

    @SerializedName("lower_other_color")
    public float lowerOtherColor;

    @SerializedName("shoes_leather")
    public float shoesLeather;

    @SerializedName("shoes_sport")
    public float shoesSport;

    @SerializedName("shoes_boot")
    public float shoesBoot;

    @SerializedName("shoes_cloth")
    public float shoesCloth;

    @SerializedName("shoes_shandle")
    public float shoesShandle;

    @SerializedName("shoes_casual")
    public float shoesCasual;

    @SerializedName("shoes_other")
    public float shoesOther;

    @SerializedName("shoes_black")
    public float shoesBlack;

    @SerializedName("shoes_white")
    public float shoesWhite;

    @SerializedName("shoes_gray")
    public float shoesGray;

    @SerializedName("shoes_red")
    public float shoesRed;

    @SerializedName("shoes_green")
    public float shoesGreen;

    @SerializedName("shoes_blue")
    public float shoesBlue;

    @SerializedName("shoes_silver")
    public float shoesSilver;

    @SerializedName("shoes_yellow")
    public float shoesYellow;

    @SerializedName("shoes_brown")
    public float shoesBrown;

    @SerializedName("shoes_purple")
    public float shoesPurple;

    @SerializedName("shoes_pink")
    public float shoesPink;

    @SerializedName("shoes_orange")
    public float shoesOrange;

    @SerializedName("shoes_mix_color")
    public float shoesMixColor;

    @SerializedName("shoes_other_color")
    public float shoesOtherColor;

    @SerializedName("accessory_backpack")
    public float accessoryBackPack;

    @SerializedName("accessory_shoulderbag")
    public float accessorySholderBag;

    @SerializedName("accessory_handbag")
    public float accessoryHandBag;

    @SerializedName("accessory_waistbag")
    public float accessoryWaistBag;

    @SerializedName("accessory_box")
    public float accessoryBox;

    @SerializedName("accessory_plasticbag")
    public float accessoryPlasticBag;

    @SerializedName("accessory_paperbag")
    public float accessoryPaperBag;

    @SerializedName("accessory_cart")
    public float accessoryCart;

    @SerializedName("accessory_kid")
    public float accessoryKid;

    @SerializedName("accessory_other")
    public float accessoryOther;

    @SerializedName("action_calling")
    public float actionCalling;

    @SerializedName("action_armstretching")
    public float actionArmStretching;

    @SerializedName("action_chatting")
    public float actionChatting;

    @SerializedName("action_gathering")
    public float actionGathering;

    @SerializedName("action_lying")
    public float actionLying;

    @SerializedName("action_crouching")
    public float actionCrouching;

    @SerializedName("action_running")
    public float actionRunning;

    @SerializedName("action_holdthing")
    public float actionHolding;

    @SerializedName("action_pushing")
    public float actionPushing;

    @SerializedName("action_pulling")
    public float actionPulling;

    @SerializedName("action_nipthing")
    public float actionNipThing;

    @SerializedName("action_picking")
    public float actionPicking;

    @SerializedName("action_other")
    public float actionOther;

    @SerializedName("view_angle_left")
    public float viewAngleLeft;

    @SerializedName("view_angle_right")
    public float viewAngleRight;

    @SerializedName("view_angle_front")
    public float viewAngleFront;

    @SerializedName("view_angle_back")
    public float viewAngleBack;

    @SerializedName("occlusion_left")
    public float occlusionLeft;

    @SerializedName("occlusion_right")
    public float occlusionRight;

    @SerializedName("occlusion_up")
    public float occlusionUp;

    @SerializedName("occlusion_down")
    public float occlusionDown;

    @SerializedName("occlusion_environment")
    public float occlusionEnvironment;

    @SerializedName("occlusion_accessory")
    public float occlusionAccessory;

    @SerializedName("occlusion_object")
    public float occlusionObject;

    @SerializedName("occlusion_other")
    public float occlusionOther;

    
    public Tracklet.Identifier getTrackletID() {
		return trackletID;
	}


	public void setTrackletID(Tracklet.Identifier trackletID) {
		this.trackletID = trackletID;
	}


	public float getGenderMale() {
		return genderMale;
	}


	public void setGenderMale(float genderMale) {
		this.genderMale = genderMale;
	}


	public float getGenderFemale() {
		return genderFemale;
	}


	public void setGenderFemale(float genderFemale) {
		this.genderFemale = genderFemale;
	}


	public float getGenderOther() {
		return genderOther;
	}


	public void setGenderOther(float genderOther) {
		this.genderOther = genderOther;
	}


	public float getAgeSixteen() {
		return ageSixteen;
	}


	public void setAgeSixteen(float ageSixteen) {
		this.ageSixteen = ageSixteen;
	}


	public float getAgeThirty() {
		return ageThirty;
	}


	public void setAgeThirty(float ageThirty) {
		this.ageThirty = ageThirty;
	}


	public float getAgeFortyFive() {
		return ageFortyFive;
	}


	public void setAgeFortyFive(float ageFortyFive) {
		this.ageFortyFive = ageFortyFive;
	}


	public float getAgeSixty() {
		return ageSixty;
	}


	public void setAgeSixty(float ageSixty) {
		this.ageSixty = ageSixty;
	}


	public float getAgeOlderSixty() {
		return ageOlderSixty;
	}


	public void setAgeOlderSixty(float ageOlderSixty) {
		this.ageOlderSixty = ageOlderSixty;
	}


	public float getWeightVeryFat() {
		return weightVeryFat;
	}


	public void setWeightVeryFat(float weightVeryFat) {
		this.weightVeryFat = weightVeryFat;
	}


	public float getWeightLittleFat() {
		return weightLittleFat;
	}


	public void setWeightLittleFat(float weightLittleFat) {
		this.weightLittleFat = weightLittleFat;
	}


	public float getWeightNormal() {
		return weightNormal;
	}


	public void setWeightNormal(float weightNormal) {
		this.weightNormal = weightNormal;
	}


	public float getWeightLittleThin() {
		return weightLittleThin;
	}


	public void setWeightLittleThin(float weightLittleThin) {
		this.weightLittleThin = weightLittleThin;
	}


	public float getWeightVeryThin() {
		return weightVeryThin;
	}


	public void setWeightVeryThin(float weightVeryThin) {
		this.weightVeryThin = weightVeryThin;
	}


	public float getRoleClient() {
		return roleClient;
	}


	public void setRoleClient(float roleClient) {
		this.roleClient = roleClient;
	}


	public float getRoleUniform() {
		return roleUniform;
	}


	public void setRoleUniform(float roleUniform) {
		this.roleUniform = roleUniform;
	}


	public float getHairStyleNull() {
		return hairStyleNull;
	}


	public void setHairStyleNull(float hairStyleNull) {
		this.hairStyleNull = hairStyleNull;
	}


	public float getHairStyleLong() {
		return hairStyleLong;
	}


	public void setHairStyleLong(float hairStyleLong) {
		this.hairStyleLong = hairStyleLong;
	}


	public float getHeadShoulderBlackHair() {
		return headShoulderBlackHair;
	}


	public void setHeadShoulderBlackHair(float headShoulderBlackHair) {
		this.headShoulderBlackHair = headShoulderBlackHair;
	}


	public float getHeadShouldWithHat() {
		return headShouldWithHat;
	}


	public void setHeadShouldWithHat(float headShouldWithHat) {
		this.headShouldWithHat = headShouldWithHat;
	}


	public float getHeadShouldGlasses() {
		return headShouldGlasses;
	}


	public void setHeadShouldGlasses(float headShouldGlasses) {
		this.headShouldGlasses = headShouldGlasses;
	}


	public float getHeadShouldSunglasses() {
		return headShouldSunglasses;
	}


	public void setHeadShouldSunglasses(float headShouldSunglasses) {
		this.headShouldSunglasses = headShouldSunglasses;
	}


	public float getHeadShouldScarf() {
		return headShouldScarf;
	}


	public void setHeadShouldScarf(float headShouldScarf) {
		this.headShouldScarf = headShouldScarf;
	}


	public float getHeadShouldMask() {
		return headShouldMask;
	}


	public void setHeadShouldMask(float headShouldMask) {
		this.headShouldMask = headShouldMask;
	}


	public float getUpperShirt() {
		return upperShirt;
	}


	public void setUpperShirt(float upperShirt) {
		this.upperShirt = upperShirt;
	}


	public float getUpperSweater() {
		return upperSweater;
	}


	public void setUpperSweater(float upperSweater) {
		this.upperSweater = upperSweater;
	}


	public float getUpperVest() {
		return upperVest;
	}


	public void setUpperVest(float upperVest) {
		this.upperVest = upperVest;
	}


	public float getUpperTshirt() {
		return upperTshirt;
	}


	public void setUpperTshirt(float upperTshirt) {
		this.upperTshirt = upperTshirt;
	}


	public float getUpperCotton() {
		return upperCotton;
	}


	public void setUpperCotton(float upperCotton) {
		this.upperCotton = upperCotton;
	}


	public float getUpperJacket() {
		return upperJacket;
	}


	public void setUpperJacket(float upperJacket) {
		this.upperJacket = upperJacket;
	}


	public float getUpperSuit() {
		return upperSuit;
	}


	public void setUpperSuit(float upperSuit) {
		this.upperSuit = upperSuit;
	}


	public float getUpperHoodie() {
		return upperHoodie;
	}


	public void setUpperHoodie(float upperHoodie) {
		this.upperHoodie = upperHoodie;
	}


	public float getUpperCotta() {
		return upperCotta;
	}


	public void setUpperCotta(float upperCotta) {
		this.upperCotta = upperCotta;
	}


	public float getUpperOhter() {
		return upperOhter;
	}


	public void setUpperOhter(float upperOhter) {
		this.upperOhter = upperOhter;
	}


	public float getUpperBlack() {
		return upperBlack;
	}


	public void setUpperBlack(float upperBlack) {
		this.upperBlack = upperBlack;
	}


	public float getUpperWhite() {
		return upperWhite;
	}


	public void setUpperWhite(float upperWhite) {
		this.upperWhite = upperWhite;
	}


	public float getUpperGray() {
		return upperGray;
	}


	public void setUpperGray(float upperGray) {
		this.upperGray = upperGray;
	}


	public float getUpperRed() {
		return upperRed;
	}


	public void setUpperRed(float upperRed) {
		this.upperRed = upperRed;
	}


	public float getUpperGreen() {
		return upperGreen;
	}


	public void setUpperGreen(float upperGreen) {
		this.upperGreen = upperGreen;
	}


	public float getUpperBlue() {
		return upperBlue;
	}


	public void setUpperBlue(float upperBlue) {
		this.upperBlue = upperBlue;
	}


	public float getUpperSilvery() {
		return upperSilvery;
	}


	public void setUpperSilvery(float upperSilvery) {
		this.upperSilvery = upperSilvery;
	}


	public float getUpperYellow() {
		return upperYellow;
	}


	public void setUpperYellow(float upperYellow) {
		this.upperYellow = upperYellow;
	}


	public float getUpperBrown() {
		return upperBrown;
	}


	public void setUpperBrown(float upperBrown) {
		this.upperBrown = upperBrown;
	}


	public float getUpperPurple() {
		return upperPurple;
	}


	public void setUpperPurple(float upperPurple) {
		this.upperPurple = upperPurple;
	}


	public float getUpperPink() {
		return upperPink;
	}


	public void setUpperPink(float upperPink) {
		this.upperPink = upperPink;
	}


	public float getUpperOrange() {
		return upperOrange;
	}


	public void setUpperOrange(float upperOrange) {
		this.upperOrange = upperOrange;
	}


	public float getUpperMixColor() {
		return upperMixColor;
	}


	public void setUpperMixColor(float upperMixColor) {
		this.upperMixColor = upperMixColor;
	}


	public float getUpperOtherColor() {
		return upperOtherColor;
	}


	public void setUpperOtherColor(float upperOtherColor) {
		this.upperOtherColor = upperOtherColor;
	}


	public float getLowerPants() {
		return lowerPants;
	}


	public void setLowerPants(float lowerPants) {
		this.lowerPants = lowerPants;
	}


	public float getLowerShortPants() {
		return lowerShortPants;
	}


	public void setLowerShortPants(float lowerShortPants) {
		this.lowerShortPants = lowerShortPants;
	}


	public float getLowerSkirt() {
		return lowerSkirt;
	}


	public void setLowerSkirt(float lowerSkirt) {
		this.lowerSkirt = lowerSkirt;
	}


	public float getLowerShortSkirt() {
		return lowerShortSkirt;
	}


	public void setLowerShortSkirt(float lowerShortSkirt) {
		this.lowerShortSkirt = lowerShortSkirt;
	}


	public float getLowerLongSkirt() {
		return lowerLongSkirt;
	}


	public void setLowerLongSkirt(float lowerLongSkirt) {
		this.lowerLongSkirt = lowerLongSkirt;
	}


	public float getLowerOnePiece() {
		return lowerOnePiece;
	}


	public void setLowerOnePiece(float lowerOnePiece) {
		this.lowerOnePiece = lowerOnePiece;
	}


	public float getLowerJean() {
		return lowerJean;
	}


	public void setLowerJean(float lowerJean) {
		this.lowerJean = lowerJean;
	}


	public float getLowerTightPants() {
		return lowerTightPants;
	}


	public void setLowerTightPants(float lowerTightPants) {
		this.lowerTightPants = lowerTightPants;
	}


	public float getLowerBlack() {
		return lowerBlack;
	}


	public void setLowerBlack(float lowerBlack) {
		this.lowerBlack = lowerBlack;
	}


	public float getLowerWhite() {
		return lowerWhite;
	}


	public void setLowerWhite(float lowerWhite) {
		this.lowerWhite = lowerWhite;
	}


	public float getLowerGray() {
		return lowerGray;
	}


	public void setLowerGray(float lowerGray) {
		this.lowerGray = lowerGray;
	}


	public float getLowerRed() {
		return lowerRed;
	}


	public void setLowerRed(float lowerRed) {
		this.lowerRed = lowerRed;
	}


	public float getLowerGreen() {
		return lowerGreen;
	}


	public void setLowerGreen(float lowerGreen) {
		this.lowerGreen = lowerGreen;
	}


	public float getLowerBlue() {
		return lowerBlue;
	}


	public void setLowerBlue(float lowerBlue) {
		this.lowerBlue = lowerBlue;
	}


	public float getLowerSilver() {
		return lowerSilver;
	}


	public void setLowerSilver(float lowerSilver) {
		this.lowerSilver = lowerSilver;
	}


	public float getLowerYellow() {
		return lowerYellow;
	}


	public void setLowerYellow(float lowerYellow) {
		this.lowerYellow = lowerYellow;
	}


	public float getLowerBrown() {
		return lowerBrown;
	}


	public void setLowerBrown(float lowerBrown) {
		this.lowerBrown = lowerBrown;
	}


	public float getLowerPurple() {
		return lowerPurple;
	}


	public void setLowerPurple(float lowerPurple) {
		this.lowerPurple = lowerPurple;
	}


	public float getLowerPink() {
		return lowerPink;
	}


	public void setLowerPink(float lowerPink) {
		this.lowerPink = lowerPink;
	}


	public float getLowerOrange() {
		return lowerOrange;
	}


	public void setLowerOrange(float lowerOrange) {
		this.lowerOrange = lowerOrange;
	}


	public float getLowerMixColor() {
		return lowerMixColor;
	}


	public void setLowerMixColor(float lowerMixColor) {
		this.lowerMixColor = lowerMixColor;
	}


	public float getLowerOtherColor() {
		return lowerOtherColor;
	}


	public void setLowerOtherColor(float lowerOtherColor) {
		this.lowerOtherColor = lowerOtherColor;
	}


	public float getShoesLeather() {
		return shoesLeather;
	}


	public void setShoesLeather(float shoesLeather) {
		this.shoesLeather = shoesLeather;
	}


	public float getShoesSport() {
		return shoesSport;
	}


	public void setShoesSport(float shoesSport) {
		this.shoesSport = shoesSport;
	}


	public float getShoesBoot() {
		return shoesBoot;
	}


	public void setShoesBoot(float shoesBoot) {
		this.shoesBoot = shoesBoot;
	}


	public float getShoesCloth() {
		return shoesCloth;
	}


	public void setShoesCloth(float shoesCloth) {
		this.shoesCloth = shoesCloth;
	}


	public float getShoesShandle() {
		return shoesShandle;
	}


	public void setShoesShandle(float shoesShandle) {
		this.shoesShandle = shoesShandle;
	}


	public float getShoesCasual() {
		return shoesCasual;
	}


	public void setShoesCasual(float shoesCasual) {
		this.shoesCasual = shoesCasual;
	}


	public float getShoesOther() {
		return shoesOther;
	}


	public void setShoesOther(float shoesOther) {
		this.shoesOther = shoesOther;
	}


	public float getShoesBlack() {
		return shoesBlack;
	}


	public void setShoesBlack(float shoesBlack) {
		this.shoesBlack = shoesBlack;
	}


	public float getShoesWhite() {
		return shoesWhite;
	}


	public void setShoesWhite(float shoesWhite) {
		this.shoesWhite = shoesWhite;
	}


	public float getShoesGray() {
		return shoesGray;
	}


	public void setShoesGray(float shoesGray) {
		this.shoesGray = shoesGray;
	}


	public float getShoesRed() {
		return shoesRed;
	}


	public void setShoesRed(float shoesRed) {
		this.shoesRed = shoesRed;
	}


	public float getShoesGreen() {
		return shoesGreen;
	}


	public void setShoesGreen(float shoesGreen) {
		this.shoesGreen = shoesGreen;
	}


	public float getShoesBlue() {
		return shoesBlue;
	}


	public void setShoesBlue(float shoesBlue) {
		this.shoesBlue = shoesBlue;
	}


	public float getShoesSilver() {
		return shoesSilver;
	}


	public void setShoesSilver(float shoesSilver) {
		this.shoesSilver = shoesSilver;
	}


	public float getShoesYellow() {
		return shoesYellow;
	}


	public void setShoesYellow(float shoesYellow) {
		this.shoesYellow = shoesYellow;
	}


	public float getShoesBrown() {
		return shoesBrown;
	}


	public void setShoesBrown(float shoesBrown) {
		this.shoesBrown = shoesBrown;
	}


	public float getShoesPurple() {
		return shoesPurple;
	}


	public void setShoesPurple(float shoesPurple) {
		this.shoesPurple = shoesPurple;
	}


	public float getShoesPink() {
		return shoesPink;
	}


	public void setShoesPink(float shoesPink) {
		this.shoesPink = shoesPink;
	}


	public float getShoesOrange() {
		return shoesOrange;
	}


	public void setShoesOrange(float shoesOrange) {
		this.shoesOrange = shoesOrange;
	}


	public float getShoesMixColor() {
		return shoesMixColor;
	}


	public void setShoesMixColor(float shoesMixColor) {
		this.shoesMixColor = shoesMixColor;
	}


	public float getShoesOtherColor() {
		return shoesOtherColor;
	}


	public void setShoesOtherColor(float shoesOtherColor) {
		this.shoesOtherColor = shoesOtherColor;
	}


	public float getAccessoryBackPack() {
		return accessoryBackPack;
	}


	public void setAccessoryBackPack(float accessoryBackPack) {
		this.accessoryBackPack = accessoryBackPack;
	}


	public float getAccessorySholderBag() {
		return accessorySholderBag;
	}


	public void setAccessorySholderBag(float accessorySholderBag) {
		this.accessorySholderBag = accessorySholderBag;
	}


	public float getAccessoryHandBag() {
		return accessoryHandBag;
	}


	public void setAccessoryHandBag(float accessoryHandBag) {
		this.accessoryHandBag = accessoryHandBag;
	}


	public float getAccessoryWaistBag() {
		return accessoryWaistBag;
	}


	public void setAccessoryWaistBag(float accessoryWaistBag) {
		this.accessoryWaistBag = accessoryWaistBag;
	}


	public float getAccessoryBox() {
		return accessoryBox;
	}


	public void setAccessoryBox(float accessoryBox) {
		this.accessoryBox = accessoryBox;
	}


	public float getAccessoryPlasticBag() {
		return accessoryPlasticBag;
	}


	public void setAccessoryPlasticBag(float accessoryPlasticBag) {
		this.accessoryPlasticBag = accessoryPlasticBag;
	}


	public float getAccessoryPaperBag() {
		return accessoryPaperBag;
	}


	public void setAccessoryPaperBag(float accessoryPaperBag) {
		this.accessoryPaperBag = accessoryPaperBag;
	}


	public float getAccessoryCart() {
		return accessoryCart;
	}


	public void setAccessoryCart(float accessoryCart) {
		this.accessoryCart = accessoryCart;
	}


	public float getAccessoryKid() {
		return accessoryKid;
	}


	public void setAccessoryKid(float accessoryKid) {
		this.accessoryKid = accessoryKid;
	}


	public float getAccessoryOther() {
		return accessoryOther;
	}


	public void setAccessoryOther(float accessoryOther) {
		this.accessoryOther = accessoryOther;
	}


	public float getActionCalling() {
		return actionCalling;
	}


	public void setActionCalling(float actionCalling) {
		this.actionCalling = actionCalling;
	}


	public float getActionArmStretching() {
		return actionArmStretching;
	}


	public void setActionArmStretching(float actionArmStretching) {
		this.actionArmStretching = actionArmStretching;
	}


	public float getActionChatting() {
		return actionChatting;
	}


	public void setActionChatting(float actionChatting) {
		this.actionChatting = actionChatting;
	}


	public float getActionGathering() {
		return actionGathering;
	}


	public void setActionGathering(float actionGathering) {
		this.actionGathering = actionGathering;
	}


	public float getActionLying() {
		return actionLying;
	}


	public void setActionLying(float actionLying) {
		this.actionLying = actionLying;
	}


	public float getActionCrouching() {
		return actionCrouching;
	}


	public void setActionCrouching(float actionCrouching) {
		this.actionCrouching = actionCrouching;
	}


	public float getActionRunning() {
		return actionRunning;
	}


	public void setActionRunning(float actionRunning) {
		this.actionRunning = actionRunning;
	}


	public float getActionHolding() {
		return actionHolding;
	}


	public void setActionHolding(float actionHolding) {
		this.actionHolding = actionHolding;
	}


	public float getActionPushing() {
		return actionPushing;
	}


	public void setActionPushing(float actionPushing) {
		this.actionPushing = actionPushing;
	}


	public float getActionPulling() {
		return actionPulling;
	}


	public void setActionPulling(float actionPulling) {
		this.actionPulling = actionPulling;
	}


	public float getActionNipThing() {
		return actionNipThing;
	}


	public void setActionNipThing(float actionNipThing) {
		this.actionNipThing = actionNipThing;
	}


	public float getActionPicking() {
		return actionPicking;
	}


	public void setActionPicking(float actionPicking) {
		this.actionPicking = actionPicking;
	}


	public float getActionOther() {
		return actionOther;
	}


	public void setActionOther(float actionOther) {
		this.actionOther = actionOther;
	}


	public float getViewAngleLeft() {
		return viewAngleLeft;
	}


	public void setViewAngleLeft(float viewAngleLeft) {
		this.viewAngleLeft = viewAngleLeft;
	}


	public float getViewAngleRight() {
		return viewAngleRight;
	}


	public void setViewAngleRight(float viewAngleRight) {
		this.viewAngleRight = viewAngleRight;
	}


	public float getViewAngleFront() {
		return viewAngleFront;
	}


	public void setViewAngleFront(float viewAngleFront) {
		this.viewAngleFront = viewAngleFront;
	}


	public float getViewAngleBack() {
		return viewAngleBack;
	}


	public void setViewAngleBack(float viewAngleBack) {
		this.viewAngleBack = viewAngleBack;
	}


	public float getOcclusionLeft() {
		return occlusionLeft;
	}


	public void setOcclusionLeft(float occlusionLeft) {
		this.occlusionLeft = occlusionLeft;
	}


	public float getOcclusionRight() {
		return occlusionRight;
	}


	public void setOcclusionRight(float occlusionRight) {
		this.occlusionRight = occlusionRight;
	}


	public float getOcclusionUp() {
		return occlusionUp;
	}


	public void setOcclusionUp(float occlusionUp) {
		this.occlusionUp = occlusionUp;
	}


	public float getOcclusionDown() {
		return occlusionDown;
	}


	public void setOcclusionDown(float occlusionDown) {
		this.occlusionDown = occlusionDown;
	}


	public float getOcclusionEnvironment() {
		return occlusionEnvironment;
	}


	public void setOcclusionEnvironment(float occlusionEnvironment) {
		this.occlusionEnvironment = occlusionEnvironment;
	}


	public float getOcclusionAccessory() {
		return occlusionAccessory;
	}


	public void setOcclusionAccessory(float occlusionAccessory) {
		this.occlusionAccessory = occlusionAccessory;
	}


	public float getOcclusionObject() {
		return occlusionObject;
	}


	public void setOcclusionObject(float occlusionObject) {
		this.occlusionObject = occlusionObject;
	}


	public float getOcclusionOther() {
		return occlusionOther;
	}


	public void setOcclusionOther(float occlusionOther) {
		this.occlusionOther = occlusionOther;
	}


	@Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
