package app.airlines.domain.dictionary;

import app.airlines.domain.AbstractDictionary;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "dict_postal_index")
@AttributeOverride(name = "name", column = @Column(name = "postal_code"))
public class PostalIndex extends AbstractDictionary {

    public String getPostalCode() {
        return getName();
    }

    public void setPostalCode(String postalCode) {
        setName(postalCode);
    }

}
