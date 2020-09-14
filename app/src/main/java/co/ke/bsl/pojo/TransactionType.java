package co.ke.bsl.pojo;
// Generated Dec 15, 2015 12:42:43 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Transactionstype generated by hbm2java
 */

public class TransactionType  implements java.io.Serializable {


     private Integer id;
     private Transaction transactions;
     private Double minAmount;
     private Double maxAmount;
     private Double dailyMaximum;
     private Integer chargeId;
     private Integer commissionId;
     private Date dateCreated;
     private Set<Service> serviceses = new HashSet<Service>(0);

    public TransactionType() {
    }

    public TransactionType(Transaction transactions, Double minAmount, Double maxAmount, Double dailyMaximum, Integer chargeId, Integer commissionId, Date dateCreated, Set<Service> serviceses) {
       this.transactions = transactions;
       this.minAmount = minAmount;
       this.maxAmount = maxAmount;
       this.dailyMaximum = dailyMaximum;
       this.chargeId = chargeId;
       this.commissionId = commissionId;
       this.dateCreated = dateCreated;
       this.serviceses = serviceses;
    }
   
     

}


