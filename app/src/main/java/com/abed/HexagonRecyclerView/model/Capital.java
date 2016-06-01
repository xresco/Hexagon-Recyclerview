
package com.abed.HexagonRecyclerView.model;

import java.util.ArrayList;
import java.util.List;

public class Capital {

    public String name;
    public String capital;
    public List<String> altSpellings = new ArrayList<String>();
    public String relevance;
    public String region;
    public String subregion;
    public Integer population;
    public List<Integer> latlng = new ArrayList<Integer>();
    public String demonym;
    public Integer area;
    public Integer gini;
    public List<String> timezones = new ArrayList<String>();
    public List<String> borders = new ArrayList<String>();
    public String nativeName;
    public List<String> callingCodes = new ArrayList<String>();
    public List<String> topLevelDomain = new ArrayList<String>();
    public String alpha2Code;
    public String alpha3Code;
    public List<String> currencies = new ArrayList<String>();
    public List<String> languages = new ArrayList<String>();

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
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

    public Integer getPopulation() {
        return population;
    }

    public List<Integer> getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public Integer getArea() {
        return area;
    }

    public Integer getGini() {
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




}
