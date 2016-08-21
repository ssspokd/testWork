package testWorkWithDB.Entity;
// Generated 21.08.2016 17:12:33 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name="SERVICE"
)
public class Service  implements java.io.Serializable {


     private int id;
     private String nameService;
     private short maxValue;
     private short minValue;
     private Set paymentses = new HashSet(0);

    public Service() {
    }

	
    public Service(int id, String nameService, short maxValue, short minValue) {
        this.id = id;
        this.nameService = nameService;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
    public Service(int id, String nameService, short maxValue, short minValue, Set paymentses) {
       this.id = id;
       this.nameService = nameService;
       this.maxValue = maxValue;
       this.minValue = minValue;
       this.paymentses = paymentses;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="NAME_SERVICE", nullable=false, length=10)
    public String getNameService() {
        return this.nameService;
    }
    
    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    
    @Column(name="MAX_VALUE", nullable=false)
    public short getMaxValue() {
        return this.maxValue;
    }
    
    public void setMaxValue(short maxValue) {
        this.maxValue = maxValue;
    }

    
    @Column(name="MIN_VALUE", nullable=false)
    public short getMinValue() {
        return this.minValue;
    }
    
    public void setMinValue(short minValue) {
        this.minValue = minValue;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="service")
    public Set getPaymentses() {
        return this.paymentses;
    }
    
    public void setPaymentses(Set paymentses) {
        this.paymentses = paymentses;
    }




}


