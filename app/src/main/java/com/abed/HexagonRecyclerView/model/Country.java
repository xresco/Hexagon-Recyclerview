
package com.abed.HexagonRecyclerView.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Country implements Parcelable {

    public String name;
    public String capital;
    public List<String> altSpellings = new ArrayList<String>();
    public String relevance;
    public String region;
    public String subregion;
    public int population;
    public String demonym;
    public double area;
    public double gini;
    public List<String> timezones = new ArrayList<String>();
    public List<String> borders = new ArrayList<String>();
    public String nativeName;
    public List<String> callingCodes = new ArrayList<String>();
    public List<String> topLevelDomain = new ArrayList<String>();
    public String alpha2Code;
    public String alpha3Code;
    public List<String> currencies = new ArrayList<String>();
    public List<String> languages = new ArrayList<String>();

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }


    public String getDemonym() {
        return demonym;
    }

    public double getArea() {
        return area;
    }

    public double getGini() {
        return gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<String> getLanguages() {
        return languages;
    }


    protected Country(Parcel in) {
        name = in.readString();
        capital = in.readString();
        in.readStringList(altSpellings);
        relevance = in.readString();
        region = in.readString();
        subregion = in.readString();
        population = in.readInt();
        demonym = in.readString();
        area = in.readDouble();
        gini = in.readDouble();


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(capital);
        dest.writeStringList(altSpellings);
        dest.writeString(relevance);
        dest.writeString(region);
        dest.writeString(subregion);
        dest.writeInt(population);
        dest.writeString(demonym);
        dest.writeDouble(area);
        dest.writeDouble(gini);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

}
