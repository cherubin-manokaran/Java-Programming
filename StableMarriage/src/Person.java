import java.util.*;

public class Person {
    private final int NOBODY = -1;

    private String name;
    private List<Integer> preferences;
    private List<Integer> prevPreferences;
    private int partner;
    private int position;

    public Person(String name) {
        this.name = name;
        preferences = new ArrayList<Integer>();
        prevPreferences = new ArrayList<Integer>();
        this.partner = NOBODY;
        this.position = 0;
    }
    
    public void setPosition(int position) {
    	this.position = position;
    }
    
    public int getPosition() {
    	return this.position;
    }

    public void erasePartner() {
        partner = NOBODY;
    }

    public boolean hasPartner() {
        return partner != NOBODY;
    }

    public int getPartner() {
        return partner;
    }

    public void setPartner(int partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public boolean hasPreference() {
        return !preferences.isEmpty();
    }

    public int getFirstPreference() {
        return preferences.get(0);
    }
    
    public int getPreference(int index) {
    	return preferences.get(index);
    }
    
    public int getIndexOfPreference(int reference) {
    	return preferences.indexOf(reference);
    }

    public void addPreference(int person) {
        preferences.add(person);
        prevPreferences.add(person);
    }
    
    public void removePreference(int person) {
    	if (this.getIndexOfPreference(person) != -1)
    		preferences.remove(person);
    }

    public List<Integer> getPreferences() {
        return preferences;
    }
    
    public int getPartnerRank() {
        return prevPreferences.indexOf(partner) + 1;
    }
}
