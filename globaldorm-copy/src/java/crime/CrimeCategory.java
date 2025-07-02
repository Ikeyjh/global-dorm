package crime;

import com.google.gson.annotations.SerializedName;
import java.io.IOException;

public enum CrimeCategory {
    @SerializedName("anti-social-behaviour") ANTI_SOCIAL_BEHAVIOUR,
    @SerializedName("bicycle-theft") BICYCLE_THEFT,
    @SerializedName("burglary") BURGLARY,
    @SerializedName("criminal-damage-arson") CRIMINAL_DAMAGE_ARSON,
    @SerializedName("drugs") DRUGS,
    @SerializedName("other-crime") OTHER_CRIME,
    @SerializedName("other-theft") OTHER_THEFT,
    @SerializedName("possession-of-weapons") POSSESSION_OF_WEAPONS,
    @SerializedName("public-order") PUBLIC_ORDER,
    @SerializedName("robbery") ROBBERY,
    @SerializedName("shoplifting") SHOPLIFTING,
    @SerializedName("theft-from-the-person") THEFT_FROM_THE_PERSON,
    @SerializedName("vehicle-crime") VEHICLE_CRIME,
    @SerializedName("violent-crime") VIOLENT_CRIME;

    public String toValue() {
        switch (this) {
            case ANTI_SOCIAL_BEHAVIOUR: return "anti-social-behaviour";
            case BICYCLE_THEFT: return "bicycle-theft";
            case BURGLARY: return "burglary";
            case CRIMINAL_DAMAGE_ARSON: return "criminal-damage-arson";
            case DRUGS: return "drugs";
            case OTHER_CRIME: return "other-crime";
            case OTHER_THEFT: return "other-theft";
            case POSSESSION_OF_WEAPONS: return "possession-of-weapons";
            case PUBLIC_ORDER: return "public-order";
            case ROBBERY: return "robbery";
            case SHOPLIFTING: return "shoplifting";
            case THEFT_FROM_THE_PERSON: return "theft-from-the-person";
            case VEHICLE_CRIME: return "vehicle-crime";
            case VIOLENT_CRIME: return "violent-crime";
        }
        return null;
    }

    public static CrimeCategory forValue(String value) throws IOException {
        if (value.equals("anti-social-behaviour")) return ANTI_SOCIAL_BEHAVIOUR;
        if (value.equals("bicycle-theft")) return BICYCLE_THEFT;
        if (value.equals("burglary")) return BURGLARY;
        if (value.equals("criminal-damage-arson")) return CRIMINAL_DAMAGE_ARSON;
        if (value.equals("drugs")) return DRUGS;
        if (value.equals("other-crime")) return OTHER_CRIME;
        if (value.equals("other-theft")) return OTHER_THEFT;
        if (value.equals("possession-of-weapons")) return POSSESSION_OF_WEAPONS;
        if (value.equals("public-order")) return PUBLIC_ORDER;
        if (value.equals("robbery")) return ROBBERY;
        if (value.equals("shoplifting")) return SHOPLIFTING;
        if (value.equals("theft-from-the-person")) return THEFT_FROM_THE_PERSON;
        if (value.equals("vehicle-crime")) return VEHICLE_CRIME;
        if (value.equals("violent-crime")) return VIOLENT_CRIME;
        throw new IOException("Cannot deserialize Welcome6Category");
    }
}