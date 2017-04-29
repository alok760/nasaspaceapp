package me.jaxbot.landslidesstrike;

/**
 * Created by pc on 4/29/2017.
 */

public class Webclass {
    String countryname;
    String date;
    int injuries;
    String source_link;

    public String getSource_link() {
        return source_link;
    }

    public void setSource_link(String source_link) {
        this.source_link = source_link;
    }

    public String getCountryname() {
        return countryname;

    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getInjuries() {
        return injuries;
    }

    public void setInjuries(int injuries) {
        this.injuries = injuries;
    }
}
